package com.sudesh.bookstore.services;

import com.sudesh.bookstore.entity.User;

public interface AuthService {
    String register(User user);
    String login(String username, String password);
}


