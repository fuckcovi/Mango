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
			"로그인한 아이디로 작성된 글이 아니기 때문에 수정할 수 없습니다.");
		}
		
		BoardCommand board = boardService.selectBoard(
				                     boardCommand.getSeq());
		
		if(result.hasErrors()){
			//원래 파일명 셋팅
			boardCommand.setFilename(board.getFilename());
			return "boardModify";
		}
		
		//전송된 파일이 없을 경우
		if(boardCommand.getUpload().isEmpty()){
			//기존 정보 셋팅
			boardCommand.setUploadfile(board.getUploadfile());
			boardCommand.setFilename(board.getFilename());
		}
		
		//ip셋팅
		boardCommand.setIp(request.getRemoteAddr());
		
		//글수정
		boardService.update(boardCommand);
		
		return "redirect:/board/list.do";
	}
}









