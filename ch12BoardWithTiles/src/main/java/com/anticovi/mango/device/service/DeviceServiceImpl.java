package com.anticovi.mango.device.service;

import java.util.List;
import java.util.Map;

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
	public List<DeviceCommand> allDeviceList(Map<String, Object> map) {
		return deviceMapper.allDeviceList(map);
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
	public DeviceCommand deviceInfo(Map<String, Integer> map) {
		return deviceMapper.deviceInfo(map);
	}
	@Override
	public DeviceInfoCommand selectDeviceInfo(Map<String, Integer> map) {
		return deviceMapper.selectDeviceInfo(map);
	}
	@Override
	public void updateDeviceInfo(DeviceInfoCommand deviceInfo) {
		deviceMapper.updateDeviceInfo(deviceInfo);
	}
	@Override
	public List<DeviceCommand> deviceInfoList(Integer d_seq) {
		return deviceMapper.deviceInfoList(d_seq);
	}
	

}
