package com.sxbang.friday.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Repository
@Data
public class ProjectEntity extends BaseEntity<Integer>{

    private String name;
    private String description;

    private String status = "未审批";          //审批状态：未审批，同意，拒绝


    @Override
    public String toString() {
        return "ProjectEntity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", proStatus='" + status + '\'' +
                '}';
    }
}
