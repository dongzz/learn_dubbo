package com.dongz.springcloud.learn.service;

import com.dongz.springcloud.learn.xml.Student;
import com.dongz.springcloud.learn.xml.factory.Animal;
import lombok.Data;

/**
 * @author dong
 * @date 2020/5/11 17:46
 * @desc
 */
@Data
public class HelloService {

    private Student student;

    private Animal animal;

    public String hello() {
        return student.toString() + "///" + animal.getName();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
