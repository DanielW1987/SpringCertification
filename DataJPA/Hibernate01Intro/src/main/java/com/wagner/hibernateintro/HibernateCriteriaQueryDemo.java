package com.wagner.hibernateintro;

import com.wagner.hibernateintro.model.Student;
import com.wagner.hibernateintro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class HibernateCriteriaQueryDemo {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.createSession()) {
      Transaction transaction = session.getTransaction();

      // start transaction
      transaction.begin();

      // ToDo CriteriaQuery?
      // example with CriteriaBuilder
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);

      // commit the transaction
      transaction.commit();
    }
    finally {
      HibernateUtil.closeSessionFactory();
    }
  }

}
