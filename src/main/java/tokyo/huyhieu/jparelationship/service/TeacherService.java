package tokyo.huyhieu.jparelationship.service;

import java.util.List;

import tokyo.huyhieu.jparelationship.model.Teacher;


public interface TeacherService {
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher teacher);

	public Teacher getTeacher(Long theId);

	public void deleteTeacher(Long theId);
}
