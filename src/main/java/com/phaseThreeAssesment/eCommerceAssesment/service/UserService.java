package com.phaseThreeAssesment.eCommerceAssesment.service;

import com.phaseThreeAssesment.eCommerceAssesment.model.User;
import com.phaseThreeAssesment.eCommerceAssesment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> fetchList(){return userRepository.findAll();}

    public User findById(long id){return userRepository.findById(id).orElse(null);}

    public User create(User user){
        user.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        user.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public User update(long id, User userNew){
        User user = userRepository.findById(id).orElse(null);
        if (null != user){
            userNew.setUserId(id);
            userNew.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
            userNew.setCreatedAt(user.getCreatedAt());
            return userRepository.save(userNew);
        }
        return null;
    }


    public void delete(long id) {
        User user = userRepository.findById(id).orElse(null);
        if (null != user){
            userRepository.delete(user);
        }
    }

}
