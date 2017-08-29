package com.anticovi.mango.callingPlan.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.anticovi.mango.callingPlan.domain.CallingPlanCommand;

@Transactional
public interface CallingPlanService {
	@Transactional(readOnly=true)
	public List<CallingPlanCommand> allCpList(Map<String, Object> map);
}
