package com.sxbang.friday.dao;

import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.SysRole;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper
public interface ProjectDao {

    @Select("select * from sys_project t where t.name = #{name}")
    ProjectEntity getProject(String name);

    @Select("select * from sys_project t")
    List<ProjectEntity> getAllProject();

    @Select("select count(*) from sys_project t")
    Long countAllproject();

    @Select("select * from sys_project t limit #{startPosition}, #{limit}")
    List<ProjectEntity> getAllProjectsByPage(@Param("startPosition")Integer startPosition, @Param("limit")Integer limit);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_project(name, description, createTime, updateTime, status) values(#{name}, #{description}, now(), now(),#{status} )")
    int save(ProjectEntity project);

    int saveProject(ProjectEntity project);

    @Select("select * from sys_project t where t.id = #{id}")
    ProjectEntity getById(Integer id);

    int update(ProjectEntity project);

    @Delete("delete from sys_project where id = #{id}")
    int delete(Integer id);


}
