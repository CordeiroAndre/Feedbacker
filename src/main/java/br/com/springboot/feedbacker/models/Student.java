package br.com.springboot.feedbacker.models;

import java.util.HashSet;

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
public class Student extends ModelTemplate {

    private String name; 
    private String cpf;
    private HashSet<Feedback> feedbacks;
}
