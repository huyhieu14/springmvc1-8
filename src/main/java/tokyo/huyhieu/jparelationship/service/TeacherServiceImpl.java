package tokyo.huyhieu.jparelationship.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokyo.huyhieu.jparelationship.model.Teacher;
import tokyo.huyhieu.jparelationship.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);

	}

	@Override
	@Transactional
	public Teacher getTeacher(Long theId) {
		return teacherRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public void deleteTeacher(Long theId) {
		teacherRepository.deleteById(theId);

	}

}
