package com.joaoiora.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author João Iora
 */
@Entity
@Table(name = "instructor")
public class Instructor {

  /**
   *
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  /**
   *
   */
  @Column(name = "first_name")
  private String firstName;

  /**
   *
   */
  @Column(name = "last_name")
  private String lastName;

  /**
   *
   */
  @Column(name = "email")
  private String email;

  /**
   *
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  /**
   *
   */
  @OneToMany(fetch = FetchType.LAZY,
             mappedBy = "instructor",
             cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
  private List<Course> courses = new ArrayList<>();

  /**
   *
   */
  public Instructor() {
    super();
  }

  /**
   * @param firstName
   * @param lastName
   * @param email
   */
  public Instructor(String firstName, String lastName, String email) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Instructor [id=" +
           id +
           ", firstName=" +
           firstName +
           ", lastName=" +
           lastName +
           ", email=" +
           email +
           ", instructorDetail=" +
           instructorDetail +
           "]";
  }

  /**
   * @param course
   */
  public void add(Course course) {
    courses.add(course);
    course.setInstructor(this);
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the instructorDetail
   */
  public InstructorDetail getInstructorDetail() {
    return instructorDetail;
  }

  /**
   * @param instructorDetail the instructorDetail to set
   */
  public void setInstructorDetail(InstructorDetail instructorDetail) {
    this.instructorDetail = instructorDetail;
  }

  /**
   * @return the courses
   */
  public List<Course> getCourses() {
    return courses;
  }

  /**
   * @param courses the courses to set
   */
  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

}
