package com.sxbang.friday.dao;


import com.sxbang.friday.model.OwnEntity;
import com.sxbang.friday.model.RiskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OwnDao {

    @Select("select * from sys_own t where t.id = #{id}")
    OwnEntity getOwn(int id);

    @Select("select * from sys_own t")
    List<OwnEntity> getAllOwn();

    @Select("select count(*) from sys_own t")
    Long countAllown();

    @Select("select * from sys_own t limit #{startPosition}, #{limit}")
    List<OwnEntity> getAllOwnsByPage(@Param("startPosition")Integer startPosition, @Param("limit")Integer limit);
}
