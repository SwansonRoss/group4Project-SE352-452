package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Images implements Serializable {

    @Id
    @GeneratedValue
    private Long itemId; //FK, PK
    private String image;
}
