package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Gender;
import com.wagner.hibernateintro.model.Student;
import com.wagner.hibernateintro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@SuppressWarnings("JpaQlInspection")
public class UpdateDemo {

  private static final Student DEMO_STUDENT = new Student("Robert", "Baratheon", "robert.baratheonk@kingslanding.com", Gender.MALE);

  public static void main(String[] args) {
    try {
      updateV1();
      updateV2();
      updateV3();
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

  private static void updateV1() {
    try (Session session = HibernateUtil.createSession()) {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // get example student
      Student student = HibernateUtil.createDemoStudent(DEMO_STUDENT, session);
      System.out.println("Student before update: " + student);

      // update some fields
      student.setFirstName("new first name");
      student.setLastName("new last name");

      // commit the transaction
      transaction.commit();

      System.out.println("Student after update/commit: " + session.get(Student.class, student.getId()));
    }
  }

  private static void updateV2() {
    try (Session session = HibernateUtil.createSession()) {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // get example student
      Student student = HibernateUtil.createDemoStudent(DEMO_STUDENT, session);

      System.out.println("student before update: " + student);

      student.setEmail("robertb@kingslanding.com");
      student.setAlias("RobertB");

      // session.saveOrUpdate(student);
      session.update(student);

      // commit the transaction
      transaction.commit();

      System.out.println("Student after update: " + session.get(Student.class, student.getId()));
    }
  }

  private static void updateV3() {
    try (Session session = HibernateUtil.createSession()) {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // get example student
      Student student = HibernateUtil.createDemoStudent(DEMO_STUDENT, session);

      System.out.println("student before update: " + student);

      int rowsAffected = session.createQuery("update Student set email = :newemail where id = :id")
                                .setParameter("newemail", "robert.baratheonk@kingslanding.org")
                                .setParameter("id", student.getId())
                                .executeUpdate();

      // commit the transaction
      transaction.commit();

      System.out.println("Student after update: " + session.get(Student.class, student.getId()));
      System.out.println(rowsAffected + " row(s) updated...");
    }
  }

}