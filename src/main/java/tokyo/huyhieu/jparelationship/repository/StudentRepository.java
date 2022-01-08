package tokyo.huyhieu.jparelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tokyo.huyhieu.jparelationship.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long>{

}
