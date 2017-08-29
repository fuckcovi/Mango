package com.anticovi.mango.callingPlan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.anticovi.mango.callingPlan.domain.CallingPlanCommand;
import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;

public interface CallingPlanMapper {
	// 사이트에 등록된 요금제리스트
	public List<CallingPlanCommand> allCpList(Map<String, Object> map);
	
}
