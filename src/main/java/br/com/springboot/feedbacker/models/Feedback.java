package br.com.springboot.feedbacker.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback extends ModelTemplate {

    private int behaviourRate;
    private int engagementRate;
    private int difficultyRate;  
}

