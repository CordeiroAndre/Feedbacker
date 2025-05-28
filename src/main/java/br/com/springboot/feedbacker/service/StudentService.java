package br.com.springboot.feedbacker.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.feedbacker.models.Student;
import br.com.springboot.feedbacker.models.DTOs.UpdateStudentDTO;
import br.com.springboot.feedbacker.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student CreateStudent(Student studentToSave){
       Student student =  studentRepository.save(studentToSave);
       return student;
    }

    public Student findStudentById(Long id){
        try {
            return studentRepository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any student with this ID");
        }
    }

    public Student deleteStudentById(Long id){
       try {
            Student studentToDelete = studentRepository.findById(id).get();
            studentRepository.delete(studentToDelete);
            return studentToDelete;
        } catch (NoSuchElementException exception) {
            // treated at the controller level
            throw new NoSuchElementException("Couldn`t find any student with this ID");
        }
    }

    public Student updateStudent(Long id, UpdateStudentDTO updatedStudent) {
         try {
            Student student = studentRepository.findById(id).get();
            student.setName(updatedStudent.name());
            student.setCpf(updatedStudent.cpf());
            student.setModifiedDate(LocalDateTime.now());
            return studentRepository.save(student);
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Couldn`t find any student with this ID");
        }
    }


}
