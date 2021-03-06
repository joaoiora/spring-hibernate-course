package com.joaoiora.demo;

import org.hibernate.cfg.Configuration;

import com.joaoiora.entity.Course;
import com.joaoiora.entity.Instructor;
import com.joaoiora.entity.InstructorDetail;
import com.joaoiora.entity.Review;
import com.joaoiora.entity.Student;

/**
 * @author João Iora
 */
public class CreateStudentDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (final var factory = new Configuration().configure("hb-mappings-hibernate.cfg.xml")
        .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
         final var session = factory.getCurrentSession()) {
      session.beginTransaction();
      session.save(new Student("John", "Doe", "john@doe.com"));
      session.getTransaction().commit();
    }
  }

}
