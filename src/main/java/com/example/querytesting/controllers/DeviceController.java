package com.example.querytesting.controllers;

import com.example.querytesting.entities.Device;
import com.example.querytesting.entities.KeyTable;
import com.example.querytesting.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/devices")
    public Device saveDevice(@RequestBody Device device) {
        return deviceService.saveDevice(device);
    }

    @GetMapping("/devices")
    public List<Device> fetchDevices() {
        return deviceService.fetchDevices();
    }

    @PutMapping("/devices/{ID}")
    public Device updateDevice(@RequestBody Device device, @PathVariable("ID") Integer ID) {
        return deviceService.updateDevice(device, ID);
    }

    @DeleteMapping("/devices/{ID}")
    public void deleteDevice(@PathVariable("ID") Integer ID) {
        deviceService.deleteDevice(ID);
    }

    @GetMapping("/devices/{ID}/key")
    public KeyTable getKeyByDeviceId(@PathVariable("ID") Integer ID) {
        return deviceService.getKeyByDeviceId(ID);
    }
}