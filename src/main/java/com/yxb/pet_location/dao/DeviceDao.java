package com.yxb.pet_location.dao;

import com.yxb.pet_location.entity.deviceBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yxb
 * @create 2021-08-12 0:40
 */

public interface DeviceDao extends JpaRepository<deviceBean,Long> {

    Page<deviceBean> findAllByDeviceIdLikeAndOpenidLike(String keyword1, String keyword2, Pageable pageReques);


}
