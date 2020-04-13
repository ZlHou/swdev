package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.OwnEntity;

public interface OwnService {

    OwnEntity getOwn(int id);

    Results<OwnEntity> getAllOwns();

    Results<OwnEntity> getAllownsByPage(Integer offset, Integer limit);
}
