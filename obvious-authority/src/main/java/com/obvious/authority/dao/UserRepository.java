package com.obvious.authority.dao;

import com.obvious.authority.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    List<User> findByNamePasswd(@Param(value = "name")String name,
                                @Param(value = "passwd") String passwd);
}
