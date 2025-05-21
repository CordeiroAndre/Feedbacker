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
public class School extends ModelTemplate {
   
    private String name;
    private HashSet<Student> students;
    private User user;
}
