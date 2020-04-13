package com.sxbang.friday.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Data
public class ProjectUser {
    String projectId;

    String userName;

    String projectName;

    String projectDescription;

    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date updateTime = new Date();

    @Override
    public String toString() {
        return "ProjectUser{" +
                "projectId=" + projectId +
                ", list=" + userName +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
