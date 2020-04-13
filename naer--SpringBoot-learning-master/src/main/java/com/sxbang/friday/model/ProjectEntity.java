package com.sxbang.friday.model;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Repository
@Data
public class ProjectEntity {

    private String id;
    private String name;
    private String description;

    private Date createTime;

    private Date updateTime;

    private String status = "未审批";          //审批状态：未审批，同意，拒绝

    private Date startTime;

    private Date finishTime;

    private String technology;

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                ", startTIme=" + startTime +
                ", finishTime=" + finishTime +
                ", technology='" + technology + '\'' +
                '}';
    }
}
