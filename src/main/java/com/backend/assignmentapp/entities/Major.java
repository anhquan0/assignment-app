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
public class Major extends Base {
    @OneToMany(mappedBy = "major")
    private List<Class> classes;

    @Column(unique=true)
    private String name;
}
