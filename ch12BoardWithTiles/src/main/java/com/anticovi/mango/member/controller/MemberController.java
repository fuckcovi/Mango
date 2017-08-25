package com.anticovi.mango.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticovi.mango.member.domain.MemberCommand;
import com.anticovi.mango.member.service.MemberService;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@ModelAttribute("memberCommand")
	public MemberCommand initCommand(){
		return new MemberCommand();
	}
	
	@RequestMapping(value="/member/join.do",method=RequestMethod.GET)
	public String memberJoinForm(){
		return "memberJoinForm";
	}
	@RequestMapping(value="/member/join.do",method=RequestMethod.POST)
	public String memberJoin(@ModelAttribute("memberCommand")@Valid MemberCommand memberCommand, BindingResult result){
		if(log.isDebugEnabled()){
			log.debug("<<회원가입 요청한  - memberCommand>> : " + memberCommand);
		}
		if(result.hasFieldErrors("m_id") || result.hasFieldErrors("m_name") || 
				result.hasFieldErrors("m_pw") || result.hasFieldErrors("m_birth") || 
				result.hasFieldErrors("m_phone1") ||result.hasFieldErrors("m_phone2") ||result.hasFieldErrors("m_phone3") ||
				result.hasFieldErrors("m_address1")){
			return memberJoinForm();
		}
		
		memberService.insertMember(memberCommand);
		return "memberJoin";
	}
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String memberLogin(){
		return "memberLoginForm";
	}
	
	@RequestMapping(value="/member/confirmId.do")
	@ResponseBody
	public Map<String, String> confirmId(@RequestParam("m_id")String m_id){
		if(log.isDebugEnabled()){
			log.debug("<<중복체크 중인 id>>> : " + m_id);
		}
		Map<String, String> map = new HashMap<String, String>();
		MemberCommand member = memberService.selectMemberForId(m_id);
		
		if(member != null){
			map.put("result", "idDuplicated");
		}else{
			map.put("result", "idNotFound");
		}
		return map;
	}
}
