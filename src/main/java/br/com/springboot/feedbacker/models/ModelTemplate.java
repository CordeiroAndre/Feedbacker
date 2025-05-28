package br.com.springboot.feedbacker.models;

import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public abstract class ModelTemplate {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ModelTemplate(){
       LocalDateTime time = LocalDateTime.now();
        createdDate = time;
        modifiedDate = time;
    }

}
