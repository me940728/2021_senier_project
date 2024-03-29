package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.AttAnalysDTO;
import poly.dto.EmpAttDTO;

@Mapper("EmpAttMapper")
public interface IEmpAttMapper {
	// 출근 직원 정보 불러오는 기능
	List<AttAnalysDTO> getAttInfo();
	// empno를 가져오는 기능
	List<EmpAttDTO> getEmpno();
	// 출근 시간을 저장하는 메퍼
	int insertEmpAttTime(EmpAttDTO pDTO);
	// 직원 총수 구하는 메서드
	AttAnalysDTO getEmpCount();
	//직원 정보 디비에 최근 출근 정보 삽입을 위한 쿼리
	int upSertAttTime(EmpAttDTO pDTO);
	// 하루에 중복 출근 하는 사람 없는 지 확인
	EmpAttDTO getEmpAttExists(EmpAttDTO pDTO);

}
