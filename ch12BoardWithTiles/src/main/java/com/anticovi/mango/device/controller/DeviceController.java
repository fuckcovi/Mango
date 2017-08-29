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
		List<DeviceCommand> deviceList = deviceService.allDeviceList();
		return new ModelAndView("deviceMain","deviceList", deviceList);
	}
	@RequestMapping(value="/device/modifyDeviceInfo.do",method=RequestMethod.GET)
	public ModelAndView modifyDeviceInfoForm(@RequestParam int di_seq,@RequestParam int d_seq){
		DeviceInfoCommand deviceInfo = deviceService.selectDeviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modifyDeviceInfoForm");
		mav.addObject("deviceInfo", deviceInfo);
		mav.addObject("di_seq", di_seq);
		return mav;
	}
	@RequestMapping(value="/device/modifyDeviceInfo.do",method=RequestMethod.POST)
	public ModelAndView modifyDeviceInfo(@RequestParam int di_seq,@RequestParam int d_seq,@ModelAttribute("deviceInfoCommand")@Valid DeviceInfoCommand deviceInfoCommand, BindingResult result){
		DeviceInfoCommand deviceInfo = deviceService.selectDeviceInfo(d_seq,di_seq);
		if(log.isDebugEnabled()){
			log.debug("<<정보수정요청 - deviceInfoCommand>> : " + deviceInfoCommand);
		}
		if(result.hasFieldErrors("di_color") ){
			deviceInfoCommand.setDi_imagename1(deviceInfo.getDi_imagename1());
			deviceInfoCommand.setDi_imagename2(deviceInfo.getDi_imagename2());
			deviceInfoCommand.setDi_imagename3(deviceInfo.getDi_imagename3());
			deviceInfoCommand.setDi_imagename4(deviceInfo.getDi_imagename4());
			deviceInfoCommand.setDi_imagename5(deviceInfo.getDi_imagename5());
			return modifyDeviceInfoForm(deviceInfoCommand.getDi_seq(),deviceInfoCommand.getD_seq());
		}
		// 원래의 파일 호출
		if(deviceInfoCommand.getDi_imagefile1().isEmpty()){
			deviceInfoCommand.setDi_image1(deviceInfo.getDi_image1());
			deviceInfoCommand.setDi_image2(deviceInfo.getDi_image2());
			deviceInfoCommand.setDi_image3(deviceInfo.getDi_image3());
			deviceInfoCommand.setDi_image4(deviceInfo.getDi_image4());
			deviceInfoCommand.setDi_image5(deviceInfo.getDi_image5());
			deviceInfoCommand.setDi_imagename1(deviceInfo.getDi_imagename1());
			deviceInfoCommand.setDi_imagename2(deviceInfo.getDi_imagename2());
			deviceInfoCommand.setDi_imagename3(deviceInfo.getDi_imagename3());
			deviceInfoCommand.setDi_imagename4(deviceInfo.getDi_imagename4());
			deviceInfoCommand.setDi_imagename5(deviceInfo.getDi_imagename5());
		}
			deviceService.updateDeviceInfo(deviceInfoCommand);
		return deviceMain();
	}
	
	@RequestMapping(value="/device/deviceInfo.do",method=RequestMethod.GET)
	public ModelAndView deviceInfo(@RequestParam int d_seq,@RequestParam int di_seq){
		DeviceCommand device = deviceService.deviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deviceInfo");
		mav.addObject("device", device);
		return mav;
	}
	
	@RequestMapping("/device/imageView1.do")
	public ModelAndView viewImage1(@RequestParam int d_seq,@RequestParam int di_seq){
		DeviceCommand device = deviceService.deviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",device.getDi_image1());
		mav.addObject("filename", device.getDi_imagename1());
		return mav;
	}
	@RequestMapping("/device/imageView2.do")
	public ModelAndView viewImage2(@RequestParam int d_seq,@RequestParam int di_seq){
		DeviceCommand device = deviceService.deviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",device.getDi_image2());
		mav.addObject("filename", device.getDi_imagename2());
		return mav;
	}
	@RequestMapping("/device/imageView3.do")
	public ModelAndView viewImage3(@RequestParam int d_seq,@RequestParam int di_seq){
		DeviceCommand device = deviceService.deviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",device.getDi_image3());
		mav.addObject("filename", device.getDi_imagename3());
		return mav;
	}
	@RequestMapping("/device/imageView4.do")
	public ModelAndView viewImage4(@RequestParam int d_seq,@RequestParam int di_seq){
		DeviceCommand device = deviceService.deviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",device.getDi_image4());
		mav.addObject("filename", device.getDi_imagename4());
		return mav;
	}
	@RequestMapping("/device/imageView5.do")
	public ModelAndView viewImageTeamLogo(@RequestParam int d_seq,@RequestParam int di_seq){
		DeviceCommand device = deviceService.deviceInfo(d_seq,di_seq);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",device.getDi_image5());
		mav.addObject("filename", device.getDi_imagename5());
		return mav;
	}
}
