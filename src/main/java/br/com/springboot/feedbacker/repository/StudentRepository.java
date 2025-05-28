package br.com.springboot.feedbacker.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.springboot.feedbacker.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
