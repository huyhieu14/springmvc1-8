package tokyo.huyhieu.jparelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tokyo.huyhieu.jparelationship.model.Course;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long>{

}
