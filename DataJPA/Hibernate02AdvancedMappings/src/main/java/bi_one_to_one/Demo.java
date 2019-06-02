package bi_one_to_one;

import bi_one_to_one.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class Demo {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.createSession()) {
      Serializable id = createDemo(session);
      InstructorDetail instructorDetail = readDemo(session, id);
      deleteDemo(session, instructorDetail);
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

  private static Serializable createDemo(Session session) {
    // create the objects
    InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com", "Coding");
    Instructor instructor = new Instructor("John", "Doe", "john.doe@example.com", instructorDetail);
    instructorDetail.setInstructor(instructor);

    // start a transaction
    Transaction transaction = session.beginTransaction();

    // save the instructors. Because of CascadeType.ALL this will also save the instructorDetails object
    Serializable id = session.save(instructor);

    // commit transactino
    transaction.commit();

    return id;
  }

  private static InstructorDetail readDemo(Session session, Serializable id) {
    InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

    System.out.println("Printing the result...");
    System.out.println(instructorDetail);
    System.out.println(instructorDetail.getInstructor());

    return instructorDetail;
  }

  private static void deleteDemo(Session session, InstructorDetail instructorDetail) {
    Transaction transaction = session.beginTransaction();

    session.createQuery("delete from bi_one_to_one.Instructor where id = :id")
           .setParameter("id", instructorDetail.getInstructor().getId())
           .executeUpdate();

    transaction.commit();
  }

}