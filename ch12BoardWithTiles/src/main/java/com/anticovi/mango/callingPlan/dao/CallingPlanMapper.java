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
	
	@Select("SELECT * FROM callingplan WHERE cp_seq=#{cp_seq}")
	public CallingPlanCommand selectCallingPlan(Integer cp_seq);
	
	@Insert("INSERT INTO callingplan(cp_seq,cp_category,cp_name,cp_modelnum,cp_regdate,cp_price,cp_call,cp_data,cp_message,cp_detail,cp_detailimage,cp_detailimagename) VALUES(callingplan_seq.nextval,#{cp_category},#{cp_name},#{cp_modelnum},#{cp_regdate, jdbcType=DATE},#{cp_price},#{cp_call},#{cp_data},#{cp_message},#{cp_detail},#{cp_detailimage,jdbcType=BLOB},#{cp_detailimagename,jdbcType=VARCHAR})")
	public void registerCallingPlan(CallingPlanCommand callingPlan);
}