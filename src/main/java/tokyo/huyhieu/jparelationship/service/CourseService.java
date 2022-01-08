package tokyo.huyhieu.jparelationship.service;

import java.util.List;

import tokyo.huyhieu.jparelationship.model.Course;


public interface CourseService {
	public List<Course> getCourses();

	public void saveCourse(Course course);

	public Course getCourse(Long theId);

	public void deleteCourse(Long theId);
}
