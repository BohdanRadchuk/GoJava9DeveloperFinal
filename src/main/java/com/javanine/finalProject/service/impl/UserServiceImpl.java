package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.repository.EmployeeRepository;
import com.javanine.finalProject.repository.RoleRepository;
import com.javanine.finalProject.repository.UserRepository;
import com.javanine.finalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

   /* @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/      //password encoding



    @Override
    public void save(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }



    @Override
    public User findById(Long id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
