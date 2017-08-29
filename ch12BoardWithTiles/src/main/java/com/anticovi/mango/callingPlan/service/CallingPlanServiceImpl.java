package com.anticovi.mango.callingPlan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anticovi.mango.callingPlan.dao.CallingPlanMapper;
import com.anticovi.mango.callingPlan.domain.CallingPlanCommand;

@Service("callingPlanService")
public class CallingPlanServiceImpl implements CallingPlanService{
	@Resource
	private CallingPlanMapper callingPlanMapper;
	
	@Override
	public List<CallingPlanCommand> allCpList(Map<String, Object> map) {
		return callingPlanMapper.allCpList(map);
	}

}
