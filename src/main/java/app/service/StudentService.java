package app.service;

import app.model.Student;
import app.dao.StudentDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StudentService {

    @EJB
    StudentDao studentDao;


    public void save(Student student) {
        studentDao.save(student);
    }


    public void deleteStudent(int id) {

       studentDao.deleteStudent(id);
    }


    public Student findStudentById(int id) {

        return studentDao.findStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
