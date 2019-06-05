package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// DTO
@Data
@Entity

public class Account implements Serializable {
	private static final long serialVersionUID = 1315126800929728520L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int account_Id;

//	@Column(name = "firstName")
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Temporal(TemporalType.DATE)
    private Date accountCreated;

//    public Account(Integer id, String firstName, String lastName, String email, String password){
//        this.account_Id = id;
//        this.firstName = firstName;
//        this.lastName  = lastName;
//        this.email     = email;
//        this.password  = password;
//    }
}
