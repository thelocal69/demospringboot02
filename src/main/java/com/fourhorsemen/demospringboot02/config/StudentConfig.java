package com.fourhorsemen.demospringboot02.config;

import com.fourhorsemen.demospringboot02.entity.StudentEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    public List<StudentEntity> createListStudent(){
        List<StudentEntity> listStudent = new ArrayList<>();
        listStudent.add(new StudentEntity("long", 18));
        return listStudent;
    }
}
