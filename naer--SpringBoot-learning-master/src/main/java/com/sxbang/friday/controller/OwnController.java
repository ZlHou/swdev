package com.sxbang.friday.controller;


import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.OwnEntity;
import com.sxbang.friday.model.RiskEntity;
import com.sxbang.friday.service.OwnService;
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
@RequestMapping("own")
@Slf4j
public class OwnController {

    @Autowired
    private OwnService ownService;

    @GetMapping("/{id}")
    @ResponseBody
    public OwnEntity own(@PathVariable int id) {
        return ownService.getOwn(id);
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页获取项目信息", notes = "分页获取项目信息")//描述
    @ApiImplicitParam(name = "request", value = "分页查询实体类", required=false)
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:query')")
    public Results<OwnEntity> getowns(PageTableRequest request) {
        request.countOffset();
        return ownService.getAllownsByPage(request.getOffset(),request.getLimit());
    }

    @GetMapping("/show")
    public String showOwns(Model model){
        return "own/own-list";
    }
}
