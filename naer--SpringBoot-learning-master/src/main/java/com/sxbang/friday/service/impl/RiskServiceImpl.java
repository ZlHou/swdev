package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.RiskDao;
import com.sxbang.friday.model.RiskEntity;
import com.sxbang.friday.service.RiskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RiskServiceImpl implements RiskService {

    @Autowired
    private RiskDao riskDao;

    @Override
    public RiskEntity getRisk(int id) {
        return riskDao.getRisk(id);
    }

    @Override
    public Results<RiskEntity> getAllRisks() {
        return Results.success(50,riskDao.getAllRisk());
    }

    @Override
    public Results<RiskEntity> getAllRisksByPage(Integer offset, Integer limit) {
        return Results.success(riskDao.countAllrisk().intValue(),riskDao.getAllRisksByPage(offset,limit));
    }
}
