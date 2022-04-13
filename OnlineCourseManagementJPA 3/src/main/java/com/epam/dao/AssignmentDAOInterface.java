package com.epam.dao;

import java.util.List;

import com.epam.entity.Assignment;
import com.epam.entity.Course;

public interface AssignmentDAOInterface {
	public Course getCourse(int id,String courseName);
	public void add(Assignment assignment);
	public void delete(int cid,String assignmentName);
	public List<Assignment> view(int cid);

}
