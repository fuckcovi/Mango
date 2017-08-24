package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberLoginController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//Ŀ�ǵ尴ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("command")
	public MemberCommand initCommand(){
		return new MemberCommand();
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String form(){
		return "memberLogin";
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	                     @Valid MemberCommand memberCommand,
	                     BindingResult result,
	                     HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		
		//id�� passwd �ʵ常 üũ
		if(result.hasFieldErrors("id") || 
				result.hasFieldErrors("passwd")){
			return form();
		}
		
		//�α��� üũ(id �Ǵ� ��й�ȣ ��ġ ���� üũ)
		try{
			MemberCommand member = 
					memberService.selectMember(
							memberCommand.getId());
			boolean check = false;
			
			if(member!=null){
				//��й�ȣ ��ġ ���� üũ
				check = member.isCheckedPasswd(
						     memberCommand.getPasswd());
			}
			if(check){
				//���� ����, �α��� ó��
				session.setAttribute("user_id", memberCommand.getId());
				session.setAttribute("user_auth", memberCommand.getAuth());
				
				return "redirect:/main/main.do";
			}else{
				//��������
				throw new Exception();
			}
		}catch(Exception e){
			//���� ���з� �� ȣ��
			result.reject("invalidIdOrPassword");
			return form();
		}
	}
	//�α׾ƿ�
	@RequestMapping("/member/logout.do")
	public String process(HttpSession session){
		//�α׾ƿ�
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
}












