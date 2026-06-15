package com.jfs.JPA_Project01.controller;

import com.jfs.JPA_Project01.entity.Student;
import com.jfs.JPA_Project01.repo.StudentRepo;
import com.jfs.JPA_Project01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/create-student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> all = studentService.getAll();
        return all;
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getById(id);
    }
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        Student deleted = studentService.deleteStudent(id);
        return deleted;
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudentService(id, student);
    }
}
