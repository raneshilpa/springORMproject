package org.example.dao;

import org.example.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;
    @Transactional
    //save student
    public int insert(Student student)
    {
      Integer  save =(Integer) this.hibernateTemplate.save(student);
        return save;

    }
    //get the single data(object)
    public Student getStudent(int studentId)
    {
        Student student = this.hibernateTemplate.get(Student.class, 1111);
        return student;

    }
    //get all rows
    public List<Student> getallStudent()
    {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }
    //deleting the data
    @Transactional
    public void deleteStudent(int studentId)
    {
        Student delstudent = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(delstudent);
    }

    //updating data
    @Transactional
    public void updateStudent(Student student)
    {
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
