package com.anticovi.mango.device.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;

public interface DeviceMapper {
	@Select("SELECT * FROM device a FULL OUTER JOIN deviceinfo b ON a.d_seq=b.d_seq")	// 사이트에 등록된 기기리스트
	public List<DeviceCommand> allDeviceList();
	@Select("SELECT * FROM (SELECT * FROM device WHERE d_seq=#{d_seq})a, deviceinfo b WHERE a.d_seq=b.d_seq AND di_seq=#{di_seq}") // 해당 기기 상세정보 확인
	public DeviceCommand deviceInfo(Map<String, Integer> map);
	@Select("SELECT * FROM deviceinfo WHERE d_seq=#{d_seq} AND di_seq=#{di_seq}")
	public DeviceInfoCommand selectDeviceInfo(Map<String, Integer> map);
	@Insert("INSERT INTO device(d_seq,d_name,d_modelnum,d_regdate,d_type,d_explain) VALUES(device_seq.nextval,#{d_name},#{d_modelnum},#{d_regdate, jdbcType=DATE},#{d_type},#{d_explain})")
	public void insertDevice(DeviceCommand device);
	@Insert("INSERT INTO deviceinfo(di_seq,d_seq,di_color,di_image1,di_imagename1,di_image2,di_imagename2,di_image3,di_imagename3,di_image4,di_imagename4,di_image5,di_imagename5,di_quantity,di_price) VALUES(deviceinfo_seq.nextval,#{d_seq},#{di_color},#{di_image1,jdbcType=BLOB},#{di_imagename1,jdbcType=VARCHAR},#{di_image2,jdbcType=BLOB},#{di_imagename2,jdbcType=VARCHAR},#{di_image3,jdbcType=BLOB},#{di_imagename3,jdbcType=VARCHAR},#{di_image4,jdbcType=BLOB},#{di_imagename4,jdbcType=VARCHAR},#{di_image5,jdbcType=BLOB},#{di_imagename5,jdbcType=VARCHAR},#{di_quantity},#{di_price})")
	public void insertDeviceInfo(DeviceInfoCommand deviceInfo);
	@Update("UPDATE deviceinfo SET di_color=#{di_color},di_image1=#{di_image1,jdbcType=BLOB},di_image2=#{di_image2,jdbcType=BLOB},di_image3=#{di_image3,jdbcType=BLOB},di_image4=#{di_image4,jdbcType=BLOB},di_image5=#{di_image5,jdbcType=BLOB},di_imagename1=#{di_imagename1,jdbcType=VARCHAR},di_imagename2=#{di_imagename2,jdbcType=VARCHAR},di_imagename3=#{di_imagename3,jdbcType=VARCHAR},di_imagename4=#{di_imagename4,jdbcType=VARCHAR},di_imagename5=#{di_imagename5,jdbcType=VARCHAR},di_quantity=#{di_quantity},di_price=#{di_price} WHERE di_seq=#{di_seq}")
	public void updateDeviceInfo(DeviceInfoCommand deviceInfo);
}
