package com.college.bootrestproject.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="courses")
public class Course {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private int Id;
	   private String courseCode;
	   private String name;
	   private String courseType;
	   private int maximumCapacity;
	   private int initialEnrollment;
	  
	    @ManyToMany(mappedBy = "courses",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	    @JsonIgnoreProperties("courses")
	    private Set<Student> students = new HashSet<>();
	    @ManyToMany(mappedBy = "courses",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	    @JsonIgnoreProperties("courses")
	    private Set<Teacher> teachers = new HashSet<>();
	   
	    public Course(int id,String courseCode, String name, int maximumCapacity, int initialEnrollment, String courseType) {
		Id=id;
		this.courseCode = courseCode;
		this.name = name;
		this.maximumCapacity = maximumCapacity;
		this.initialEnrollment = initialEnrollment;
		this.courseType = courseType;
	    }
	   
		public Course(int id,String courseCode, String name, int maximumCapacity, int initialEnrollment, String courseType,Set<Student> students,Set<Teacher> teachers) {
			Id=id;
			this.courseCode = courseCode;
			this.name = name;
			this.maximumCapacity = maximumCapacity;
			this.initialEnrollment = initialEnrollment;
			this.courseType = courseType;
			this.students=students;
			this.teachers=teachers;
		}
	public Course() {
		
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaximumCapacity() {
		return maximumCapacity;
	}
	public void setMaximumCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}
	
	public int getInitialEnrollment() {
		return initialEnrollment;
	}
	
	public void setInitialEnrollment(int initialEnrollment) {
		this.initialEnrollment = initialEnrollment;
	}
	
	public String getCourseType() {
		return courseType;
	}
	
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	

	

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", courseCode=" + courseCode + ", name=" + name + ", courseType=" + courseType
				+ ", maximumCapacity=" + maximumCapacity + ", initialEnrollment=" + initialEnrollment + "]";
	}

	public boolean isAvailableForEnrollment() {
       return students.size() < maximumCapacity;
	}
	
}
	
	

