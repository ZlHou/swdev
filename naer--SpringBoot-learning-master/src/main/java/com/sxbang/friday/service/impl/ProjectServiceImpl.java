package com.sxbang.friday.service.impl;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dao.ProjectDao;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;


    @Override
    public Results<ProjectEntity> getAllProjects() {
        return Results.success(50,projectDao.getAllProject());
    };

    @Override
    public Results<ProjectEntity> getAllProjectsByPage(Integer offset, Integer limit) {
        return Results.success(projectDao.countAllproject().intValue(), projectDao.getAllProjectsByPage(offset, limit));
    }


    @Override
    public Results<ProjectEntity> save(ProjectEntity projectEntity) {
        projectDao.save(projectEntity);
        return Results.success();
    }

    @Override
    public ProjectEntity getProjectById(String id) {
        return projectDao.getById(id);
    }

    @Override
    public Results update(ProjectEntity projectEntity) {
        int count = projectDao.update(projectEntity);
        if (count > 0) {
            return Results.success();
        } else {
            return Results.failure();
        }

    }

    @Override
    public Results delete(Integer id) {
        projectDao.delete(id);
        return Results.success();
    }

    @Override
    public ProjectEntity getProject(String name) {
        return projectDao.getProject(name);
    }
}


