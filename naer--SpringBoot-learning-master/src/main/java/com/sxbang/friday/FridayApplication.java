package com.sxbang.friday;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.controller.ProjectController;
import com.sxbang.friday.dao.ProjectDao;
import com.sxbang.friday.dao.UserDao;
import com.sxbang.friday.model.ProjectEntity;
import com.sxbang.friday.service.ProjectService;
import com.sxbang.friday.service.impl.ProjectServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.parameters.P;

import java.util.List;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FridayApplication {

    static UserDao dao;

    public static void main(String[] args) {
        SpringApplication.run(FridayApplication.class, args);

    }

}
