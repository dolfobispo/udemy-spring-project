package com.udemy.services;

import com.udemy.entities.User;
import com.udemy.services.exceptions.DatabaseException;
import com.udemy.services.exceptions.ResourceNotFoundException;
import com.udemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public void delete (Long id){
        try{
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException ex){
            throw new DatabaseException(ex.getMessage());

        }


    }
    public User update ( User user){
        try{
            Optional<User> entity = userRepository.findById(user.getId());
            entity.orElseThrow(EntityNotFoundException::new);
            return userRepository.save(user);

        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException(user.getId());
        }

    }
}
