package br.com.springboot.feedbacker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.feedbacker.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
