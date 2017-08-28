package com.anticovi.mango.device.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.anticovi.mango.device.domain.DeviceCommand;

@Transactional
public interface DeviceService {
	@Transactional(readOnly=true)
	public List<DeviceCommand> allDeviceList();
	public void insertDevice(DeviceCommand device);
}
