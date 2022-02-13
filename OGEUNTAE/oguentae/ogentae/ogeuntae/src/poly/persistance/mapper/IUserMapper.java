package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface IUserMapper {
	// 로그인 확인
	UserDTO getLoginInfo(UserDTO uDTO);
	// 회원 가입 중복 체크용
	UserDTO getUserExists(UserDTO pDTO) throws Exception;
	// 회원가입 확인용 
	int insertUserInfo(UserDTO pDTO) throws Exception;
	// 가입 후 정보 넘겨주는 매퍼 
	UserDTO getUserInfo(UserDTO rDTO) throws Exception;
	// 유저 정보 찾기-이메일 확인
	UserDTO getFindUserInfo(UserDTO userpDTO) throws Exception;
	// 유저 정보 찾아서 비밀번호 변경하기
	int updateAdminInfo(UserDTO pDTO) throws Exception;

	
}
