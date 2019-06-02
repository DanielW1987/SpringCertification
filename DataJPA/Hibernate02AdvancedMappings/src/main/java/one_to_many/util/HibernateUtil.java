package one_to_many.util;

import one_to_many.Course;
import one_to_many.Instructor;
import one_to_many.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    sessionFactory = new Configuration()
            .configure("hibernate-one-to-many.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();
  }

  public static Session createSession() {
    return sessionFactory.openSession();
  }

  public static void closeSessionFactory() {
    sessionFactory.close();
  }

}
