package com.college.bootrestproject.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.bootrestproject.entities.Course;
import com.college.bootrestproject.entities.Student;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	public Course findById(int id);
}
