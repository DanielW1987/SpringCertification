package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml") // if no file name is given hibernate will look for hibernate.cfg.xml per default
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      // create a student object
      Student student = new Student("John", "Doe", "john.doe@example.com");

      // start transaction
      session.getTransaction().begin();

      // save the student
      session.save(student);

      // commit the transaction
      session.getTransaction().commit();
    }
    finally {
      factory.close();
    }
  }
}
