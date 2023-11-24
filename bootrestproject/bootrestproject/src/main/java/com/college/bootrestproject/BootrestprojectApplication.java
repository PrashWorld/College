package com.college.bootrestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.college.bootrestproject.dao.CourseRepository;
import com.college.bootrestproject.dao.TeacherRepository;
import com.college.bootrestproject.entities.Student;
import com.college.bootrestproject.entities.Teacher;


@SpringBootApplication
public class BootrestprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootrestprojectApplication.class, args);
		TeacherRepository teacherRepository= context.getBean(TeacherRepository.class); 
		Teacher teacher = new Teacher();
		teacher.teacherTeach();//overriding method
		Teacher Ramesh = new Teacher(1,"Dr Ramesh Babu Batula","RAMESH19",32,"Jaipur","PHD &M.phil","Assistant","3 Years");
		Ramesh.displayInformation(); //overloading
        Ramesh.displayInformation(32);
        
        Student student = new Student();
		student.studentStudy();//overriding method
        
        
	}

}
