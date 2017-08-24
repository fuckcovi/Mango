package kr.spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private BoardService boardService;
	
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		String id = (String)session.getAttribute("user_id");
		
		BoardCommand command = new BoardCommand();
		command.setId(id);
		model.addAttribute("command", command);
		
		return "boardWrite";
	}
	
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	                     @Valid BoardCommand boardCommand,
	                     BindingResult result,
	                     HttpServletRequest request){
		
		if(log.isDebugEnabled()){
			log.debug("<<boardCommand>> : " + boardCommand);
		}
		
		//��ȿ�� üũ
		if(result.hasErrors()){
			return "boardWrite";
		}
		
		//ip ����
		boardCommand.setIp(request.getRemoteAddr());
		
		//�۾���
		boardService.insert(boardCommand);
		
		return "redirect:/board/list.do";
	}
}










