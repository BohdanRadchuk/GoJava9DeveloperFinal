package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.repository.RoleRepository;
import com.javanine.finalProject.repository.UserRepository;
import com.javanine.finalProject.service.UserService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO findByEmail(String email) {
        hasText(email, "email is empty");
        return userRepository.findInEmail(email);
    }

    @Override
    public UserDTO save(User user) {
        notNull(user, "user is null");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByRoleName(RoleUtil.ROLE_EMPLOYEE));
        user.setRoles(roles);
        final User created = userRepository.save(user);
        return userRepository.findInId(created.getId());
    }

    @Override
    public UserDTO findById(Long id) {
        notNull(id, "id is null");
        return userRepository.findInId(id);
    }

    @Override
    public List<UserDTO> findAll(int page, int limit) {
        return userRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public UserDTO update(User user) {
        notNull(user, "user is null");
        final User updated = userRepository.saveAndFlush(user);
        return userRepository.findInId(updated.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        userRepository.deleteById(id);
    }
}
