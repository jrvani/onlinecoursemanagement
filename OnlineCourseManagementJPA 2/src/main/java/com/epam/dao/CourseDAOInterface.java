package com.epam.dao;

import java.util.List;

import com.epam.entity.Course;

public interface CourseDAOInterface {
		public  void add(Course course);
		public void delete(int id, String courseName);
		public List<Course> view(int id);
	

}
