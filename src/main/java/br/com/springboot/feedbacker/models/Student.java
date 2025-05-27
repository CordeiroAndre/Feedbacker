package br.com.springboot.feedbacker.models;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @OneToMany
    private HashSet<Feedback> feedbacks;
}
