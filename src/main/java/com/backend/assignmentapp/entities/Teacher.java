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
public class Teacher extends Base {
    @OneToMany(mappedBy = "teacher")
    private List<Division> division;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users teacher;
}