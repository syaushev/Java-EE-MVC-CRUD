package app.dao;

import app.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student=entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    public Student findStudentById(int id) {

        return (Student) entityManager.createQuery("select s from Student s where s.id= :StudentId").setParameter("StudentId",id).getSingleResult();
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("select s from Student s").getResultList();
    }
}
