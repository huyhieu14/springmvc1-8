package tokyo.huyhieu.jparelationship.service;

import java.util.List;

import tokyo.huyhieu.jparelationship.model.Student;

public interface StudentService {
	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(Long theId);

	public void deleteStudent(Long theId);
}
