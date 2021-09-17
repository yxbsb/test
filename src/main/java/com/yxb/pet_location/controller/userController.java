package com.yxb.pet_location.controller;

import com.yxb.pet_location.entity.userBean;
import com.yxb.pet_location.service.userService;
import com.yxb.pet_location.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;

/**
 * @author yxb
 * @create 2021-08-09 23:01
 */
@Controller
public class userController {
    @Autowired
    userService userService;

    @CrossOrigin
    @PostMapping(value="/login")
    @ResponseBody
    public Result login(@RequestBody userBean requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
         System.out.println(username);
        userBean user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            Result r=new Result();
            r.setCode(400);
            return  r;
        } else {
            Result r=new Result();
            r.setCode(200);
            return r;
        }
    }
    
    @CrossOrigin
    @PostMapping(value="/register")
    @ResponseBody
    public Result reg(@RequestBody userBean requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        userBean user = userService.getByName(username);
        if (null == user) {
            userService.add(requestUser);
            Result r=new Result();
            r.setCode(200);
            return  r;
        } else {
            Result r=new Result();
            r.setCode(400);
            return r;
        }
    }
}



