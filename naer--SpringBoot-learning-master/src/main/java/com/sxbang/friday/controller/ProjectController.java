package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.ResponseCode;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dto.UserDto;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.SysUser;
import com.sxbang.friday.service.ProjectService;
import com.sxbang.friday.service.UserService;
import com.sxbang.friday.util.MD5;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
//import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RequestMapping("project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{name}")
    @ResponseBody
    public ProjectEntity project(@PathVariable String name) {
        return projectService.getProject(name);
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页获取项目信息", notes = "分页获取项目信息")//描述
    @ApiImplicitParam(name = "request", value = "分页查询实体类", required=false)
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:query')")
    public Results<ProjectEntity> getProjects(PageTableRequest request) {
        request.countOffset();
        return projectService.getAllProjectsByPage(request.getOffset(),request.getLimit());
    }

    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    @ApiOperation(value = "项目创建页面", notes = "跳转到创建项目页面")//描述
    public String addProject(Model model) {
        model.addAttribute("project",new ProjectEntity());
        return "project/project-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:add')")
    @ApiOperation(value = "保存项目信息", notes = "保存新增的项目信息")//描述
    public Results<ProjectEntity> saveProject(ProjectEntity project) {
        //userDto.setPassword(MD5.crypt(userDto.getPassword()));
        return projectService.save(project);
    }

    String pattern = "yyyy-MM-dd";

    //只需要加上下面这段即可，注意不能忘记注解
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));// CustomDateEditor为自定义日期编辑器
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "项目查看页面", notes = "跳转到项目查看页面")//描述
    public String checkProject(Model model, ProjectEntity projectEntity) {
        model.addAttribute("project",projectService.getProjectById(projectEntity.getId()));
        return "project/project-edit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public Results<SysUser> updateUser(ProjectEntity project) {

        return projectService.update(project);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:del')")
    public Results<SysUser> deleteProject(ProjectEntity project) {
        project.setStatus("拒批");
        projectService.update(project);
        return Results.success();
    }

    @GetMapping(value = "/confirm")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:del')")
    public Results<SysUser> confirmProject(ProjectEntity project) {
        project.setStatus("审批通过");

        projectService.update(project);
        return Results.success();
    }
}
