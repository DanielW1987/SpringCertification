package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Gender;
import com.wagner.hibernateintro.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml") // if no file name is given hibernate will look for hibernate.cfg.xml per default
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();

    Session session = factory.openSession();

    try {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // create a student object
      Student student1 = new Student("John", "Doe", "john.doe@example.com", Gender.MALE);
      Student student2 = new Student("Maria", "Wall", "maria.wall@example.com", Gender.FEMALE);

      // save the student
      session.save(student1);
      session.persist(student2);

      // commit the transaction
      transaction.commit();
    }
    finally {
      session.close();

      // only close factory when exiting the application
      factory.close();
    }
  }
}
