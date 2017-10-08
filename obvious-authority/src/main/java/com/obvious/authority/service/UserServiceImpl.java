package com.obvious.authority.service;

import com.obvious.authority.dao.UserRepository;
import com.obvious.authority.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Getter
    @Setter
    private UserRepository userRepository;

    /**
     * check the user exists at database by account and password
     * @param account
     * @param passwd
     * @return
     */
    @Override
    public UserEntity checkUser(String account, String passwd) {
        return userRepository.findByNamePasswd(account, passwd);
    }

    /**
     * check the user exists at database by account.
     * @param account
     * @return
     */
    @Override
    public UserEntity checkUser(String account) {
        return userRepository.findByName(account);
    }
}
