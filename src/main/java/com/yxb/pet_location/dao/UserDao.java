package com.yxb.pet_location.dao;



import com.yxb.pet_location.entity.userBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yxb
 * @create 2021-08-09 23:30
 */

public interface UserDao extends JpaRepository<userBean,Integer> {

        userBean findByUsername(String username);
        userBean getByUsernameAndPassword(String username,String password);
    }

