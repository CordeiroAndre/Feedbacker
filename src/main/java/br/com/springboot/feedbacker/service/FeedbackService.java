package br.com.springboot.feedbacker.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.feedbacker.models.Feedback;
import br.com.springboot.feedbacker.models.Student;
import br.com.springboot.feedbacker.models.DTOs.FeedbackDTO;
import br.com.springboot.feedbacker.repository.FeedbackRepository;
import br.com.springboot.feedbacker.repository.StudentRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private StudentRepository studentRepository;
    
    public Feedback CreateFeedback(Feedback feedbackToSave, long studentId){
       Feedback feedback =  feedbackRepository.save(feedbackToSave);
       Student student = studentRepository.findById(studentId).get();
       student.getFeedbacks().add(feedback);
       studentRepository.save(student);
       return feedback;
    }

    public Feedback findFeedbackById(Long id){
        try {
            return feedbackRepository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any feedback with this ID");
        }
    }

    public boolean deleteFeedbackById(Long id){
       try {
            Feedback feedbackToDelete = feedbackRepository.findById(id).get();
            feedbackRepository.delete(feedbackToDelete);
            return true;
        } catch (NoSuchElementException exception) {
            // treated at the controller level
            throw new NoSuchElementException("Couldn`t find any feedback with this ID");
        }
    }

    public Feedback updateFeedback(Long id, FeedbackDTO updatedFeedback) {
         try {
            Feedback feedback = feedbackRepository.findById(id).get();
            feedback.setBehaviourRate(updatedFeedback.behaviourRate());
            feedback.setDifficultyRate(updatedFeedback.difficultyRate());
            feedback.setEngagementRate(updatedFeedback.engagementRate());
            feedback.setModifiedDate(LocalDateTime.now());
            return feedbackRepository.save(feedback);
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any feedback with this ID");
        }
    }
}
