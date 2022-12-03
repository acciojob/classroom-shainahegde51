package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StudentService {
    StudentRepository studentRepository;

    public void addStudent(Student s){
        studentRepository.addStudent(s);
    }
    public void addTeacher(Teacher t){
        studentRepository.addTeacher(t);
    }

    public void addTeacherStudentPair(String sName,String tName){
        studentRepository.addStudentTeacherPair(sName,tName);
    }
    public Student getStudentByName(String sName){
        return studentRepository.getStudentByName(sName);
    }
    public Teacher getTeacherByName(String  tName){
        return studentRepository.getTeacherByName(tName);
    }

    public List<String> getStudentsByTeacherName(String tName){
        return studentRepository.getStudentsByTeacherName(tName);
    }
    public List<String> getAllStudents(){
        return  studentRepository.getAllStudents();
    }
    public void deleteTeacherByName(String tName){
        studentRepository.deleteTeacherByName(tName);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
