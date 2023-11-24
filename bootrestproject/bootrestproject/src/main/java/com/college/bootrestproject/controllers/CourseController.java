package com.college.bootrestproject.controllers;
import java.util.List;
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

import com.college.bootrestproject.entities.Course;
import com.college.bootrestproject.entities.Student;
import com.college.bootrestproject.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {

		List<Course> list= this.courseService.getAllCourses();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));	
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
		Course course= this.courseService.getCoursebyId(id);
		if(course==null) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(course));
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course s = null;
		try {
			s=this.courseService.addCourse(course);
			return  ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e){
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable("id") int id) {
			this.courseService.deleteCourse(id);	
	}
	
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateBook(@RequestBody Course course,@PathVariable("id") int id) 
	{
		try {
		   this.courseService.updateCourse(course,id);
		   return ResponseEntity.ok().body(course);	
		}catch(Exception e) {
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	   

}
