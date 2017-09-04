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
	@RequestMapping(value="/plan/registerCpForm.do",method=RequestMethod.GET)
	public String registerCpForm(){
		return "registerCpForm";
	}
	@RequestMapping(value="/plan/registerCpForm.do",method=RequestMethod.POST)
	public String registerCp(@ModelAttribute("callingPlanCommand")@Valid CallingPlanCommand callingPlanCommand,BindingResult result,Model model){
		if(log.isDebugEnabled()){
			log.debug("<<요금제 등록요청 - callingPlanCommand>> : " + callingPlanCommand);
		}
		if(result.hasFieldErrors("cp_name") || result.hasFieldErrors("cp_category") ||
				result.hasFieldErrors("cp_modelnum") || result.hasFieldErrors("cp_data") ||
				result.hasFieldErrors("cp_price") || result.hasFieldErrors("cp_message") ||
				result.hasFieldErrors("cp_call")){
			return registerCpForm();
		}
		callingPlanService.registerCallingPlan(callingPlanCommand);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", "");
		List<CallingPlanCommand> callingPlanList = callingPlanService.allCpList(map);
		model.addAttribute("callingPlanList", callingPlanList);
		return "redirect:/plan/callingPlan.do";
	}
	@RequestMapping("/plan/cpDetail.do")
	public String cpDetail(@RequestParam int cp_seq, Model model){
		CallingPlanCommand callingPlan = callingPlanService.selectCallingPlan(cp_seq);
		model.addAttribute("callingPlan", callingPlan);
		return "cpDetail";
	}
	@RequestMapping("/plan/serDetail.do")
	public String serDetail(@RequestParam int cp_seq, Model model){
		CallingPlanCommand callingPlan = callingPlanService.selectCallingPlan(cp_seq);
		model.addAttribute("callingPlan", callingPlan);
		return "serDetail";
	}
	@RequestMapping("/plan/imageView.do")
	public ModelAndView viewImage(@RequestParam int cp_seq){
		CallingPlanCommand callingPlan = callingPlanService.selectCallingPlan(cp_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",callingPlan.getCp_detailimage());
		mav.addObject("filename", callingPlan.getCp_detailimagename());
		return mav;
	}
	@RequestMapping("/plan/calling.do")
	public String cpCallingMain(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category","모바일");
		List<CallingPlanCommand> callingPlanList = callingPlanService.allCpList(map);
		model.addAttribute("callingPlanList", callingPlanList);
		return "cpCallingMain";
	}
	@RequestMapping("/plan/service.do")
	public String cpServiceMain(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category","부가서비스");
		List<CallingPlanCommand> callingPlanList = callingPlanService.allCpList(map);
		model.addAttribute("callingPlanList", callingPlanList);
		return "cpServiceMain";
	}
	@RequestMapping("/plan/custom.do")
	public String cpCustomnMain(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category","");
		List<CallingPlanCommand> callingPlanList = callingPlanService.allCpList(map);
		model.addAttribute("callingPlanList", callingPlanList);
		return "cpCustomnMain";
	}
		
			
}
