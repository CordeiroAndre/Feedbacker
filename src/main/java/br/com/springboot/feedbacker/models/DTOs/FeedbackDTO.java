package br.com.springboot.feedbacker.models.DTOs;

public record FeedbackDTO(Long studentId, int behaviourRate, int difficultyRate, int engagementRate) {
}
