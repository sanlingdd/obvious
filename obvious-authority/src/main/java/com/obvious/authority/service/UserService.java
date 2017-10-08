package com.obvious.authority.service;

import com.obvious.authority.entity.UserEntity;

public interface UserService {

    UserEntity getUserByNameAndPasswd(String name, String passwd);
}
