package com.lamov.database;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column(unique = true)
    private String email;

    @Column
    private String role;

}
