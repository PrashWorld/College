package com.college.bootrestproject.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.bootrestproject.entities.Student;
import com.college.bootrestproject.services.StudentService;

import java.util.List;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
	    List<Student> list = this.studentService.getAllStudents();
	    if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	    }
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		Student student= this.studentService.getStudentbyId(id);
		if(student==null) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(student));
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student s = null;
		try {
			s=this.studentService.addStudent(student);
			return  ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e){
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
			this.studentService.deleteStudent(id);	
	}	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateBook(@RequestBody Student student,@PathVariable("id") int id) 
	{
		try {
		   this.studentService.updateStudent(student,id);
		   return ResponseEntity.ok().body(student);	
		}catch(Exception e) {
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping("/{studentId}/enroll-course/{courseId}")
    public ResponseEntity<Void> enrollStudentInCourse(@PathVariable int studentId,@PathVariable int courseId) {

        studentService.enrollStudentInCourse(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
    
}
