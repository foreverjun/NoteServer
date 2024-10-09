package com.example.noteserver.service;

import com.example.noteserver.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}