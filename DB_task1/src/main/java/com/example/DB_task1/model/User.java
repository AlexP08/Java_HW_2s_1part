package com.example.DB_task1.model;

import jakarta.persistence.*;

@Entity(name="`user`")
public class User {
    @Id
    @Column(name = "row_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowID;
    @Column(name = "group_id")
    private Long groupID;
    @Column(name = "role_id")
    private Long roleID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "login")
    private String login;
    @Column(name = "password_hash")
    private String passwordHash;

    public User() {
    }

    public User(Long row_id, Long group_id, Long role_id, String first_name, String last_name, String middle_name, String login, String password_hash) {
        this.rowID = row_id;
        this.groupID = group_id;
        this.roleID = role_id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.middleName = middle_name;
        this.login = login;
        this.passwordHash = password_hash;
    }
}