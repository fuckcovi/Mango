package kr.spring.board.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("seq") int seq){
		
		if(log.isDebugEnabled()){
			log.debug("<<seq>> : " + seq);
		}
		
		//�ش� ���� ��ȸ�� ����
		boardService.updateHit(seq);
		BoardCommand board = boardService.selectBoard(seq);
		
		return new ModelAndView("boardView","board",board);
	}
	//���� �ٿ�ε�
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("seq") int seq){
		
		BoardCommand board = boardService.selectBoard(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile", board.getUploadfile());
		mav.addObject("filename", board.getFilename());
		
		return mav;
	}
	//�̹��� ���
	@RequestMapping("/board/imageView.do")
	public ModelAndView viewImage(@RequestParam("seq") int seq){
		
		BoardCommand board = boardService.selectBoard(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", board.getUploadfile());
		mav.addObject("filename", board.getFilename());
		
		return mav;
	}
}









