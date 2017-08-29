package com.anticovi.mango.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.anticovi.mango.event.domain.EventCommand;

public interface EventMapper {

	@Select("SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM event ORDER BY e_seq DESC)a) WHERE rnum >= #{start} AND rnum <= #{end}")
	public List<EventCommand> eventList(Map<String, Object> map);
	@Select("SELECT count(*) FROM event")
	public int getRowCount();
	public void insertEvent(EventCommand event);
	public EventCommand selectEvent(Integer e_seq);
	public void updateHit(Integer e_seq);
	public void updateEvent(EventCommand event);
	public void deleteEvent(Integer e_seq);
	
}
