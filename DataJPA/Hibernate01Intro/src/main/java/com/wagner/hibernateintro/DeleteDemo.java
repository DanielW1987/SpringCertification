package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Gender;
import com.wagner.hibernateintro.model.Student;
import com.wagner.hibernateintro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@SuppressWarnings("JpaQlInspection")
public class DeleteDemo {

  private static final Student DEMO_STUDENT = new Student("Eddard", "Stark", "eddard.stark@winterfell.com", Gender.MALE);

  public static void main(String[] args) {
    try{
      deleteV1();
      deleteV2();
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

  private static void deleteV1() {
    try (Session session = HibernateUtil.createSession()) {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // get example student
      Student student = HibernateUtil.createDemoStudent(DEMO_STUDENT, session);

      // delete student
      session.delete(student);

      // commit the transaction
      transaction.commit();
    }
  }

  private static void deleteV2() {
    try (Session session = HibernateUtil.createSession()) {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // get example student
      Student student = HibernateUtil.createDemoStudent(DEMO_STUDENT, session);

      // delete student
      int rowsAffected = session.createQuery("delete from Student where id = :id")
                                .setParameter("id", student.getId())
                                .executeUpdate();

      System.out.println(rowsAffected + " row(s) deleted...");

      // commit the transaction
      transaction.commit();
    }
  }

}
