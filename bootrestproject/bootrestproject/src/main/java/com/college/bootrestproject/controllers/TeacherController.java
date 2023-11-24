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

import com.college.bootrestproject.entities.Student;
import com.college.bootrestproject.entities.Teacher;
import com.college.bootrestproject.services.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/teachers")
	public ResponseEntity<List<Teacher>> getAllTeachers() {

		List<Teacher> list= this.teacherService.getAllTeachers();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));	
	}
	
	@GetMapping("/teachers/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") int id) {
		Teacher teacher= this.teacherService.getTeacherbyId(id);
		if(teacher==null) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(teacher));
	}
	
	@PostMapping("/teachers")
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		Teacher s = null;
		try {
			s=this.teacherService.addTeacher(teacher);
			return  ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e){
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/teachers/{id}")
	public void deleteTeacher(@PathVariable("id") int id) {
			this.teacherService.deleteTeacher(id);
	}
	
	@PutMapping("/teachers/{id}")
	public ResponseEntity<Teacher> updateBook(@RequestBody Teacher teacher,@PathVariable("id") int id) 
	{
		try {
		   this.teacherService.updateTeacher(teacher,id);
		   return ResponseEntity.ok().body(teacher);	
		}catch(Exception e) {
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/{teacherId}/assign-teacher/{courseId}")
    public ResponseEntity<Void> assignTeacherToCourse(@PathVariable int teacherId,@PathVariable int courseId) {

        teacherService.assignTeacherToCourse(teacherId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	   

}


