package com.sxbang.friday.service.impl;


import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.OwnDao;
import com.sxbang.friday.model.OwnEntity;
import com.sxbang.friday.service.OwnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OwnServiceImpl implements OwnService{

    @Autowired
    private OwnDao ownDao;
    @Override
    public OwnEntity getOwn(int id) {
        return ownDao.getOwn(id);
    }

    @Override
    public Results<OwnEntity> getAllOwns() {
        return Results.success(50,ownDao.getAllOwn());
    }

    @Override
    public Results<OwnEntity> getAllownsByPage(Integer offset, Integer limit) {
        return Results.success(ownDao.countAllown().intValue(),ownDao.getAllOwnsByPage(offset,limit));
    }
}