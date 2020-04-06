package com.sxbang.friday.dao;


import com.sxbang.friday.model.FunctionEntity;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.model.RiskEntity;
import com.sxbang.friday.model.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RiskDao {

    @Select("select * from sys_risk t where t.id = #{id}")
    RiskEntity getRisk(int id);

    @Select("select * from sys_risk t")
    List<RiskEntity> getAllRisk();

    @Select("select count(*) from sys_risk t")
    Long countAllrisk();

    @Select("select * from sys_risk t limit #{startPosition}, #{limit}")
    List<RiskEntity> getAllRisksByPage(@Param("startPosition")Integer startPosition, @Param("limit")Integer limit);
}
