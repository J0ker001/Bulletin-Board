package ru.skypro.homework.service.impl;

import org.mapstruct.Named;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Collection;
import java.util.Collections;

import static ru.skypro.homework.dto.Role.USER;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        User createUser = userRepository.findById(user.getId()).orElse(user);

        if (createUser.getRole() == null) {
            createUser.setRole(USER.name());
        }

        return userRepository.save(createUser);

    }

    @Override
    public Collection<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User initialUser = userRepository.findById(user.getId()).orElse(user);

        user.setPassword(initialUser.getPassword());
        user.setRole(initialUser.getRole());

        return userRepository.save(user);
    }

    @Override
    @Named("getUserById")
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден!"));
    }
}
