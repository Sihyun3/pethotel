package pethotel.service;

import java.util.List;

import pethotel.dto.ConsultingDto;

public interface PetHotelService {
//	List<ConsultingDto>insertconsulting ()throws Exception;


	void insertconsulting(ConsultingDto consultingDto)throws Exception;
	void insertreply(ConsultingDto consultingDto)throws Exception;
	ConsultingDto detail(int consultingIdx) throws Exception;
	List<ConsultingDto> consultinglist()throws Exception;
	
	
}
