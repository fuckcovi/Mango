package com.anticovi.mango.device.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;

@Transactional
public interface DeviceService {
	@Transactional(readOnly=true)
	public List<DeviceCommand> allDeviceList(Map<String, Object> map);
	@Transactional(readOnly=true)
	public DeviceCommand deviceInfo(Map<String, Integer> map);
	@Transactional(readOnly=true)
	public DeviceInfoCommand selectDeviceInfo(Map<String, Integer> map);
	@Transactional(readOnly=true)
	public List<DeviceCommand> deviceInfoList(Integer d_seq);
	public void insertDevice(DeviceCommand device);
	public void insertDeviceInfo(DeviceInfoCommand deviceInfo);
	public void updateDeviceInfo(DeviceInfoCommand deviceInfo);
}
