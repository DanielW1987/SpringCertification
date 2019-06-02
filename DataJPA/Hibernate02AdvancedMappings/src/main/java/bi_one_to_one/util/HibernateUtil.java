package bi_one_to_one.util;

import bi_one_to_one.Instructor;
import bi_one_to_one.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    sessionFactory = new Configuration()
            .configure("hibernate-one-to-one.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();
  }

  public static Session createSession() {
    return sessionFactory.openSession();
  }

  public static void closeSessionFactory() {
    sessionFactory.close();
  }

}
