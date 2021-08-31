package com.backend.assignmentapp.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Subject extends Base {
    @OneToMany(mappedBy = "subject")
    private List<Division> division;

    @Column(unique=true)
    private String name;

    @Column
    private int duration;
}

