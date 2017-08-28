package com.anticovi.mango.device.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anticovi.mango.device.dao.DeviceMapper;
import com.anticovi.mango.device.domain.DeviceCommand;
import com.anticovi.mango.device.domain.DeviceInfoCommand;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
	@Resource
	private DeviceMapper deviceMapper;
	@Override
	public List<DeviceCommand> allDeviceList() {
		return deviceMapper.allDeviceList();
	}
	@Override
	public void insertDevice(DeviceCommand device) {
		deviceMapper.insertDevice(device);
	}
	@Override
	public void insertDeviceInfo(DeviceInfoCommand deviceInfo) {
		deviceMapper.insertDeviceInfo(deviceInfo);
	}
	@Override
	public DeviceCommand deviceInfo(Integer d_seq) {
		return deviceMapper.deviceInfo(d_seq);
	}
	

}
