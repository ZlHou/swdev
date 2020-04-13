package com.sxbang.friday.dao;

import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConfigDao {
    @Select("select id from sys_project t where t.name = #{name} and t.status = 审批通过")
    Integer getProjectIdByName(String name);

    @Select("select * from sys_user t where t.id in (select userId from sys_project_user a where a.projectId = #{projectId})")
    List<SysUser> getAllUsersById(String projectId);

    @Insert("Insert into sys_project_user(projectId,userId) values(#{arg0},#{arg1})")
    int save(String projectId, int userId);

    @Select("select * from sys_project t where t.id in (select distinct projectId from sys_project_user)")
    List<ProjectEntity> getAllProjects();

    @Select("select count(projectId) from sys_project_user t")
    Long countAllprojects();
}
