package tokyo.huyhieu.jparelationship.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "STUD")
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BIRTHDATE")
	@Temporal(TemporalType.DATE)
	private Date birthDateAsDate;

	@Column(name = "BIRTHDATE", insertable = false, updatable = false)
	private LocalDate birthDateAsLocalDate;

//	@Enumerated(EnumType.STRING)
//	private Gender gender;
//	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "ST_STREET")),
			@AttributeOverride(name = "number", column = @Column(name = "ST_NUMBER")),
			@AttributeOverride(name = "city", column = @Column(name = "ST_CITY")),

	})
	private Address address;

	@ManyToMany(mappedBy = "students")
	private List<Course> courses = new ArrayList<>();

	public Student() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDateAsDate() {
		return birthDateAsDate;
	}

	public void setBirthDateAsDate(Date birthDateAsDate) {
		this.birthDateAsDate = birthDateAsDate;
	}

	public LocalDate getBirthDateAsLocalDate() {
		return birthDateAsLocalDate;
	}

	public void setBirthDateAsLocalDate(LocalDate birthDateAsLocalDate) {
		this.birthDateAsLocalDate = birthDateAsLocalDate;
	}

//	public Gender getGender() {
//		return gender;
//	}
//
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
