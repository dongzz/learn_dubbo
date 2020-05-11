package com.dongz.springcloud.learn.xml;

import java.util.List;

/**
 * @author dong
 * @date 2020/5/11 17:40
 * @desc
 */
public class Student {

    private String name;

    private Integer age;

    private List<String> classList;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classList=" + classList +
                '}';
    }
}
