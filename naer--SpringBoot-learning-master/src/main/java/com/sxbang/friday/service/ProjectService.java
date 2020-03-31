package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dto.RoleDto;
import com.sxbang.friday.model.ProjectEntity;

import java.util.List;

public interface ProjectService {

    ProjectEntity getProject(String name);

    Results<ProjectEntity> getAllProjects();

    Results<ProjectEntity> getAllProjectsByPage(Integer offset, Integer limit);

    Results<ProjectEntity> save(ProjectEntity projectEntity);

    ProjectEntity getProjectById(Integer id);

    Results update(ProjectEntity projectEntity);

    Results delete(Integer id);

}
