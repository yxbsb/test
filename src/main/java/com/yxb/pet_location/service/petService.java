package com.yxb.pet_location.service;

import com.yxb.pet_location.entity.petBean;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yxb
 * @create 2021-08-19 18:11
 */


public interface petService {

    //是否存在
    public boolean existsById( Long id ) ;

    //分页查找
    public Page<petBean> findAll(PageRequest pageReques) ;

    //获取条数
    public long count();

    //插入数据
    public petBean insert(petBean device);

    //删除数据
    public void delete(long id) ;

    //修改数据
    public petBean update(petBean device);

    //搜索查找
    public Page<petBean> search(String petId, String openid, Pageable pageReques);
}
