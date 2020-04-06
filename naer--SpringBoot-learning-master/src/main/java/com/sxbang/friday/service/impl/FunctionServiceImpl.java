package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.FunctionDao;
import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.service.FunctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    FunctionDao functionDao;

    @Override
    public FunctionEntity getFunction(int id) {
        return functionDao.getProject(id);
    }

    @Override
    public Results<FunctionEntity> getAllFunctions() {
        return Results.success(50,functionDao.getAllFunction());
    }

    @Override
    public Results<FunctionEntity> getAllFunctionsByPage(Integer offset, Integer limit) {
        return Results.success(functionDao.countAllfunction().intValue(), functionDao.getAllFunctionsByPage(offset, limit));
    }
}
