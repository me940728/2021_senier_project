package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MailDTO;
import poly.dto.UserDTO;
import poly.service.IMailService;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;
import poly.util.RamdomMail;

@Controller
public class UserController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "UserService")
	private IUserService userService;
	@Resource(name = "MailService")
	private IMailService mailService;

	// 관리자 로그인 페이지 접속
	@RequestMapping(value = "user/login")
	public String userLogin(HttpServletRequest request, ModelMap model) {

		log.info(this.getClass() + "O_GEUNTAE Login start!!");
		log.info(this.getClass() + "O_GEUNTAE Login end!!");

		return "/user/login";
	}

	// 세션 확인 후 리다이렉션 해주는 매핑
	@RequestMapping(value = "user/sessioCheck")
	public String userSessionCheck(HttpServletRequest request, HttpServletResponse response, Model model) {

		log.info(this.getClass() + "session null Start");

		String msg = "로그인을 해주세요";
		String url = "/user/login.do";

		log.info("url : " + url);
		log.info("msg : " + msg);

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		log.info(this.getClass() + "session null end!!");

		return "/user/redirect";
	}

	// 관리자 로그인 처리 매퍼
	@RequestMapping(value = "user/userLoginProc.do")
	public String userLoginProc(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
		log.info(this.getClass() + "userLoginProc start!!");

		String email = CmmUtil.nvl(request.getParameter("userEmail"));
		// password 받고 Hash로 암호화 한다음 널 체크 하여 변수에 대입
		String pwd = CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("password")));

		UserDTO uDTO = new UserDTO();

		uDTO.setAemail(email);
		uDTO.setApw(pwd);

		uDTO = userService.getLoginInfo(uDTO);

		log.info("uDTO null?" + (uDTO == null));
		String msg = "";
		String url = "";

		if (uDTO == null) {
			msg = "로그인 실패";
			url = "/user/login.do";
		} else {
			log.info("uDTO AEMAIL : " + uDTO.getAemail());
			log.info("uDTO PWD : " + uDTO.getApw());
			log.info("uDTO NAME : " + uDTO.getAname());

			msg = "로그인 성공";
			url = "/opencvIndex.do";
			session = request.getSession();
			session.setAttribute("aemail", uDTO.getAemail());
			session.setAttribute("aname", uDTO.getAname());
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		log.info(this.getClass() + "user/userLoginProc end!!");

		return "/user/redirect";
	}

	// 로그아웃 처리 메퍼
	@RequestMapping(value = "user/logOut.do")
	public String logOut(HttpSession session, Model model) throws Exception {

		log.info(this.getClass() + "user/logOut start!!");

		String msg = "";
		String url = "";
		msg = "로그아웃 성공";
		url = "/user/login.do";

		session.invalidate(); // 세션 정보 초기화

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		log.info(this.getClass() + "user/loginOut end!!");

		return "/user/redirect";
	}

	// 관리자 등록 페이지 이동 매퍼
	@RequestMapping(value = "user/regAdmin.do")
	public String RegAdmin() throws Exception {

		log.info(this.getClass() + "regAdmin Page start!!");

		log.info(this.getClass() + "regAdmin Page end!!");

		return "/user/regAdmin";
	}

	// 관리자 찾기 페이지
	@RequestMapping(value = "user/findAdminPage.do")
	public String FindAdminPage(HttpServletRequest request, ModelMap model) throws Exception {

		log.info(this.getClass() + "regAdmin Page start!!");

		log.info(this.getClass() + "regAdmin Page end!!");

		return "/user/findAdmin";
	}

	// 관리자 찾기 메일 발송
	@RequestMapping(value = "user/findAdminMail.do")
	public String FindAdminMail(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {

		log.info(this.getClass() + "regAdmin Page start!!");
		
		session.invalidate(); // 세션 정보 초기화
		
		String email = CmmUtil.nvl(request.getParameter("aEmail"));
		log.info("eamail : " + email);
		UserDTO userpDTO = new UserDTO();
		String msg = "";
		String url = "";

		userpDTO.setAemail(email);

		UserDTO rDTO = new UserDTO();
		rDTO = userService.getFindUserInfo(userpDTO);
		String emailForDB = rDTO.getAemail();

		log.info("email : " + email);
		log.info("rDTO.getEmail : " + emailForDB);

		if (emailForDB == null) {
			log.info("null : " + emailForDB);
			msg = "가입된 회원이 없습니다.";
			url = "/user/login.do";
		} else {

			String title = "오근태에서 인증메일을 보내드립니다.";
			MailDTO pDTO = new MailDTO();

			pDTO.setTitle(title);
			pDTO.setToMail(email);

			String contents = RamdomMail.SendRamdomMail();
			pDTO.setContents(contents);
			
			session = request.getSession();
			session.setAttribute("random", contents);
			session.setAttribute("sessionEmail", emailForDB);

			log.info("random str : " + contents);

			mailService.doSendMail(pDTO);

			msg = "메일 발송을 완료 하였습니다.";
			url = "/user/randomCheck.do";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		

		log.info(this.getClass() + "regAdmin Page end!!");

		return "/user/redirect";
	}

	// 인증번호 확인 창
	@RequestMapping(value = "user/randomCheck.do")
	public String randomCheck() throws Exception {

		log.info(this.getClass() + "regAdmin Page start!!");

		log.info(this.getClass() + "regAdmin Page end!!");

		return "/user/randomCheck";
	}

	// 관리자 비밀번호 변경 페이지
	@RequestMapping(value = "user/changeAdminPwd.do")
	public String changeAdminPwd() throws Exception {

		log.info(this.getClass() + "regAdmin Page start!!");

		log.info(this.getClass() + "regAdmin Page end!!");

		return "/user/changeAdminPwd";
	}

	// 관리자 비밀번호 변경 작업
	@RequestMapping(value = "user/changeAdminPwdProc.do")
	public String changeAdminPwdProc(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {

		log.info(this.getClass() + "regAdmin Page start!!");
		
		
		String email = CmmUtil.nvl(session.getAttribute("sessionEmail").toString());
		session.invalidate(); // 세션 정보 초기화
		String pwd = CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("password")));
		log.info("email : " + email);
		log.info("pwd : " + pwd);
		
		UserDTO pDTO = new UserDTO();
		pDTO.setAemail(email);
		pDTO.setApw(pwd);
		
		int success = userService.updateAdminInfo(pDTO);
		
		String msg ="";
		String url = "";
		
		if(success == 1) {
			msg = "정보 변경이 완료되었습니다. 로그인 해주세요.";
			url = "/user/login.do";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass() + "regAdmin Page end!!");

		return "user/redirect";
	}

	// 관리자 등록 처리(가입 처리 프로세스)
	@RequestMapping(value = "user/regAdminProc")
	public String RegAdminProc(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass() + "regAdmin Proc start!!");

		String msg = "";
		String url = "";
		final String check = "940728";

		UserDTO pDTO = null;
		int res = 0; // 데이터 들어갔나 확인용

		try {

			String aname = CmmUtil.nvl(request.getParameter("aName"));
			String aemail = CmmUtil.nvl(request.getParameter("aEmail"));
			String apw = CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("password")));
			String checkNum = CmmUtil.nvl(request.getParameter("checkNum"));

			log.info("aname : " + aname);
			log.info("aemail : " + aemail);
			log.info("password(hashOK) : " + apw);
			log.info("checkNum : " + checkNum);

			// 아무나 가입하지 못하도록
			if (checkNum.equals(check)) {

				log.info("인증번호 이상없음");

				pDTO = new UserDTO();
				log.info("DTO 메모리 올림 CHECK!!");
				// 디티오 변수에 저장
				pDTO.setAname(aname);
				pDTO.setAemail(aemail);
				pDTO.setApw(apw);

				// 비즈니스 로직 실행 디티오 변수에 저장된 값들을 서비스에 넘겨 JDBC를 통해 mySQL로 결국 넘길 거임
				res = userService.insertUserInfo(pDTO);

				log.info("res 0이면 문제 발생 : " + res);

				if (res == 1) { // 리턴 값이 1이면 성공이기 때문에 실행
					msg = "관리자 등록이 완료되었습니다.";
					url = "/user/login.do";

					log.info("가입자 이름은 : " + pDTO.getAname());
				} else { // 실패하면 실행
					msg = "이미 등록이 되어있습니다. : ";
					url = "/user/regAdmin.do";
					log.info("실패");
				}
			} else {
				log.info("인증번호 틀림");
				msg = "인증번호를 확인해주세요 : ";
				url = "/user/regAdmin.do";

			}
		} catch (Exception e) {
			log.info(e.toString());
			e.printStackTrace();

		} finally {
			log.info(this.getClass() + " regAdmin Proc end!!");
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			pDTO = null;
		}

		return "/user/redirect";
	}

}
