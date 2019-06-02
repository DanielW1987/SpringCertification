package uni_one_to_one;

import org.hibernate.Session;
import org.hibernate.Transaction;
import uni_one_to_one.util.HibernateUtil;

public class Demo {

  public static void main(String[] args) {

    try(Session session = HibernateUtil.createSession()) {
      createDemo(session);
      deleteDemo(session);
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }

  }

  private static void createDemo(Session session) {
    // create the objects
    InstructorDetail instructorDetail1 = new InstructorDetail("https://youtube.com", "Coding");
    Instructor instructor1 = new Instructor("John", "Doe", "john.doe@example.com", instructorDetail1);

      InstructorDetail instructorDetail2 = new InstructorDetail("https://youtube.com", "Guitar");
    Instructor instructor2 = new Instructor("Maria", "Thompson", "maria.thompson@example.com", instructorDetail2);

    // start a transaction
    Transaction transaction = session.beginTransaction();

    // save the instructors. Because of CascadeType.ALL this will also save the instructorDetails object
    session.save(instructor1);
    session.save(instructor2);

    // commit transactino
    transaction.commit();
  }

  private static void deleteDemo(Session session) {
    // start a transaction
    Transaction transaction = session.beginTransaction();

    int idOfInstructorToDelete = 1;
    Instructor instructor = session.get(Instructor.class, idOfInstructorToDelete);

    // delete the instructor. Because of CascadeType.ALL this will also delete the instructorDetails object
    if (instructor != null) {
      session.delete(instructor);
    }

    // commit transactino
    transaction.commit();
  }

}
