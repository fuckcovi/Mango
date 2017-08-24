package kr.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.board.service.BoardService;

@Controller
public class BoardDeleteReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/deleteReply.do")
	@ResponseBody
	public Map<String,String> process(
			@RequestParam("re_no") int re_no,
			@RequestParam("id") String id,
			HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("<<re_no>> : " + re_no);
			log.debug("<<id>> : " + id);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			//로그인이 되어있지 않음
			map.put("result", "logout");
		}else if(user_id!=null && user_id.equals(id)){
			//로그인 되어 있고 로그인한 아이디와 작성자 아이디 일치
			boardService.deleteReply(re_no);
			map.put("result", "success");
		}else{
			map.put("result", "wrongAccess");
		}
		
		return map;
	}
}










