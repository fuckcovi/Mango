package com.anticovi.mango.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.anticovi.mango.device.domain.DeviceCommand;

public interface DeviceMapper {
	@Select("SELECT * FROM device")
	public List<DeviceCommand> allDeviceList();
	@Insert("INSERT INTO device(d_seq,d_name,d_modelnum,d_regdate,d_type,d_explain) VALUES(device_seq.nextval,#{d_name},#{d_modelnum},#{d_regdate, jdbcType=DATE},#{d_type},#{d_explain})")
	public void insertDevice(DeviceCommand device);
}
