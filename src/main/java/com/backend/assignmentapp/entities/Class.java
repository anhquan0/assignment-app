package com.backend.assignmentapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Class extends Base {
    @OneToMany(mappedBy = "classes")
    private List<Division> division;

    @OneToMany(mappedBy = "classes")
    private List<Student> students;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "major_id", nullable = false)
    private Major major;
}
