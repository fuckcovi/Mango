package com.anticovi.mango.member.controller;

import java.util.HashMap;
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
	
	// 약관동의
	@RequestMapping(value="/member/terms.do", method=RequestMethod.GET)
	public String memberTermsForm() {
		return "/member/memberTermsForm";
	}
	
	// 회원가입
	@RequestMapping(value="/member/join.do",method=RequestMethod.GET)
	public String memberJoinForm(){
		return "/member/memberJoinForm";
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
	
	// 로그인
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String memberLoginForm(){
		return "memberLoginForm";
	}
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String memberLogin(@ModelAttribute("memberCommand")@Valid MemberCommand memberCommand, BindingResult result, HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("<<로그인 요청한  - memberCommand>> : " + memberCommand);
		}
		if(result.hasFieldErrors("m_id") ||
				result.hasFieldErrors("m_pw") ){
			return memberLoginForm();
		}
		String user_id = memberCommand.getM_id();
		String user_pw = memberCommand.getM_pw();
		try{
			MemberCommand member = memberService.selectMemberForId(user_id);
			boolean check = false;
			if(member != null){
				check = member.isCheckedPw(user_pw);
			}
			if(check && (member.getM_status()==1||member.getM_status()==2||member.getM_status()==3||member.getM_status()==4)){
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_status", member.getM_status());
				return "redirect:/main/main.do";
			}else if(check && member.getM_status()==0){
				result.reject("unableMember");
				return memberLoginForm();
			}else if(check && member.getM_status()==9){
				System.out.println("ADMIN Login!!");
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_status", member.getM_status());
				return "redirect:/main/main.do";
			}else{
				result.reject("invalidIdOrPassword");
				return memberLoginForm();
			}
		}catch(Exception e){
			result.reject("loginError");
			return memberLoginForm();
		}
	}
	
	// 아이디 중복체크
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
	
	// 로그아웃
	@RequestMapping("/member/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/main/main.do";
	}
}
