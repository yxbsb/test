package com.yxb.pet_location.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;

/**
 * @author yxb
 * @create 2021-07-03 0:57
 */
@Data
@Entity(name="pet")
@EntityListeners(AuditingEntityListener.class)
public class petBean {
    @Id
    @javax.persistence.Id
    @GeneratedValue
    private Long id;

    private String petId;
    private String openid;
    private String isBind;
    private String petName;
    private String petBreed;
    private String petType;
    private String petSex;
    private String bindDate;
    @LastModifiedDate
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private String upDate;




}
