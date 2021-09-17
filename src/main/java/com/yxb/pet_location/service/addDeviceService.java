package com.yxb.pet_location.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yxb
 * @create 2021-06-30 20:04
 */

public interface addDeviceService {

     String addDevice(String deviceId);

}
