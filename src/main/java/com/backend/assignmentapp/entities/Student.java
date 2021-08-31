package com.backend.assignmentapp.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Student extends Base{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users student;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class classes;

    @OneToMany(mappedBy = "student")
    private List<Submission> submissions;
}
