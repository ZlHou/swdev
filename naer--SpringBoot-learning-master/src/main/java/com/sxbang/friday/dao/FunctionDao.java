package com.sxbang.friday.dao;


import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FunctionDao {
    @Select("select * from sys_function t where t.functionId = #{id}")
    FunctionEntity getProject(int id);

    @Select("select * from sys_function t")
    List<FunctionEntity> getAllFunction();

    @Select("select count(*) from sys_function t")
    Long countAllfunction();

    @Select("select * from sys_function t limit #{startPosition}, #{limit}")
    List<FunctionEntity> getAllFunctionsByPage(@Param("startPosition")Integer startPosition, @Param("limit")Integer limit);
}
