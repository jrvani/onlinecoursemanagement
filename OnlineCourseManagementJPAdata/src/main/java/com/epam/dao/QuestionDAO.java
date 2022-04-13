package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Assignment;
import com.epam.entity.Question;

public interface QuestionDAO extends JpaRepository<Question, Integer>{
	

}
