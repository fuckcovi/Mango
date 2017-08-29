package com.anticovi.mango.membership.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MembershipController {
	
	private Logger log = Logger.getLogger(this.getClass());
	

	@RequestMapping(value="/membership/join.do",method=RequestMethod.GET)
	public String membershipReg(){
	
		return "membershipReg";
	}
	
	
	@RequestMapping(value="/membership/benefit.do",method=RequestMethod.GET)
	public String benefit(){
		
		
		return "benefit";
	}
	
	@RequestMapping(value="/membership/agreement.do",method=RequestMethod.GET)
	public String agree(){
		
		
		return "agreement";
	}
	
	@RequestMapping(value="/membership/infoInput.do",method=RequestMethod.GET)
	public String infoInput(){
		
		
		return "infoInput";
	}
	
}
