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
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping(value="/board/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("seq") int seq,
			           Model model){
		BoardCommand boardCommand = boardService.selectBoard(seq);
		model.addAttribute("command", boardCommand);
		
		return "boardModify";
	}
	
	@RequestMapping(value="/board/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	                     @Valid BoardCommand boardCommand,
	                     BindingResult result,
	                     HttpSession session,
	                     HttpServletRequest request) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("<<boardCommand>> : " + boardCommand);
		}
		
		String user_id = (String)session.getAttribute("user_id");
		if(!user_id.equals(boardCommand.getId())){
			throw new Exception(
			"�α����� ���̵�� �ۼ��� ���� �ƴϱ� ������ ������ �� �����ϴ�.");
		}
		
		BoardCommand board = boardService.selectBoard(
				                     boardCommand.getSeq());
		
		if(result.hasErrors()){
			//���� ���ϸ� ����
			boardCommand.setFilename(board.getFilename());
			return "boardModify";
		}
		
		//���۵� ������ ���� ���
		if(boardCommand.getUpload().isEmpty()){
			//���� ���� ����
			boardCommand.setUploadfile(board.getUploadfile());
			boardCommand.setFilename(board.getFilename());
		}
		
		//ip����
		boardCommand.setIp(request.getRemoteAddr());
		
		//�ۼ���
		boardService.update(boardCommand);
		
		return "redirect:/board/list.do";
	}
}









