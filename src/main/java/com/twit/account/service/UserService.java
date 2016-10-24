package com.twit.account.service;

import com.twit.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
