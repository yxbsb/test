package com.yxb.pet_location.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * @author yxb
 * @create 2021-06-30 11:42
 */
@Data
@Entity(name="devcie")
@EntityListeners(AuditingEntityListener.class)
public class deviceBean {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    private long id;
    private String deviceId;
    private String isBind;
    private String petId;
    private String openid;
    private String bindTime;

    @LastModifiedDate
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date upDate;

}
