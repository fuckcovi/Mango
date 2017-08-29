package com.anticovi.mango.event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anticovi.mango.event.domain.EventCommand;
import com.anticovi.mango.event.sevice.EventService;
import com.anticovi.mango.util.PagingUtil;

@Controller
public class EventController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/event/eventList.do")
	public ModelAndView eventListForm(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		int count = eventService.getRowCount();
		
		if (log.isDebugEnabled()) {
			log.debug("<<이벤트목록 pageNum>> : " + currentPage);
			log.debug("<<이벤트목록 count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(null, null, currentPage, count, rowCount, pageCount, "eventList.do");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<EventCommand> list = null;
		if (count > 0) {
			list = eventService.eventList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("eventList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
}
