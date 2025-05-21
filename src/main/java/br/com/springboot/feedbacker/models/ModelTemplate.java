package br.com.springboot.feedbacker.models;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ModelTemplate {

    private Timestamp createdDate;
    private Timestamp modifiedDate;

}
