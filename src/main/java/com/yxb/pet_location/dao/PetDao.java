package com.yxb.pet_location.dao;

import com.yxb.pet_location.entity.deviceBean;
import com.yxb.pet_location.entity.petBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yxb
 * @create 2021-08-19 18:15
 */

@Mapper
public interface PetDao extends JpaRepository<petBean,Long> {
    Page<petBean> findAllByPetIdLikeAndOpenidLike(String s, String s1, Pageable pageReques);
}
