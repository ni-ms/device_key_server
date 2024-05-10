package com.example.querytesting.services;

import com.example.querytesting.entities.Device;
import com.example.querytesting.entities.KeyTable;
import com.example.querytesting.repositories.DeviceRepository;
import com.example.querytesting.repositories.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private KeyRepository keyRepository;

    @Override
    public Device saveDevice(Device device) {
        KeyTable keyTable = device.getKeyTable();
        if (keyTable != null) {
            keyRepository.save(keyTable);
        }
        return deviceRepository.save(device);
    }

    @Override
    public List<Device> fetchDevices() {
        List<Device> devices = deviceRepository.findAll();
        devices.forEach(device -> device.setKeyTable(keyRepository.findById(device.getId()).orElse(null)));
        return devices;
    }

    @Override
    public Device updateDevice(Device device, Integer ID) {
        Device existingDevice = deviceRepository.findById(ID).orElse(null);
        if (existingDevice == null) {
            return null;
        }
        if (Objects.nonNull(device.getMacAddress()) && !"".equalsIgnoreCase(device.getMacAddress())) {
            existingDevice.setMacAddress(device.getMacAddress());
        }
        if (Objects.nonNull(device.getDeviceName()) && !"".equalsIgnoreCase(device.getDeviceName())) {
            existingDevice.setDeviceName(device.getDeviceName());
        }
        if (Objects.nonNull(device.getKeyTable())) {
            KeyTable existingKeyTable = existingDevice.getKeyTable();
            KeyTable newKeyTable = device.getKeyTable();
            if (existingKeyTable != null && newKeyTable != null) {
                existingKeyTable.setKey1(newKeyTable.getKey1());
                existingKeyTable.setKey2(newKeyTable.getKey2());
                existingKeyTable.setKey3(newKeyTable.getKey3());
                existingKeyTable.setKey4(newKeyTable.getKey4());
                existingKeyTable.setKey5(newKeyTable.getKey5());
                keyRepository.save(existingKeyTable);
            }
        }

        return deviceRepository.save(existingDevice);
    }

    @Override
    public void deleteDevice(Integer ID) {
        Optional<Device> device = deviceRepository.findById(ID);
        if (device.isPresent()) {
            deviceRepository.deleteById(ID);
        } else {
            System.out.println("No Device with ID " + ID + " exists in the database.");
        }
    }

    @Override
    public KeyTable getKeyByDeviceId(Integer deviceId) {
        Optional<Device> device = deviceRepository.findById(deviceId);
        return device.map(Device::getKeyTable).orElse(null);
    }


}