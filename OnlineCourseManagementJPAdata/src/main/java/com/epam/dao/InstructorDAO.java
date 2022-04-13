package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.dto.InstructorDTO;
import com.epam.entity.Instructor;

public interface InstructorDAO extends JpaRepository<Instructor, Integer> {
	
	
}
