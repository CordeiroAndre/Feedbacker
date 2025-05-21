package br.com.springboot.feedbacker.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback extends ModelTemplate {

    private int behaviourRate;
    private int engagementRate;
    private int difficultyRate;  
}
