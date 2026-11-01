package com.smsk.healthcare.service;

import com.smsk.healthcare.entity.student;
import com.smsk.healthcare.repository.studentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class studentService {
    private final studentRepository service;

    public List<student> get(){

       return service.findAll();
    }
    public student insert(student new_student) {

        return service.save(new_student);
    }

    public student update(Long id, student new_student){

        student oldId=service.findById(id).orElseThrow(()->new RuntimeException("id not found"));

        oldId.setName(new_student.getName());
        oldId.setAge(new_student.getAge());

        return service.save(oldId);
    }

    public String delete(Long id){

        service.deleteById(id);
        return "id deleted";

    }


    }

