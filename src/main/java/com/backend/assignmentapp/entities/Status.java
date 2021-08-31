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
public class Status extends Base {
    @OneToMany(mappedBy = "status")
    private List<Submission> submissions;

    @Column(unique=true)
    private String name;
}
