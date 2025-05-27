package br.com.springboot.feedbacker.models;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School extends ModelTemplate {
   
    private String name;
    
    @OneToMany
    private HashSet<Student> students;
    
    @ManyToOne  
    private User user;
}
