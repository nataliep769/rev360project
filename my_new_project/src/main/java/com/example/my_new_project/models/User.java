package com.example.my_new_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created by Natalie on 7/2/2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;


    private String username;

    private String password;

    private String verify;
}

