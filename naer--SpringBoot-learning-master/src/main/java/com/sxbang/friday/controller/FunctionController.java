package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.ProjectUser;
import com.sxbang.friday.model.SysUser;
import com.sxbang.friday.service.FunctionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("function")
@Slf4j
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @GetMapping("/{id}")
    @ResponseBody
    public FunctionEntity function(@PathVariable int id) {
        return functionService.getFunction(id);
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页获取项目信息", notes = "分页获取项目信息")//描述
    @ApiImplicitParam(name = "request", value = "分页查询实体类", required=false)
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:query')")
    public Results<FunctionEntity> getFunctions(PageTableRequest request) {
        request.countOffset();
        return functionService.getAllFunctionsByPage(request.getOffset(),request.getLimit());
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "项目查看页面", notes = "跳转到项目查看页面")//描述
    public String checkProject(Model model, FunctionEntity functionEntity) {
        model.addAttribute("function",functionService.getFunction(functionEntity.getFunctionId()));
        return "function/function-check";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public void updateUser(FunctionEntity functionEntity) {

        return ;
    }


}
