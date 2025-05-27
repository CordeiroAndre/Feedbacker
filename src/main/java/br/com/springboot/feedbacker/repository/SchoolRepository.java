package br.com.springboot.feedbacker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.springboot.feedbacker.models.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{
}
