package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.RiskEntity;

public interface RiskService {

    RiskEntity getRisk(int id);

    Results<RiskEntity> getAllRisks();

    Results<RiskEntity> getAllRisksByPage(Integer offset, Integer limit);
}
