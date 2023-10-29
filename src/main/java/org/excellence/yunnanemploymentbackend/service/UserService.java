package org.excellence.yunnanemploymentbackend.service;

import org.excellence.yunnanemploymentbackend.entity.User;
import org.excellence.yunnanemploymentbackend.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(@NotNull User user) {
        final StringBuilder result = new StringBuilder();
        userRepository.findById(user.getUserId()).ifPresentOrElse(trueUser -> {
            if (trueUser.getPassword().equals(user.getPassword())) {
                // 密码正确
                result.append("success");
            } else {
                result.append("wrong password");
            }
        }, () -> result.append("userId does not exist"));
        return result.toString();
    }

    public String register(@NotNull User user) {
        final StringBuilder result = new StringBuilder();
        userRepository.findById(user.getUserId()).ifPresentOrElse(_ -> result.append("userId has already existed"), () -> {
            userRepository.save(user);
            result.append("success");
        });
        return result.toString();
    }
    
}
