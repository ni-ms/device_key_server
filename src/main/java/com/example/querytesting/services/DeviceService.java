package com.example.querytesting.services;

import com.example.querytesting.entities.Device;
import com.example.querytesting.entities.KeyTable;

import java.util.List;

public interface DeviceService {
    Device saveDevice(Device device);

    List<Device> fetchDevices();

    Device updateDevice(Device device, Integer ID);

    void deleteDevice(Integer ID);

    KeyTable getKeyByDeviceId(Integer deviceId);
}
