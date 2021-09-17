package com.yxb.pet_location.controller;

import com.yxb.pet_location.service.addDeviceService;
import com.yxb.pet_location.service.delDeviceService;
import com.yxb.pet_location.service.getPetService;
import com.yxb.pet_location.service.getUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yxb
 * @create 2021-06-30 10:55
 */
@Controller
public class getController {

    @Autowired
    private getUserService getuserservice;
    @Autowired
    private addDeviceService adddeviceservice;
    @Autowired
    private delDeviceService deldeviceservice;

    @Autowired
    private getPetService getpetservice;

    @GetMapping(value = "/getUser")
    @ResponseBody
    public String getUser() {
        return  getuserservice.getUser();
    }

    @GetMapping(value = "/getPet")
    @ResponseBody
    public String getPet() {
        return  getpetservice.getPet();
    }

    @RequestMapping("/addDevice")
    @ResponseBody
    public String addDevice(@RequestBody Map<String, String> params) {
        System.out.println(params.get("deviceId"));
        return  adddeviceservice.addDevice(params.get("deviceId").toString());
    }

    @RequestMapping("/delDevice")
    @ResponseBody
    public String delDevice(@RequestBody Map<String, String> params) {
        System.out.println(params.get("deviceId"));
        return  deldeviceservice.delDevice(params.get("deviceId").toString());
    }
}