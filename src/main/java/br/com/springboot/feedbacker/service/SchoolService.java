package br.com.springboot.feedbacker.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.feedbacker.models.School;
import br.com.springboot.feedbacker.models.DTOs.SchoolDTO;
import br.com.springboot.feedbacker.repository.SchoolRepository;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public School CreateSchool(School schoolToSave){
       School school =  schoolRepository.save(schoolToSave);
       return school;
    }

    public School findSchoolById(Long id){
        try {
            return schoolRepository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any school with this ID");
        }
    }

    public boolean deleteSchoolById(Long id){
       try {
            School schoolToDelete = schoolRepository.findById(id).get();
            schoolRepository.delete(schoolToDelete);
            return true;
        } catch (NoSuchElementException exception) {
            // treated at the controller level
            throw new NoSuchElementException("Couldn`t find any school with this ID");
        }
    }

    public School updateSchool(Long id, SchoolDTO updatedSchool) {
         try {
            School school = schoolRepository.findById(id).get();
            school.setName(updatedSchool.name());
            school.setModifiedDate(LocalDateTime.now());
            return schoolRepository.save(school);
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any school with this ID");
        }
    }

    public School updateSchool(School updatedSchool){
        return schoolRepository.save(updatedSchool);
    }

}
