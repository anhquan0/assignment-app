package com.backend.assignmentapp.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Assignment extends Base{
    @OneToMany(mappedBy = "assignment")
    private List<Submission> submissions;

    @Column
    private String question;

    @Column
    private Date createdDate;

    @Column
    private Date modifiedDate;


    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

}
