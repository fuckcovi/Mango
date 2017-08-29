package com.anticovi.mango.callingPlan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticovi.mango.callingPlan.domain.CallingPlanCommand;
import com.anticovi.mango.callingPlan.service.CallingPlanService;
import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;
import com.anticovi.mango.device.service.DeviceService;
import com.anticovi.mango.member.domain.MemberCommand;

@Controller
public class CallingPlanController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CallingPlanService callingPlanService;
	
	@ModelAttribute("callingPlanCommand")
	public CallingPlanCommand initCommand(){
		return new CallingPlanCommand();
	}
	
	@RequestMapping("/plan/callingPlan.do")
	public String callingPlanMain(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category","");
		List<CallingPlanCommand> callingPlanList = callingPlanService.allCpList(map);
		model.addAttribute("callingPlanList", callingPlanList);
		return "callingPlanMain";
	}
}
