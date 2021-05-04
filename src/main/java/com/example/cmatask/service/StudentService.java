package com.example.cmatask.service;

import com.example.cmatask.entity.Student;
import com.example.cmatask.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void delete(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
    }
}
