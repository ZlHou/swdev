package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.ProjectEntity;

public interface FunctionService {

    FunctionEntity getFunction(int id);

    Results<FunctionEntity> getAllFunctions();

    Results<FunctionEntity> getAllFunctionsByPage(Integer offset, Integer limit);

}
