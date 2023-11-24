package com.college.bootrestproject.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.bootrestproject.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	public Student findById(int id);
}