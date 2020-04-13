package com.sxbang.friday.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Data
public class OwnEntity {
    private int id;

    private int projectId;

    private String owner;

    private String duration;

    private String ifFinish;

    private Date checkTime;

    private String status;

    private Date updateTime;

    @Override
    public String toString() {
        return "OwnEntity{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", owner='" + owner + '\'' +
                ", duration='" + duration + '\'' +
                ", ifFinish='" + ifFinish + '\'' +
                ", checkTime=" + checkTime +
                ", status='" + status + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
