package tokyo.huyhieu.jparelationship.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokyo.huyhieu.jparelationship.model.Course;
import tokyo.huyhieu.jparelationship.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	@Transactional
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}

	@Override
	@Transactional
	public Course getCourse(Long theId) {
		// TODO Auto-generated method stub
		return courseRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public void deleteCourse(Long theId) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(theId);
	}

}
