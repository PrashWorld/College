package com.college.bootrestproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.bootrestproject.dao.CourseRepository;
import com.college.bootrestproject.dao.TeacherRepository;
import com.college.bootrestproject.entities.Course;
import com.college.bootrestproject.entities.Student;
import com.college.bootrestproject.entities.Teacher;

@Component
public class TeacherService {
	
	    @Autowired
	    private TeacherRepository teacherRepository;
	    @Autowired
		private CourseRepository courseRepository;
		
	    //GetAllTeachers
		public List<Teacher> getAllTeachers(){
			try {
				List<Teacher> list = (List<Teacher>) this.teacherRepository.findAll();
				return list;
			} catch (Exception e) {
				// Handle exceptions, log or rethrow if necessary
				e.printStackTrace();
				return null;
			}
		}
			
		//GetTeacherById
		public Teacher getTeacherbyId(int id){
			Teacher teacher=null;
			try {
				teacher = this.teacherRepository.findById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return teacher;
		}
			
		//AddTeacher
		public Teacher addTeacher(Teacher s) {
			try {
				Teacher result = this.teacherRepository.save(s);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		//DeleteTeacher
		public void deleteTeacher(int id) {
				
				try {
					teacherRepository.deleteById(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		//updateTeacher
		public void updateTeacher(Teacher teacher, int id){
		        try {
					teacher.setId(id);
					teacherRepository.save(teacher);
		            }
		            catch(Exception e) {
						e.printStackTrace();
					}
					
		}
		
		//Assign teacher to a course
		public void assignTeacherToCourse(int teacherId, int courseId) {
			try {
				Teacher teacher = teacherRepository.findById(teacherId);
				Course course = courseRepository.findById(courseId);

				if (teacher != null && course != null) {
					if (teacher.qualifiedToTeach(course)) {
						teacher.getCourses().add(course);
						teacherRepository.save(teacher);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	    }
		
		

}
