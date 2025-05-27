package br.com.springboot.feedbacker.service;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.feedbacker.models.User;
import br.com.springboot.feedbacker.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private boolean validateEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean createUser(User user){
        if(validateEmail(user.getEmail())){
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public User findUserById(Long id){
        try {
            return userRepository.findById(id).get();
        } catch (NoSuchElementException exception) {
            // treated at the controller level
            throw new NoSuchElementException("Couldn`t find any user with this ID");
        }
    }

    public User deleteUserById(Long id){
       try {
            User userToDelete = userRepository.findById(id).get();
            userRepository.delete(userToDelete);
            return userToDelete;
        } catch (NoSuchElementException exception) {
            // treated at the controller level
            throw new NoSuchElementException("Couldn`t find any user with this ID");
        }
    }

}
