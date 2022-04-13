package com.epam.dao;

import java.util.List;

import com.epam.entity.Assignment;
import com.epam.entity.Course;

public interface AssignmentDAOInterface {
 
	public Course getCourse(int id,String c);
	public Assignment add(Assignment assignment);
	public void delete(int id);
	public List<Assignment> view(Course c);

}
