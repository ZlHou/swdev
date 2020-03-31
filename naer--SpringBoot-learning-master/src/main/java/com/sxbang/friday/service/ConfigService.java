package com.sxbang.friday.service;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.ProjectUser;
import com.sxbang.friday.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ConfigService {
    Integer getProjectIdByName(String name);

    List<SysUser> getAllUsersById(int projectId);

    Results save(int projectId, int userId);

    List<ProjectEntity> getAllProjcets();

    Results<ProjectUser> getAllProjectsByPage(Integer offset, Integer limit);
}
