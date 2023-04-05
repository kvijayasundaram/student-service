package com.inforesources.studentservice.controller;

import com.inforesources.studentservice.dao.Student;
import com.inforesources.studentservice.dto.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class MainController {
    Map<Integer, Student> studentList = new HashMap<>();

    {
        studentList.put(1, new Student(1, 20, "sowmya"));
        studentList.put(2, new Student(2, 15, "sanjay"));
        studentList.put(3, new Student(3, 48, "karthick"));
    }
    @GetMapping(path="hello")
    public GenericResponse sayHello(@RequestParam String name) {
        return new GenericResponse("hello world" + name);

    }
    @GetMapping(path="students")
    public Collection<Student> getStudents() {
        return studentList.values();
    }
    @GetMapping(path="student/{studentId}")
    public Student getStudent(@PathVariable(name="studentId") int id) {
        return studentList.get(id);
    }

    @PostMapping(path="students")
    public ResponseEntity<Student> putStudent(@RequestBody @Validated  Student student) throws Exception {
        if(student != null) {
            if(student.getStudentId() == 0) {
                student.setStudentId(studentList.size() + 1);
            }
            studentList.put(student.getStudentId(), student);
        }
        else{
            throw new Exception("Invalid Student");
        }
        return ResponseEntity.ok(student);
    }
    @DeleteMapping(path="student/{studentId}")
    public ResponseEntity<GenericResponse> deleteStudent(@PathVariable(name="studentId") int id) {
        String message = null;
        if(studentList.get(id) != null) {
            studentList.remove(id);
            message = "Student ID:" + id + " removed";
        }
        else{
            message = "Student ID:" + id + " was not found";
        }
        return ResponseEntity.ok(new GenericResponse(message));
    }

}
