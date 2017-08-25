package com.anticovi.mango;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anticovi.mango.member.domain.MemberCommand;
import com.anticovi.mango.member.service.MemberService;



@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	
}
