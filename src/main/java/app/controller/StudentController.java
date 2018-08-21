package app.controller;

import app.model.Student;
import app.service.StudentService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class StudentController implements Serializable {
    private int id;
    private String name;
    private List listStudents;

    public List getListStudents() {
        return listStudents;
    }

    public void setListStudents(List listStudents) {
        this.listStudents = listStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @EJB
    StudentService studentService;

    public void save() {
        Student student=new Student();
        student.setName(this.name);
        studentService.save(student);
        System.out.println("save method");
    }

    public void delete(){
        studentService.deleteStudent(this.id);
        System.out.println("delete method");
    }

    public String findStudentById() {
        Student student=studentService.findStudentById(this.id);
        System.out.println(student);
        System.out.println("find method");
        name =  student.getName();
        return "found";
    }

    public String findAll(){

        listStudents=studentService.getAllStudents();


        return "all";
    }


}
