package br.com.springboot.feedbacker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.springboot.feedbacker.models.Feedback;
import br.com.springboot.feedbacker.models.DTOs.FeedbackDTO;
import br.com.springboot.feedbacker.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/")
    public ResponseEntity<Feedback> CreateFeedback(FeedbackDTO feedbackToSave) {
        Feedback newFeedback = new Feedback();
        newFeedback.setEngagementRate(feedbackToSave.engagementRate());
        newFeedback.setDifficultyRate(feedbackToSave.difficultyRate());
        newFeedback.setBehaviourRate(feedbackToSave.behaviourRate());
        Feedback savedFeedback = feedbackService.CreateFeedback(newFeedback, feedbackToSave.studentId());
        return new ResponseEntity<>(savedFeedback, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteFeedback(@PathVariable("id") Long id) {
        feedbackService.deleteFeedbackById(id);
        return new ResponseEntity<>("Deleted Feedback (id "+id+").",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> FindFeedback(@PathVariable("id") Long id) {
        Feedback foundFeedback = feedbackService.findFeedbackById(id);
        return new ResponseEntity<>(foundFeedback, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> UpdateFeedback(@PathVariable("id") Long id, FeedbackDTO updatedFeedback){
        Feedback newFeedbackValue = feedbackService.updateFeedback(id, updatedFeedback);
        return new ResponseEntity<>(newFeedbackValue, HttpStatus.OK);
    }


}
