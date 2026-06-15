package com.jfs.JPA_Project01.service;

import com.jfs.JPA_Project01.entity.Student;
import com.jfs.JPA_Project01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
    public List<Student> getAll() {
        List<Student> ans = studentRepo.findAll();
        return ans;
    }
    public Student getById(Integer id) {
        Optional<Student> byId = studentRepo.findById(id);
        Student student = byId.get();
        return student;
    }
    public Student deleteStudent(int id) {
        Optional<Student> byId = studentRepo.findById(id);
        Student deleted = byId.get();
        studentRepo.deleteById(id);
        return deleted;
    }
    public Student updateStudentService(int id, Student student) {
        Optional<Student> dbStudent = studentRepo.findById(id);
        if(dbStudent.isPresent()) {
            Student s = dbStudent.get();
            s.setAge(student.getAge());
            s.setEmail(student.getEmail());
            s.setName(student.getName());
            return studentRepo.save(s);
        } else {
            throw new RuntimeException("Error fetching student details");
        }
    }
}
