package com.college.bootrestproject.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
interface study{
    void studentStudy();
}
@Entity
@Table(name="students")
public class Student implements study {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	private String studentId;
	protected String name;
    private  int age;
    private String address;
    private String student_Type;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
    @JsonIgnoreProperties("students")
    private Set<Course> courses = new HashSet<>();
    
	public Student(int id, String studentId, String name, int age, String address, String student_Type) {
		
		Id = id;
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.student_Type = student_Type;
	}
	
	public Student(int id, String studentId, String name, int age, String address, String student_Type,
			Set<Course> courses) {
		super();
		Id = id;
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.student_Type = student_Type;
		this.courses = courses;
	}
	public Student() {
		
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudent_Type() {
		return student_Type;
	}
	public void setStudent_Type(String student_Type) {
		this.student_Type = student_Type;
	}
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", studentId=" + studentId + ", name=" + name + ", age=" + age + ", address="
				+ address + ", student_Type=" + student_Type + "]";
	}

	public void enrollInCourse(Course course) {
        if (course != null && course.isAvailableForEnrollment()) {
            courses.add(course);
            course.getStudents().add(this);
        }
    }

	@Override
	public void studentStudy() {
		System.out.println("Hello This is Student entity override method");
		
	}
}


