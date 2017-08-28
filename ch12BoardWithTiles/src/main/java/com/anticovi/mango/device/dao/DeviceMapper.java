package com.anticovi.mango.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;

public interface DeviceMapper {
	@Select("SELECT a.*,b.di_seq,b.di_color,b.di_imagename,b.di_quantity,b.di_price FROM device a FULL OUTER JOIN deviceinfo b ON a.d_seq=b.d_seq")	// 사이트에 등록된 기기리스트
	public List<DeviceCommand> allDeviceList();
	@Select("SELECT * FROM (SELECT * FROM device WHERE d_seq=#{d_seq})a, deviceinfo b WHERE a.d_seq=b.d_seq") // 해당 기기 상세정보 확인
	public DeviceCommand deviceInfo(Integer d_seq);
	@Insert("INSERT INTO device(d_seq,d_name,d_modelnum,d_regdate,d_type,d_explain) VALUES(device_seq.nextval,#{d_name},#{d_modelnum},#{d_regdate, jdbcType=DATE},#{d_type},#{d_explain})")
	public void insertDevice(DeviceCommand device);
	@Insert("INSERT INTO deviceinfo(di_seq,d_seq,di_color,di_image,di_imagename,di_quantity,di_price) VALUES(deviceinfo_seq.nextval,#{d_seq},#{di_color},#{di_image,jdbcType=BLOB},#{di_imagename,jdbcType=VARCHAR},#{di_quantity},#{di_price})")
	public void insertDeviceInfo(DeviceInfoCommand deviceInfo);
}
