package com.college.bootrestproject.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
interface teach{
    void teacherTeach();
}
@Entity
@Table(name="teachers")
public class Teacher implements teach{
	
	    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int Id;
	    private String teacherId;
	    private String name;
	    private int age;
	    private String address;
	    private String qualification;
	    private String designation;
	    private String experience;
	    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
	    @JsonIgnoreProperties("teachers")
	    private Set<Course> courses = new HashSet<>();
		public Teacher(int id, String name, String teacherId, int age, String address, String qualification,
				String designation, String experience) {
			
			Id = id;
			this.name = name;
			this.teacherId = teacherId;
			this.age = age;
			this.address = address;
			this.qualification = qualification;
			this.designation = designation;
			this.experience = experience;
		}
		
		public Teacher(int id, String teacherId, String name, int age, String address, String qualification,
				String designation, String experience, Set<Course> courses) {
			super();
			Id = id;
			this.teacherId = teacherId;
			this.name = name;
			this.age = age;
			this.address = address;
			this.qualification = qualification;
			this.designation = designation;
			this.experience = experience;
			this.courses = courses;
		}

		public Teacher() {
			
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTeacherId() {
			return teacherId;
		}
		public void setTeacherId(String teacherId) {
			this.teacherId = teacherId;
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
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getExperience() {
			return experience;
		}
		public void setExperience(String experience) {
			this.experience = experience;
		}
		
		public Set<Course> getCourses() {
			return courses;
		}

		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}

		@Override
		public void teacherTeach() {
			System.out.println("Hello This is Teacher entity override method");
			
		}
		
		
		@Override
		public String toString() {
			return "Teacher [Id=" + Id + ", teacherId=" + teacherId + ", name=" + name + ", age=" + age + ", address="
					+ address + ", qualification=" + qualification + ", designation=" + designation + ", experience="
					+ experience + "]";
		}
		
		//MethodOverloading7
		public void displayInformation(){
	        System.out.println("Teacher name is:"+this.name);
	    }
	    public void displayInformation(int age) {
	        if (age == this.age) {
	            System.out.println("Teacher age is:" + age);
	        }else{
	            System.out.println("Age is invalid as per records for the Teacher");
	        }
	    }

		public boolean qualifiedToTeach(Course course){
	        String teacherType= this.getDesignation();
	        String courseType=  course.getCourseType();
	        return (courseType.equals("advancedCourse") && teacherType.equals("Professor")) ||
	                (courseType.equals("introductoryCourse") && teacherType.equals("Assistant"));
	    
	    }
		
		
		
	    
	    
}
