package tokyo.huyhieu.jparelationship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CourseMaterial {
		
	@Id
    @GeneratedValue
	private Long id;
	private String url;

	@OneToOne(optional = false)
	@JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
	private Course course;

	public CourseMaterial() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
