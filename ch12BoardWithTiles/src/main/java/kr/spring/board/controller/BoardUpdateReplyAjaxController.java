package kr.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardUpdateReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/updateReply.do")
	@ResponseBody
	public Map<String,String> process(
			BoardReplyCommand boardReplyCommand,
			HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()){
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id==null){
			//�α����� �� �Ǿ��ִ� ���
			map.put("result", "logout");
		}else if(user_id!=null && 
				user_id.equals(boardReplyCommand.getId())){
			//�α��� ���̵�� �ۼ��� ���̵� ��ġ
			
			//ip ���
			boardReplyCommand.setRe_ip(request.getRemoteAddr());
			
			//��� ����
			boardService.updateReply(boardReplyCommand);
			map.put("result", "success");
		}else{
			//�α��� ���̵�� �ۼ��� ���̵� ����ġ
			map.put("result", "wrongAccess");
		}
		
		return map;
	}
}






















