package com.fourhorsemen.demospringboot02.controller;
import com.fourhorsemen.demospringboot02.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private List<StudentEntity> studentEntityList;

    @PostMapping("")
    public ResponseEntity<?> addListStudent(@RequestParam String name, @RequestParam int age){
        studentEntityList.add(new StudentEntity(name, age));
        return new ResponseEntity<>(studentEntityList, HttpStatus.OK);
    }

    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> addVariableStudent(@PathVariable String name, @PathVariable int age){
        studentEntityList.add(new StudentEntity(name, age));
        return new ResponseEntity<>(studentEntityList, HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<?> addBodyStudentList(@RequestBody StudentEntity student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntityList.add(studentEntity);
        return new ResponseEntity<>(studentEntityList, HttpStatus.OK);
    }
}
