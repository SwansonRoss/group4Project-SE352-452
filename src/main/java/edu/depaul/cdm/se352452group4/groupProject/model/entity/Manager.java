package edu.depaul.cdm.se352452group4.groupProject.model.entity;


import com.fasterxml.classmate.GenericType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "manager")
public class Manager implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(max = 5)
    private String code;


    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
