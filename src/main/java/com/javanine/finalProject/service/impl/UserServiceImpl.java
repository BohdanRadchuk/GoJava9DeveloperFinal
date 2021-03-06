package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.repository.RoleRepository;
import com.javanine.finalProject.repository.UserRepository;
import com.javanine.finalProject.service.UserService;
import com.javanine.finalProject.util.RoleUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

/**
 * Service layer {@link UserService}
 */

@Slf4j
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

    /**
     * The method calls repository's method to save user
     * @param user - user
     * @return created user
     */
    @Override
    public UserDTO save(User user) {
        notNull(user, "user is null");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByRoleName(RoleUtil.ROLE_EMPLOYEE));
        user.setRoles(roles);
        final User created = userRepository.save(user);
        log.info("User created");
        return userRepository.findInId(created.getId());
    }

    /**
     * The method calls repository's method to get useer by id
     * @param id - id
     * @return id user
     */
    @Override
    public UserDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("User found");
        return userRepository.findInId(id);
    }

    /**
     * The method calls repository's method to get list of users
     * @param page - page, count starts from 0
     * @param limit - page limit
     * @return list
     */
    @Override
    public List<UserDTO> findAll(int page, int limit) {
        log.info("Found all users");
        return userRepository.findAllDto(PageRequest.of(page, limit));
    }

    /**
     * The method calls repository's method to update user
     * @param user - user
     * @return updated user
     */
    @Override
    public UserDTO update(User user) {
        notNull(user, "user is null");
        final User updated = userRepository.saveAndFlush(user);
        log.info("User updated");
        return userRepository.findInId(updated.getId());
    }

    /**
     * The method calls repository's method to delete user
     * @param id - id
     */
    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("User deleted");
        userRepository.deleteById(id);
    }
}
