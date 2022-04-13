package com.epam.model_mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.dto.QuestionDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.entity.Instructor;
import com.epam.entity.Question;

@Component
public class ModelMapperService {
	
	
	private ModelMapperService() {}
	public static Instructor convertDtoToInsEntity(InstructorDTO instructorDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(instructorDto,Instructor.class);
	}
	public static CourseDTO convertCourseEntityToDTO(Course c)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(c,CourseDTO.class);
	}
	public static AssignmentsDTO convertAssEntityToDTO(Assignment a)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(a,AssignmentsDTO.class);
	}
	public static Question convertDtoToQuestionEntity(QuestionDTO question)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(question,Question.class);
	}
	
	public static Course convertDtoToCourseEntity(CourseDTO courseDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(courseDto,Course.class);
	}
	
	public static List<CourseDTO> convertList(List<Course> list)
	{
		ModelMapper mapper=new ModelMapper();
		return list.stream().map(i->mapper.map(i,CourseDTO.class)).collect(Collectors.toList());
	
	}
	
	public static List<AssignmentsDTO> convertAssignmentList(List<Assignment> list)
	{
		ModelMapper mapper=new ModelMapper();
		return list.stream().map(i->mapper.map(i,AssignmentsDTO.class)).collect(Collectors.toList());
	
	}
	
	
	public static InstructorDTO convertEntityToDto(Instructor i)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(i,InstructorDTO.class);
	}
	
	public static Assignment convertDtoToAssignmentEntity(AssignmentsDTO assignmentDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(assignmentDto,Assignment.class);
	}

}