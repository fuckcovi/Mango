package com.anticovi.mango.device.controller;

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

import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;
import com.anticovi.mango.device.service.DeviceService;
import com.sun.javafx.sg.prism.NGShape.Mode;

@Controller
public class DeviceController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private DeviceService deviceService;
	
	@ModelAttribute("deviceCommand")
	public DeviceCommand initCommand(){
		return new DeviceCommand();
	}
	@ModelAttribute("deviceInfoCommand")
	public DeviceInfoCommand initCommand2(){
		return new DeviceInfoCommand();
	}
	@RequestMapping("/device/device.do")
	public ModelAndView deviceMain(){
		List<DeviceCommand> deviceList = deviceService.allDeviceList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deviceMain");
		mav.addObject("deviceList", deviceList);
		System.out.println(deviceList);
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
		deviceService.insertDevice(deviceCommand);
		return "redirect:/device/device.do";
	}
	@RequestMapping(value="/device/registerDeviceInfo.do",method=RequestMethod.GET)
	public ModelAndView registerDeviceInfoForm(@RequestParam int d_seq){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerDeviceInfoForm");
		mav.addObject("d_seq", d_seq);
		return mav;
	}
	@RequestMapping(value="/device/registerDeviceInfo.do",method=RequestMethod.POST)
	public ModelAndView registerDeviceInfo(@ModelAttribute("deviceInfoCommand")@Valid DeviceInfoCommand deviceInfoCommand, BindingResult result){
		if(log.isDebugEnabled()){
			log.debug("<<정보등록요청 - deviceInfoCommand>> : " + deviceInfoCommand);
		}
		if(result.hasFieldErrors("di_color") ){
			return registerDeviceInfoForm(deviceInfoCommand.getD_seq());
		}
		deviceService.insertDeviceInfo(deviceInfoCommand);
		return deviceMain();
	}
	
	@RequestMapping(value="/device/diviceInfo.do",method=RequestMethod.GET)
	public String diviceInfo(){
		return "diviceInfo";
	}
}
