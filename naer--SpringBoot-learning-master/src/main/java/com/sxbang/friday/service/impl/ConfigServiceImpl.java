package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.ConfigDao;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.ProjectUser;
import com.sxbang.friday.model.SysUser;
import com.sxbang.friday.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigDao configDao;

    @Override
    public Integer getProjectIdByName(String name) {
        return configDao.getProjectIdByName(name);
    }

    @Override
    public List<SysUser> getAllUsersById(int projectId) {
        return configDao.getAllUsersById(projectId);
    }

    @Override
    public Results save(int projectId, int userId) {

        System.out.println(projectId + "!!!!!!!!!!!!!!!!!!!!!"+userId);
        configDao.save(projectId,userId);
        return Results.success();
    }

    @Override
    public List<ProjectEntity> getAllProjcets() {
        return configDao.getAllProjects();
    }

    @Override
    public Results<ProjectUser> getAllProjectsByPage(Integer offset, Integer limit) {
        return Results.success(configDao.countAllprojects().intValue(), getProjects());
    }

    public List<ProjectUser> getProjects() {
        List<ProjectUser> results = new ArrayList<>();
        List<ProjectEntity> projectEntities = configDao.getAllProjects();

        for(ProjectEntity temp : projectEntities){
            List<SysUser> users = configDao.getAllUsersById(temp.getId());
            ProjectUser user = new ProjectUser();
            StringBuilder sb = new StringBuilder();
            for(SysUser temp2 : users){
                sb.append(temp2.getUsername() + ", ");
            }
            user.setUserName(sb.toString());
            user.setProjectId(temp.getId());
            user.setProjectDescription(temp.getDescription());
            user.setProjectName(temp.getName());
            user.setUpdateTime(temp.getUpdateTime());
            results.add(user);
        }

        return results;
    }
}
