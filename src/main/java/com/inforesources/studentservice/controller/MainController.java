package com.inforesources.studentservice.controller;

import com.inforesources.studentservice.dao.Student;
import com.inforesources.studentservice.dto.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {
    List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student(1, 20, "sowmya"));
        studentList.add(new Student(2, 15, "sanjay"));
        studentList.add(new Student(3, 48, "karthick"));
    }
    @GetMapping(path="hello")
    public GenericResponse sayHello(@RequestParam String name) {
        return new GenericResponse("hello world" + name);

    }
    @GetMapping(path="students")
    public List<Student> getStudents() {
        return studentList;
    }
    @GetMapping(path="student/{studentId}")
    public Student getStudent(@PathVariable(name="studentId") int id) {
        Student student = null;
        for (Student s: studentList
             ) {
            if(s.getStudentId() == id)
                student = s;
        }
        return student;
    }

}
