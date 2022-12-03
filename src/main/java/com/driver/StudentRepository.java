package com.driver;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Component
@Repository
public class StudentRepository {

    HashMap<String,Student> listOfStudent=new HashMap<>();
    HashMap<String,Teacher> listOfTeacher=new HashMap<>();
    HashMap<String,List<String>> studentTeacherPair=new HashMap<>();

    public void addStudent(Student student){
        listOfStudent.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
            listOfTeacher.put(teacher.getName(),teacher);
    }

    public Student getStudentByName(String studentName){
        return listOfStudent.get(studentName);
    }
    public Teacher getTeacherByName(String teacherName){
        return listOfTeacher.get(teacherName);
    }
    public void addStudentTeacherPair(String studentName,String teacherName){
        List<String>studentList=new ArrayList<>();
        if(studentTeacherPair.containsKey(teacherName)){
            studentList=studentTeacherPair.get(teacherName);
            studentList.add(studentName);
            studentTeacherPair.put(teacherName,studentList);
        }
        else{
            studentList.add(studentName);
            studentTeacherPair.put(teacherName,studentList);
        }
    }

    public List<String> getAllStudents(){
        List<String>allStudents=new ArrayList<>();
        for(Student s:listOfStudent.values()){
            allStudents.add(s.getName());
        }
        return allStudents;
    }

    public void deleteTeacherByName(String teacherName){
        List<String>studentNames=new ArrayList<>();
        studentNames=studentTeacherPair.get(teacherName);
        if(studentTeacherPair.containsKey(teacherName)) {
            studentTeacherPair.remove(teacherName);
        }
        if(listOfTeacher.containsKey(teacherName)) {
            listOfTeacher.remove(teacherName);
        }
        for(String sName:studentNames){
            if(listOfStudent.containsKey(sName)) {
                listOfStudent.remove(sName);
            }
        }
    }

    public void deleteAllTeachers(){
        for(String teacherName:studentTeacherPair.keySet()){
            if(studentTeacherPair.containsKey(teacherName)) {
                deleteTeacherByName(teacherName);
            }
        }
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> studentNames=new ArrayList<>();
        if(studentTeacherPair.containsKey(teacherName)) {
            studentNames = studentTeacherPair.get(teacherName);
        }
        return studentNames;
    }
}
