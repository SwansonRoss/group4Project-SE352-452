package edu.depaul.cdm.se352452group4.groupProject.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


// DTO
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Account implements Serializable {
	private static final long serialVersionUID = 1315126800929728520L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Column(nullable = false)
    @NotBlank
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column()
    private String email;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date accountCreated;

    @Column()
    private String subscribe;

    public Account(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.password  = password;
    }
}
