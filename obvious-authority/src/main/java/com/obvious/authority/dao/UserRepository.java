package com.obvious.authority.dao;

import com.obvious.authority.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("from UserEntity where name = :account and passwd = :passwd")
    UserEntity findByNamePasswd(@Param(value = "account")String account,
                                @Param(value = "passwd") String passwd);

    @Query("from UserEntity where account = :account")
    UserEntity findByName(@Param(value = "account") String account);
}
