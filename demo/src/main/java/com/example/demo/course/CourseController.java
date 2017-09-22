package com.example.demo.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {	
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String topicId, @PathVariable String courseId) {
		return courseService.getCourse(topicId, courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(courseId, course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
	
}
