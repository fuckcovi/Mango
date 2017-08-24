package kr.spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/delete.do")
	public String submit(@RequestParam("seq") int seq,
			             HttpSession session)
			            		    throws Exception{
		if(log.isDebugEnabled()){
			log.debug("<<seq>> : " + seq);
		}
		
		BoardCommand boardCommand = 
				boardService.selectBoard(seq);
		String user_id = (String)session.getAttribute("user_id");
		if(!user_id.equals(boardCommand.getId())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 삭제할 수 없습니다.");
		}
		
		//글 삭제
		boardService.delete(boardCommand.getSeq());
		
		return "redirect:/board/list.do";
	}
	
}











