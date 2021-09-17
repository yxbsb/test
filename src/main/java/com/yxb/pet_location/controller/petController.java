package com.yxb.pet_location.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yxb.pet_location.entity.petBean;
import com.yxb.pet_location.service.petService;
import com.yxb.pet_location.util.Result;
import com.yxb.pet_location.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yxb
 * @create 2021-06-29 10:46
 */

@Controller
public class petController {
    @Autowired
    petService petService;

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }
    @RequestMapping("/console")
    public String console() {
        return "/console";
    }
    @RequestMapping("/users")
    public String users() {
        return "/users";
    }
    @RequestMapping("/devices")
    public String devices() {
        return "/devices";
    }
    @RequestMapping("/pets")
    public String pets() {
        return "/pets";
    }


    @CrossOrigin
    @PostMapping(value="/petListByPage")
    @ResponseBody
    public ResultList list(@RequestBody JSONObject jsonObject) throws Exception {
        String pageNo = jsonObject.getString("pageNo");
        String pageSize = jsonObject.getString("pageSize");
        System.out.println(jsonObject.toJSONString());
        String openid = jsonObject.getString("openid");
        String petId = jsonObject.getString("petId");

        PageRequest pageReques=PageRequest.of(Integer.valueOf(pageNo)-1,Integer.valueOf(pageSize));   //获取第1页的两条记录
        List<petBean> pet = null;
        long count=0;
        if("".equals(openid)&&"".equals(petId)){
            System.out.println("333");
            Page<petBean>  page= petService.findAll(pageReques);
            pet =page.getContent();
            count= petService.count();
        }
        else{
            System.out.println("444");
            Page<petBean>  page=petService.search(petId,openid,pageReques);
            pet =page.getContent();
            count=page.getTotalElements();
        }


        System.out.println("-------------------------");
        Object str= JSON.toJSON(pet);
        System.out.println(str);
        ResultList r=new ResultList();

        if (null == pet) {
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
    @PostMapping(value="/petInsert")
    @ResponseBody
    public Result insert(@RequestBody petBean requestUser) throws Exception {

        System.out.println("-------------------");
        System.out.println(requestUser.toString());
        System.out.println("-------------------");


        petBean pet=petService.insert(requestUser);
        Result r =new Result();
        if (null == pet) {
            r.setCode(400);
            r.setMsg(pet.toString());
            return  r;
        } else {
            r.setCode(200);
            r.setMsg(pet.toString());
            return r;
        }
    }

    @CrossOrigin
    @PostMapping(value="/petDelete")
    @ResponseBody
    public Result delete(@RequestBody JSONObject jsonObject) throws Exception {
        Long id=jsonObject.getLong("id");

        System.out.println("-------------------");
        System.out.println(id);
        System.out.println("-------------------");

        petService.delete(id);
        System.out.println("-------------------");
        boolean isExit= petService.existsById(id);

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
    @PostMapping(value="/petUpdate")
    @ResponseBody
    public Result update(@RequestBody petBean requestUser) throws Exception {
        petBean pet= petService.update(requestUser);

        Result r =new Result();

        if (null == pet) {
            r.setCode(400);
            r.setMsg("修改失败");
            return  r;
        } else {
            r.setCode(200);
            r.setMsg("删除成功");
            return r;
        }

    }

//    @CrossOrigin
//    @PostMapping(value="/search")
//    @ResponseBody
//    public ResultList search(@RequestBody JSONObject jsonObject) throws Exception {
////        String pageNo = jsonObject.getString("pageNo");
////        String pageSize = jsonObject.getString("pageSize");
//        String openid = jsonObject.getString("openid");
//        String deviceId = jsonObject.getString("deviceId");
//        Pageable pageReques= PageRequest.of(0,1);   //获取第1页的两条记录
//        Page<petBean> page= petService.search(deviceId,openid,pageReques);
//        System.out.println(page);
//        System.out.println("-------------------------");
//        List<deviceBean> device =page.getContent();
//        Object str= JSON.toJSON(device);
////        System.out.println(str);
//        ResultList r=new ResultList();
//
//        if (null == device) {
//            r.setCode(400);
//            r.setData(str);
//            return  r;
//        } else {
//            r.setCode(200);
//            r.setData(str);
////            r.setCount(count);
//            return r;
//        }
//    }
}
