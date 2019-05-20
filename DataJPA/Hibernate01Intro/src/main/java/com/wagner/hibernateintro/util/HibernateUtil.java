package com.wagner.hibernateintro.util;

import com.wagner.hibernateintro.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
  }

  public static Session createSession() {
    return sessionFactory.openSession();
  }

  public static void closeSessionFactory() {
    sessionFactory.close();
  }

  public static Student createDemoStudent(Student student, Session session) {
    // create student and retrieve id
    Serializable studentId = session.save(student);

    // query persisted student and return
    return session.get(Student.class, studentId);
  }

}
