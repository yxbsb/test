package com.yxb.pet_location.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.yxb.pet_location.entity.deviceBean;
import com.yxb.pet_location.service.getUserService;
import com.yxb.pet_location.util.Result;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.yxb.pet_location.util.HttpUtils.sendPost;

/**
 * @author yxb
 * @create 2021-06-30 11:01
 */
@Service
public class getUser implements getUserService {

    @Override
    public String getUser() {
        String url="https://api.weixin.qq.com/tcb/databasequery";
        String access_token="?access_token="+"46_CvD33EErW0cwF2JpcEY4Qx_6nFiUcbfVrtv1TbJkDZws7sX7EzOMLG7_Yds75vXqkQX0iYZI5vulvbNji244WokS4bunmZjIT1vZWBWTh3NxGEY_YhaucT980Flr3SHFtll3uutnSJRo1ZRYMFGhABAQJK";
        String sql="{\"env\":\"yxb-new-7g117wzkcaa797e7\",\"query\":\"db.collection(\\\"petDevice\\\").get()\"}";
        url=url.concat(access_token);
        System.out.println(url+'\n');
        System.out.println(sql+'\n');
        String t=sendPost(url,sql);
        System.out.println(t+"\n");

        JSONObject tt=JSONObject.parseObject(t);
        JSONArray s =tt.getJSONArray("data");
        System.out.println(s.toString()+"\n");
        List<String> ss = JSON.parseArray(s.toJSONString(),String.class);
        deviceBean user=new deviceBean();
        List<deviceBean> userListAll= new LinkedList<>();
        for (int i = 0; i < ss.size(); i++) {
             user= JSON.parseObject(ss.get(i),deviceBean.class);
             userListAll.add(user);
        }
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","数据加载成功");
        json.put("count",1);
        json.put("data",userListAll);
        System.out.println(json.toString());
        return json.toString();
    }

}
