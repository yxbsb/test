package com.yxb.pet_location.service.impl;


import com.yxb.pet_location.service.addDeviceService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

import static com.yxb.pet_location.util.HttpUtils.sendPost;

/**
 * @author yxb
 * @create 2021-06-30 20:05
 */

@Service
public class addDevice implements addDeviceService {

    @Override
    public String addDevice(String deviceId) {
        System.out.println(deviceId);
        String url="https://api.weixin.qq.com/tcb/databaseadd";
        String access_token="?access_token="+"46_CvD33EErW0cwF2JpcEY4Qx_6nFiUcbfVrtv1TbJkDZws7sX7EzOMLG7_Yds75vXqkQX0iYZI5vulvbNji244WokS4bunmZjIT1vZWBWTh3NxGEY_YhaucT980Flr3SHFtll3uutnSJRo1ZRYMFGhABAQJK";
        String sql="{\"env\":\"yxb-new-7g117wzkcaa797e7\",\"query\":\"db.collection(\\\"petDevice\\\").add({data:{deviceId:\\\"";
        sql=sql.concat(deviceId);
        sql=sql.concat("\\\",isBind:\\\"0\\\",openid:\\\"\\\",bindTime:\\\"\\\",petId:\\\"\\\",upDate:\\\"");
        String upData=new Date().toString();
        sql=sql.concat(upData+"\\\"}})\"}");
        System.out.println(sql);
        url=url.concat(access_token);
        String t=sendPost(url,sql);
        System.out.println("返回信息:"+t);
        t = t.substring(0,13);
        if(t.equals("{\"errcode\":0,")){
            return "1";
        }
        else{
            return "0";
        }
    }
}
