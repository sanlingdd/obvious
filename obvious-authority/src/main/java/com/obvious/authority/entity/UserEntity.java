package com.obvious.authority.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWD")
    private String passwd;


    private Long roleId;

    @Version
    private Integer version;
}
