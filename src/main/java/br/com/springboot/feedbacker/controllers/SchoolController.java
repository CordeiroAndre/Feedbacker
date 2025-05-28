package br.com.springboot.feedbacker.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.springboot.feedbacker.models.School;
import br.com.springboot.feedbacker.models.DTOs.SchoolDTO;
import br.com.springboot.feedbacker.service.SchoolService;
import br.com.springboot.feedbacker.service.UserService;

@RestController
@RequestMapping("/Schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<School> CreateSchool(SchoolDTO schoolToSave) {
        School newSchool = new School();
        newSchool.setName(schoolToSave.name());
        newSchool.setUser(userService.findUserById(schoolToSave.userID()));
        School savedSchool = schoolService.CreateSchool(newSchool);
        return new ResponseEntity<>(savedSchool, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<School> DeleteSchool(@PathVariable("id") Long id) {
        School deletedSchool = schoolService.deleteSchoolById(id);
        return new ResponseEntity<>(deletedSchool,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<School> FindSchool(@PathVariable("id") Long id) {
        School foundSchool = schoolService.findSchoolById(id);
        return new ResponseEntity<>(foundSchool, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> UpdateSchool(@PathVariable("id") Long id, @RequestBody SchoolDTO updatedSchool){
        School newSchoolValue = schoolService.updateSchool(id, updatedSchool);
        return new ResponseEntity<>(newSchoolValue, HttpStatus.OK);
    }

}
