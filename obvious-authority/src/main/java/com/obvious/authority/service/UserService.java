package com.obvious.authority.service;

import com.obvious.authority.entity.UserEntity;

public interface UserService {

    UserEntity checkUser(String username, String passwd);

    UserEntity checkUser(String username);
}
