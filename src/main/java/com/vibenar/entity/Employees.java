package com.vibenar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employees {

    private int id;
    private String name;
    private String last_name;
    private String middle_name;
    private String email;
    private String nationality;
    private Date date_of_birth;
    private String study;
    private Date date_of_finish;
    private String phone;
    private String education;
}
