package com.example.demo.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
			
	public List<Course> getAllCourses(String topicId) {
		List<Course> retVal = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(retVal::add);
		return retVal;
	}
	
	public Course getCourse(String topicId, String courseId) {
		
		return courseRepository.findOne(courseId);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(String courseId, Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String courseId) {
		courseRepository.delete(courseId);
	}
	
}
