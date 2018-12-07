package com.ibecole.ibecole.entity.admin;

import com.ibecole.ibecole.commun.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(schema = StaticUtil.SCH_ADMIN, name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false, unique = true, length = 30)
    private String password;
}
