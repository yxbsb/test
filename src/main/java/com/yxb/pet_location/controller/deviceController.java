package com.yxb.pet_location.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yxb.pet_location.entity.deviceBean;
import com.yxb.pet_location.service.deviceService;
import com.yxb.pet_location.service.petService;
import com.yxb.pet_location.util.Result;
import com.yxb.pet_location.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yxb
 * @create 2021-08-12 0:43
 */
@Controller
public class deviceController {
    @Autowired
    deviceService deviceService;

    @CrossOrigin
    @PostMapping(value="/listByPage")
    @ResponseBody
    public ResultList list(@RequestBody JSONObject jsonObject) throws Exception {
        String pageNo = jsonObject.getString("pageNo");
        String pageSize = jsonObject.getString("pageSize");
        System.out.println(jsonObject.toJSONString());
        String openid = jsonObject.getString("openid");
        String deviceId = jsonObject.getString("deviceId");

        PageRequest pageReques=PageRequest.of(Integer.valueOf(pageNo)-1,Integer.valueOf(pageSize));   //获取第1页的两条记录
        List<deviceBean> device = null;
        long count=0;
        if("".equals(openid)&&"".equals(deviceId)){
            System.out.println("333");
            Page<deviceBean>  page=deviceService.findAll(pageReques);
            device =page.getContent();
            count= deviceService.count();
        }
        else{
            Page<deviceBean>  page=deviceService.search(deviceId,openid,pageReques);
            device =page.getContent();
            count=page.getTotalElements();
        }


        System.out.println("-------------------------");
        Object str= JSON.toJSON(device);
        System.out.println(str);
        ResultList r=new ResultList();

        if (null == device) {
            r.setCode(400);
            r.setData(str);
            return  r;
        } else {
            r.setCode(200);
            r.setData(str);
            r.setCount(count);
            return r;
        }
    }

    @CrossOrigin
    @PostMapping(value="/insert")
    @ResponseBody
    public Result insert(@RequestBody deviceBean requestUser) throws Exception {

        System.out.println("-------------------");
        System.out.println(requestUser.toString());
        System.out.println("-------------------");

        requestUser.setIsBind("0");
        requestUser.setOpenid("");
        requestUser.setPetId("");
        deviceBean device=deviceService.insert(requestUser);
        Result r =new Result();
        if (null == device) {
            r.setCode(400);
            r.setMsg(device.toString());
            return  r;
        } else {
            r.setCode(200);
            r.setMsg(device.toString());
            return r;
        }
    }

    @CrossOrigin
    @PostMapping(value="/delete")
    @ResponseBody
    public Result delete(@RequestBody JSONObject jsonObject) throws Exception {
        Long id=jsonObject.getLong("id");

        System.out.println("-------------------");
        System.out.println(id);
        System.out.println("-------------------");

        deviceService.delete(id);
        System.out.println("-------------------");
        boolean isExit=deviceService.existsById(id);

        Result r =new Result();

        if (isExit) {
            r.setCode(400);
            r.setMsg("删除失败");
        } else {
            r.setCode(200);
            r.setMsg("删除成功");
        }
        return  r;

    }

    @CrossOrigin
    @PostMapping(value="/update")
    @ResponseBody
    public Result update(@RequestBody deviceBean requestUser) throws Exception {
        deviceBean device= deviceService.update(requestUser);

        Result r =new Result();

        if (null == device) {
            r.setCode(400);
            r.setMsg("修改失败");
            return  r;
        } else {
            r.setCode(200);
            r.setMsg("删除成功");
            return r;
        }

    }

    @CrossOrigin
    @PostMapping(value="/search")
    @ResponseBody
    public ResultList search(@RequestBody JSONObject jsonObject) throws Exception {
//        String pageNo = jsonObject.getString("pageNo");
//        String pageSize = jsonObject.getString("pageSize");
        String openid = jsonObject.getString("openid");
        String deviceId = jsonObject.getString("deviceId");
        Pageable pageReques=PageRequest.of(0,1);   //获取第1页的两条记录
        Page<deviceBean>  page=deviceService.search(deviceId,openid,pageReques);
        System.out.println(page);
        System.out.println("-------------------------");
        List<deviceBean> device =page.getContent();
        Object str= JSON.toJSON(device);
//        System.out.println(str);
        ResultList r=new ResultList();

        if (null == device) {
            r.setCode(400);
            r.setData(str);
            return  r;
        } else {
            r.setCode(200);
            r.setData(str);
//            r.setCount(count);
            return r;
        }
    }
}
