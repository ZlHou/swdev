package com.sxbang.friday.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class FunctionEntity {

    private Integer functionId;

    private String projectId;

    private Integer userId;

    private String description;

    @Override
    public String toString() {
        return "functionEntity{" +
                "functionId=" + functionId +
                ", projectId='" + projectId + '\'' +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }
}
