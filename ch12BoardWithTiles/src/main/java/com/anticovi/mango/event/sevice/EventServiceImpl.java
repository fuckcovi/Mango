package com.anticovi.mango.event.sevice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anticovi.mango.event.dao.EventMapper;
import com.anticovi.mango.event.domain.EventCommand;

@Service("EventService")
public class EventServiceImpl implements EventService {

	@Resource
	private EventMapper eventMapper;

	@Override
	public List<EventCommand> eventList(Map<String, Object> map) {
		return eventMapper.eventList(map);
	}

	@Override
	public int getRowCount() {
		return eventMapper.getRowCount();
	}

	@Override
	public void insertEvent(EventCommand event) {
		eventMapper.insertEvent(event);
	}

	@Override
	public EventCommand selectEvent(Integer e_seq) {
		return eventMapper.selectEvent(e_seq);
	}

	@Override
	public void updateHit(Integer e_seq) {
		eventMapper.updateHit(e_seq);
	}

	@Override
	public void updateEvent(EventCommand event) {
		eventMapper.updateEvent(event);
	}

	@Override
	public void deleteEvent(Integer e_seq) {
		eventMapper.deleteEvent(e_seq);
	}
	
}
