package poly.controller;
import java.io.IOException;

/*
 * API에서 받아온 정보 몽고로 처리하는 로직
 * */
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IEmpAttService;
import poly.util.CmmUtil;

@Controller
public class EmpAttController {

	// 로거
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "EmpAttService")
	IEmpAttService empAttService;

	@RequestMapping(name="imgCheckTime")
	public String imgCheckTime(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception, IOException{
		
		log.info("imgCheckTime Process start!!");		
		log.info("imgCheckTime Process End!!");
		
		return "/opencv/imgCheckTime";
	}
	
	// 얼굴 검색 시작
	// 여기서 API 서버에 접속하여 데이터를 받음
	@RequestMapping(value="imgCheckTest")
	public String imgCheckTest(HttpServletRequest request, HttpServletResponse response, ModelMap model) 
			throws Exception, IOException {
		log.info("img Check Process start!!"); 
		
		String checktime = CmmUtil.nvl(request.getParameter("time")).toString(); // 언제까지 할지 정하는 시간
		log.info("checktime : " + checktime);
		String lateTime = CmmUtil.nvl(request.getParameter("lateTime")).toString(); // 지각하는 기준을 잡는 시간
		log.info("lateTime : " + lateTime);
		String ascTime = CmmUtil.nvl(request.getParameter("ascTime")).toString(); // 강제 종료 인터럽트 시간
		log.info("ascTime : " + ascTime);

		
		// 만약 종료 시간이 null 이면 0을 대입한다.
		if(ascTime.equals("")) {
			ascTime = "0";
		}
		
		// API 서버 접속 용 URL 우분투 서버쪽 ip와 포트 번호 맞추기
		// 만약 로컬이였으면 127.0.0.1
		// String url = "http://15.164.139.197:5002"; //AWS 서버 
		String url = "http://192.168.0.84:5001"; // 슬레이트 pc 연결
		// String url = "http://127.0.0.1:5001"; // 로컬 우분투 연결
		
		String api = "/imgCheckDevice?&";
		String empCheck = "empno=";
		String addres = url + api + empCheck;
		
		// url 보내고 처리하느 메서드
		int num = empAttService.empAttProc(addres, checktime, ascTime, lateTime);
		
		if(num == 0) {
			log.info("Json Error!!!");
		} else {
			log.info("GOOD");
		}
		
		return "/opencv/imgCheck";
	}

}
