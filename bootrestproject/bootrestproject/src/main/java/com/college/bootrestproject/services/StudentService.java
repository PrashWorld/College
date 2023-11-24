package com.college.bootrestproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.bootrestproject.dao.CourseRepository;
import com.college.bootrestproject.dao.StudentRepository;
import com.college.bootrestproject.entities.Course;
import com.college.bootrestproject.entities.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	//GetAllStudents
	public List<Student> getAllStudents(){
		try {
		List<Student> list =(List<Student>) this.studentRepository.findAll();
		return list;
		} catch(Exception e) {
			e.printStackTrace();
        return null;
		}
	}
	
	//GetStudentbyId
	public Student getStudentbyId(int id){
		
		try {
			Student student =this.studentRepository.findById(id);
			return student;
		} catch(Exception e) {
			e.printStackTrace();
	        return null;
			}
	}
	
	//AddStudent
	public Student addStudent(Student s) {
		
		try {
			Student result = this.studentRepository.save(s);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
	        return null;
		}
		
	}
	
	//DeleteStudent
	public void deleteStudent(int id) {
		
		try {
			studentRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	//updateStudent
	public void updateStudent(Student student, int id){
	     try {
			student.setId(id);
			studentRepository.save(student);
	        } catch(Exception e) {
					e.printStackTrace();
			}
				
	}
	
	//enroll student in a course
	public void enrollStudentInCourse(int studentId, int courseId) {
   
        try {
        	 Student student = studentRepository.findById(studentId);
             Course course = courseRepository.findById(courseId);

             if (student != null && course != null) {
                 student.enrollInCourse(course);
                 studentRepository.save(student);
             }
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	
}
