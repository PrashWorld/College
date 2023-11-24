package com.college.bootrestproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.bootrestproject.dao.CourseRepository;
import com.college.bootrestproject.entities.Course;
import com.college.bootrestproject.entities.Student;

@Component
public class CourseService {
	
	    @Autowired
	    private CourseRepository courseRepository;

	    //GetAllCourses
		public List<Course> getAllCourses(){
			
			try {
				List<Course> list =(List<Course>)this.courseRepository.findAll();
				return list;
				} catch(Exception e) {
					e.printStackTrace();
		        return null;
				}
		}
		
		//GetCourseById
		public Course getCoursebyId(int id){
			
			try {
				Course Course =this.courseRepository.findById(id);
				return Course;
				} catch(Exception e) {
					e.printStackTrace();
		        return null;
				}
		}
		
		//AddCourse
		public Course addCourse(Course s) {
			
			try {
				Course result = this.courseRepository.save(s);
				return result;
				} catch(Exception e) {
					e.printStackTrace();
		        return null;
				}
		}
		
		//DeleteCourse
		public void deleteCourse(int id) {
			
			try {
				courseRepository.deleteById(id);
				} catch(Exception e) {
					e.printStackTrace();
				}
		}
		
		//updateCourse
		public void updateCourse(Course course, int id)
		{
            try {
			course.setId(id);
			courseRepository.save(course);
            }
            catch(Exception e) {
				e.printStackTrace();
			}
			
		}


		
		
}
