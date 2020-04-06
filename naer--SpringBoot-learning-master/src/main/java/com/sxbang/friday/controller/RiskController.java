package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.RiskEntity;
import com.sxbang.friday.service.RiskService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("risk")
@Slf4j
public class RiskController {
    @Autowired
    private RiskService riskService;

    @GetMapping("/{id}")
    @ResponseBody
    public RiskEntity risk(@PathVariable int id) {
        return riskService.getRisk(id);
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页获取项目信息", notes = "分页获取项目信息")//描述
    @ApiImplicitParam(name = "request", value = "分页查询实体类", required=false)
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:query')")
    public Results<RiskEntity> getRisks(PageTableRequest request) {
        request.countOffset();
        return riskService.getAllRisksByPage(request.getOffset(),request.getLimit());
    }

    @GetMapping("/show")
    public String showRisks(Model model){
        return "projectRisk/projectRisk-list";
    }

}
