package com.yxb.pet_location.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * @author yxb
 * @create 2021-08-09 23:14
 */
@Data
@Entity(name="user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class userBean {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    int id;
    String username;
    String password;
}
