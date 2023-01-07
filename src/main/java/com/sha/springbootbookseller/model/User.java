package com.sha.springbootbookseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name="users")// user  ismi postgresql de ozel bir isimdir oyuzdern user deme
public class User {
//id alanı olacak ve o primary  key olacak
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name="username",unique = true, nullable = false, length = 100)
    private String username;

    @Column(name="password", nullable = false, length = 100)
    private String password;

    @Column(name= "name", nullable = false, length = 100)
    private String name;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private Role role;

    @Transient
    private String token;
}
