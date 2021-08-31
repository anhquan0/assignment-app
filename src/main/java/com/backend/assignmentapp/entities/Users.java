package com.backend.assignmentapp.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Users extends Base{
    @OneToMany(mappedBy = "teacher")
    private List<Teacher> teacher;

    @OneToMany(mappedBy = "student")
    private List<Student> student;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private byte gender;

    @Column
    private Date dateOfBirth;

    @Column(unique=true)
    private String email;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
