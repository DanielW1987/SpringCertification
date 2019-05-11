package com.wagner.hibernateintro.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

  @Id // Primary Key for the entity
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Transient
  private String alias;

  @Column(name = "email", unique = true)
  private String email;

  public Student() {
  }

  public Student(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @PrePersist
  void prePersist() {
    System.out.println("prePersist");
  }

  @PostPersist
  void postPersist() {
    System.out.println("postPersist");
  }

  @PreUpdate
  void preUpdate() {
    System.out.println("preUpdate");
  }

  @PostUpdate
  void postUpdate() {
    System.out.println("postUpdate");
  }

  @PostLoad
  void postLoad() {
    System.out.println("postLoad");
  }

  @PreRemove
  void preRemove() {
    System.out.println("preRemove");
  }

  @PostRemove
  void postRemove() {
    System.out.println("postRemove");
  }
}
