package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

// DTO
@Data
@Entity
public class Account implements Serializable {
    public Account(){}
    public Account(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.password  = password;
    }

	private static final long serialVersionUID = 1315126800929728520L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_Id;

	@Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    private String email;

    private String password;
}
