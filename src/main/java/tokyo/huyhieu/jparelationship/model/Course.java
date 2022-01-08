package tokyo.huyhieu.jparelationship.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name="TEACHER_ID", referencedColumnName = "ID")
	private Teacher teacher;
	
	@OneToOne(mappedBy = "course")
	private CourseMaterial material;
	
	@ManyToMany
	@JoinTable (
			name = "STUDENTS_COURSES",
			joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name= "STUDENT_ID", referencedColumnName ="ID")
			
	)
	private List<Student> students = new ArrayList<>();
	
	public Course() {
		
	}
	
	public CourseMaterial getMaterial() {
		return material;
	}

	public void setMaterial(CourseMaterial material) {
		this.material = material;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
}
