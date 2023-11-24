package com.college.bootrestproject.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.bootrestproject.entities.Course;
import com.college.bootrestproject.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
	public Teacher findById(int id);
}
