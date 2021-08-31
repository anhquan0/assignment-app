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
public class Role extends Base {
    @OneToMany(mappedBy = "role")
    private List<Users> users;

    @Column(unique=true, nullable = false)
    private String name;
}
