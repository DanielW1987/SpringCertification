package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Gender;
import com.wagner.hibernateintro.model.Student;
import com.wagner.hibernateintro.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

public class ReadDemo {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.createSession()) {
      // create and save a student object
      Student student = new Student("Robb", "Stark", "robb.stark@example.com", Gender.MALE);

      // create student and retrieve id
      Serializable studentId = session.save(student);

      // Query student
      Student queriedStudent = session.get(Student.class, studentId);

      System.out.println("Student with id '" + studentId + "': " + queriedStudent);
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

}