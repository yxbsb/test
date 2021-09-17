package com.yxb.pet_location.service;

import com.yxb.pet_location.dao.DeviceDao;
import com.yxb.pet_location.entity.deviceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

/**
 * @author yxb
 * @create 2021-08-12 0:41
 */


@Service
public class deviceService {
    @Autowired
    DeviceDao deviceDao;


    public List<deviceBean> list() {
        return deviceDao.findAll();
    }

    //是否存在
    public boolean existsById( Long id ) {
        return deviceDao.existsById(id);
    }

    //分页查找
    public Page<deviceBean> findAll(PageRequest pageReques) {
        return deviceDao.findAll(pageReques);
    }

    //获取条数
    public long count() {
        return deviceDao.count();
    }

    //插入数据
    public deviceBean insert(deviceBean device) {
        return deviceDao.save(device);
    }

    //删除数据
    public void delete(long id) {
        deviceDao.deleteById(id);
    }

    //修改数据
    public deviceBean update(deviceBean device) {
        return deviceDao.save(device);
    }

    //搜索查找
    public Page<deviceBean> search(String deviceId, String openid, Pageable pageReques) {
        return deviceDao.findAllByDeviceIdLikeAndOpenidLike('%' + deviceId + '%', '%' + openid + '%', pageReques);
    }
}
