package com.epam.dao;

import java.util.List;

import com.epam.entity.Assignment;
import com.epam.entity.Course;

public interface AssignmentDAO {
 
	public Course getCourse(int id,String c);
	public Assignment add(Assignment assignment);
	public Assignment find(int aid);
	public void delete(int id);
	public List<Assignment> view(Course c);

}
