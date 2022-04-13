package com.epam.dao;

import java.util.List;

import com.epam.entity.Course;
import com.epam.entity.Instructor;

public interface CourseDAOInterface {
	public Instructor find(int id);
	    public List<Course> getAll();
		public void delete(int id,String courseName);
		public List<Course> view(int id);
		public void add(Course course);
	

}
