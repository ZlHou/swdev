package com.sxbang.friday.controller;


import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.ProjectUser;
import com.sxbang.friday.model.SysUser;
import com.sxbang.friday.service.ConfigService;
import com.sxbang.friday.service.ProjectService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("config")
@Slf4j
public class ConfigController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ConfigService configService;

    @GetMapping("/{name}")
    @ResponseBody
    public ProjectEntity project(@PathVariable String name) {
        return projectService.getProject(name);
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<ProjectUser> getProjects(PageTableRequest request) {
        request.countOffset();
        return configService.getAllProjectsByPage(request.getOffset(),request.getLimit());
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "项目查看页面", notes = "跳转到项目查看页面")//描述
    public String checkProject(Model model, ProjectUser projectUser) {
        model.addAttribute("project",projectService.getProjectById(projectUser.getProjectId()));
        return "config/config-check";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public Results<SysUser> updateUser(ProjectEntity project) {

        return projectService.update(project);
    }


    @GetMapping(value = "/confirm")
    @ResponseBody
    public Results save(String projectId, int uId){
        List<SysUser> list = configService.getAllUsersById(projectId);
        for(SysUser user :list){
            if(uId == user.getId()){
                return Results.failure(500,"已加入项目");
            }
        }

        return configService.save(projectId,uId);
    }


}
