package com.epam.dao;

import java.util.List;

import com.epam.entity.Assignment;
import com.epam.entity.Question;

public interface QuestionDAO {
	public Assignment getAssignment(String a);
	public void add(Question a);
	public void delete(Assignment ass,int id);
	public List<Question> view(Assignment a);

}
