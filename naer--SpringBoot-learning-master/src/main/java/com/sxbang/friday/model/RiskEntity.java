package com.sxbang.friday.model;


import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class RiskEntity {
    private int id;

    private int projectId;

    private String type;

    private String description;

    private int influnce;  //风险等级

    private String action; //应对策略

    private String status; //风险状态

    private String responsible;  //责任人

    private String relation;   //相关人员

    @Override
    public String toString() {
        return "RiskEntity{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", influnce=" + influnce +
                ", action='" + action + '\'' +
                ", status='" + status + '\'' +
                ", responsible='" + responsible + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }
}
