package br.com.springboot.feedbacker.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.feedbacker.models.School;
import br.com.springboot.feedbacker.repository.SchoolRepository;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public void CreateSchool(School school){
        schoolRepository.save(school);
    }

    public School findSchoolById(Long id){
        try {
            return schoolRepository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any school with this ID");
        }
    }

    public School deleteSchoolById(Long id){
       try {
            School schoolToDelete = schoolRepository.findById(id).get();
            schoolRepository.delete(schoolToDelete);
            return schoolToDelete;
        } catch (NoSuchElementException exception) {
            // treated at the controller level
            throw new NoSuchElementException("Couldn`t find any school with this ID");
        }
    }

}
