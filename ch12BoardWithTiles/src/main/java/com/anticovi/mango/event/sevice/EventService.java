package com.anticovi.mango.event.sevice;

import java.util.List;
import java.util.Map;

import com.anticovi.mango.event.domain.EventCommand;

public interface EventService {

	public List<EventCommand> eventList(Map<String, Object> map);
	public int getRowCount();
	public void insertEvent(EventCommand event);
	public EventCommand selectEvent(Integer e_seq);
	public void updateHit(Integer e_seq);
	public void updateEvent(EventCommand event);
	public void deleteEvent(Integer e_seq);
	
}
