package tokyo.huyhieu.jparelationship.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokyo.huyhieu.jparelationship.model.Student;
import tokyo.huyhieu.jparelationship.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	@Override
	@Transactional
	public Student getStudent(Long id) {
		return studentRepository.findById(id).get();
	}

	
	@Override
	@Transactional
	public void deleteStudent(Long theId) {
		studentRepository.deleteById(theId);
	}
	
	
}
