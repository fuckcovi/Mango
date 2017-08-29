package com.anticovi.mango.device.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;

@Transactional
public interface DeviceService {
	@Transactional(readOnly=true)
	public List<DeviceCommand> allDeviceList();
	@Transactional(readOnly=true)
	public DeviceCommand deviceInfo(Integer d_seq , Integer di_seq);
	@Transactional(readOnly=true)
	public DeviceInfoCommand selectDeviceInfo(Integer d_seq,Integer di_seq);
	public void insertDevice(DeviceCommand device);
	public void insertDeviceInfo(DeviceInfoCommand deviceInfo);
	public void updateDeviceInfo(DeviceInfoCommand deviceInfo);
}
