package one_to_many;

import one_to_many.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class Demo {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.createSession()) {
      Instructor instructor = createDemo(session);
      readDemo(session, instructor.getId());
      deleteDemo(session, instructor);
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

  private static Instructor createDemo(Session session) {
    // create objects
    Instructor instructor = new Instructor("John", "Doe", "john.doe@example.com");
    InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");
    Course javaCourse = new Course("Python in 14 Days");
    Course angularCourse = new Course("JavaScript in 14 Days");

    // wire objects
    instructor.setInstructorDetail(instructorDetail);
    instructor.addCourse(javaCourse);
    instructor.addCourse(angularCourse);

    // persist
    Transaction transaction = session.beginTransaction();
    session.save(instructor);
    session.save(javaCourse);
    session.save(angularCourse);
    transaction.commit();

    return instructor;
  }

  private static void readDemo(Session session, Serializable id) {
    Instructor instructor = session.get(Instructor.class, id);

    System.out.println(instructor);
  }

  private static void deleteDemo(Session session, Instructor instructor) {
    Transaction transaction = session.beginTransaction();
    // remove all of instructors courses
    instructor.getCourses().forEach(session::delete);
    transaction.commit();

    transaction = session.beginTransaction();
    // remove instructor, you cannot delete instructor until you delete all associated courses
    session.delete(instructor);
    transaction.commit();
  }

}
