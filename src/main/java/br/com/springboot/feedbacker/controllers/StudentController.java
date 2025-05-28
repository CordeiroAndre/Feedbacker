package br.com.springboot.feedbacker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.springboot.feedbacker.models.School;
import br.com.springboot.feedbacker.models.Student;
import br.com.springboot.feedbacker.models.DTOs.CreateStudentDTO;
import br.com.springboot.feedbacker.models.DTOs.UpdateStudentDTO;
import br.com.springboot.feedbacker.service.SchoolService;
import br.com.springboot.feedbacker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired 
    private SchoolService schoolService;
    
    @PostMapping("/")
    public ResponseEntity<Student> CreateStudent(CreateStudentDTO studentToSave) {
        Student newStudent = new Student();
        newStudent.setName(studentToSave.name());
        newStudent.setCpf(studentToSave.cpf());
        Student savedStudent = studentService.CreateStudent(newStudent);
        School school = schoolService.findSchoolById(studentToSave.schoolId());
        school.getStudents().add(newStudent);
        schoolService.updateSchool(school);
        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> DeleteStudent(@PathVariable("id") Long id) {
        Student deletedStudent = studentService.deleteStudentById(id);
        return new ResponseEntity<>(deletedStudent,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> FindStudent(@PathVariable("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        return new ResponseEntity<>(foundStudent, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> UpdateStudent(@PathVariable("id") Long id, @RequestBody UpdateStudentDTO updatedStudent){
        Student newStudentValue = studentService.updateStudent(id, updatedStudent);
        return new ResponseEntity<>(newStudentValue, HttpStatus.OK);
    }

    
}
