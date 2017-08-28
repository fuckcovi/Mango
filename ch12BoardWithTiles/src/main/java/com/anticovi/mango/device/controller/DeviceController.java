package com.anticovi.mango.device.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.service.DeviceService;
import com.anticovi.mango.member.domain.MemberCommand;

@Controller
public class DeviceController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private DeviceService deviceService;
	
	@ModelAttribute("deviceCommand")
	public DeviceCommand initCommand(){
		return new DeviceCommand();
	}
	@RequestMapping("/device/device.do")
	public ModelAndView deviceMain(){
		List<DeviceCommand> deviceList = deviceService.allDeviceList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deviceMain");
		mav.addObject("deviceList", deviceList);
		return mav;
	}
	@RequestMapping(value="/device/registerDevice.do",method=RequestMethod.GET)
	public String registerDeviceForm(){
		return "registerDeviceForm";
	}
	@RequestMapping(value="/device/registerDevice.do",method=RequestMethod.POST)
	public String registerDevice(@ModelAttribute("deviceCommand")@Valid DeviceCommand deviceCommand, BindingResult result){
		if(log.isDebugEnabled()){
			log.debug("<<등록요청 - deviceCommand>> : " + deviceCommand);
		}
		if(result.hasFieldErrors("d_name") || result.hasFieldErrors("d_modelnum") || 
				result.hasFieldErrors("d_type") || 
				result.hasFieldErrors("d_explain")){
			return registerDeviceForm();
		}
		if(deviceCommand.getD_regdate()==null){
			System.out.println("출시예정으로 등록");
			deviceCommand.setD_regdate(null);
		}
		deviceService.insertDevice(deviceCommand);
		return "redirect:/device/device.do";
	}
}
