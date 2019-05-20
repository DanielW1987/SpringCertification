package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Student;
import com.wagner.hibernateintro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public class ReadAllDemo {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.createSession()) {

      // retrieve all students (simple 'SELECT * FROM student')
      List<Student> students1 = session.createQuery("from com.wagner.hibernateintro.model.Student", Student.class)
                                       .getResultList();

      System.out.println("retrieve all students (simple 'SELECT * FROM student')");
      students1.forEach(System.out::println);



      // retrieve all students where last name is 'Doe'
      Query<Student> lastNameQuery = session.createQuery("from com.wagner.hibernateintro.model.Student " +
                                                         "where lastName = :lastName", Student.class);

      lastNameQuery.setParameter("lastName", "Doe");
      List<Student> students2 = lastNameQuery.getResultList();

      System.out.println("retrieve all students where last name is 'Doe'");
      students2.forEach(System.out::println);



      // retrieve all students where last name is 'Doe' or first name is 'Maria'
      Query<Student> queryWithOr = session.createQuery("from com.wagner.hibernateintro.model.Student " +
                                                       "where lastName = :lastName " +
                                                       "or firstName = :firstName", Student.class);

      queryWithOr.setParameter("lastName", "Doe");
      queryWithOr.setParameter("firstName", "Maria");
      List<Student> students3 = queryWithOr.getResultList();

      System.out.println("retrieve all students where last name is 'Doe' or first name is 'Maria'");
      students3.forEach(System.out::println);



      // retrieve all students where email is like '@example.com'
      Query<Student> queryEmailLike = session.createQuery("from com.wagner.hibernateintro.model.Student " +
                                                          "where email like :email ", Student.class);

      queryEmailLike.setParameter("email", "%@example.com");
      List<Student> students4 = queryEmailLike.getResultList();

      System.out.println("retrieve all students where email is like '@example.com'");
      students4.forEach(System.out::println);
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

}