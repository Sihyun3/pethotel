package pethotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import pethotel.dto.CompanyDto;
import pethotel.dto.ConsultingDto;
import pethotel.service.PetHotelService;
@Slf4j
@Controller
public class PetHotelController {
	@Autowired
	private PetHotelService petHotelService;
	//----------------------------------여기서부터 QnA-----------------------------
	@GetMapping("/register")
	public ModelAndView consulting() throws Exception {
		ModelAndView mv = new ModelAndView("sample2.html");
		return mv;
	}

	@PostMapping("/register/12")
	public String insertConsulting(ConsultingDto consultingDto) throws Exception {
		petHotelService.insertconsulting(consultingDto);
		return ("redirect:/list");
	}

	@PostMapping("/reply/1234")
	public String insertreply(ConsultingDto consultingDto) throws Exception {
		log.debug(consultingDto.getReply());
		petHotelService.insertreply(consultingDto);
		return ("redirect:/list");
	}

	@GetMapping("/openconsultDetail.do")
	public ModelAndView detail(@RequestParam int consultingIdx) throws Exception {
		ModelAndView mv = new ModelAndView("sample1.html");
		ConsultingDto consultingDto = petHotelService.detail(consultingIdx);
		log.debug(consultingDto.getConsultingTitle());
		mv.addObject("detail", consultingDto);
		return mv;
	}

	@GetMapping("/list")
	public ModelAndView consultinglist() throws Exception {
		ModelAndView mv = new ModelAndView("sample.html");
		List<ConsultingDto> list = petHotelService.consultinglist();
		mv.addObject("list", list);
		return mv;
	}
	//----------------------------------끝----------------------------------------
	
	
	
	//--------------------------------업체 등록-----------------------------------------
	@GetMapping("/company")
	public ModelAndView companyregist() throws Exception {
		ModelAndView mv = new ModelAndView("Business_registration.html");
		return mv;
	}
	@PostMapping("/company/regist")
	public String insertcompany(CompanyDto companydto) throws Exception {
		log.debug(companydto.getCompanyName());
		petHotelService.insertcompany(companydto);
		return ("redirect:/company");
	}
}
