package com.yxb.pet_location.service.impl;

import com.yxb.pet_location.dao.DeviceDao;
import com.yxb.pet_location.dao.PetDao;
import com.yxb.pet_location.entity.deviceBean;
import com.yxb.pet_location.entity.petBean;
import com.yxb.pet_location.service.petService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author yxb
 * @create 2021-08-19 18:14
 */

@Service
public class petServiceImpl implements petService {
    @Autowired
    PetDao petDao;

    @Override
    public boolean existsById(Long id) {
        return petDao.existsById(id);
    }

    @Override
    public Page<petBean> findAll(PageRequest pageReques) {
        return petDao.findAll(pageReques);
    }


    @Override
    public long count() {
        return petDao.count();
    }

    @Override
    public petBean insert(petBean pet) {
        return petDao.save(pet);
    }


    @Override
    public void delete(long id) {
        petDao.deleteById(id);
    }



    @Override
    public petBean update(petBean device) {
        return petDao.save(device);
    }

    @Override
    public Page<petBean> search(String PetId, String openid, Pageable pageReques) {
        return petDao.findAllByPetIdLikeAndOpenidLike('%' + PetId + '%', '%' + openid + '%', pageReques);
    }
}
