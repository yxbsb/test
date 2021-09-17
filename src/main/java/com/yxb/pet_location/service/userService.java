package com.yxb.pet_location.service;

import com.yxb.pet_location.dao.UserDao;
import com.yxb.pet_location.entity.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yxb
 * @create 2021-08-09 23:34
 */

@Service
public class userService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username) {
        userBean user = getByName(username);
        return null!=user;
    }

    public userBean getByName(String username) {
        return userDao.findByUsername(username);
    }

    public userBean get(String username, String password){
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(userBean user) {
        userDao.save(user);
    }



}
