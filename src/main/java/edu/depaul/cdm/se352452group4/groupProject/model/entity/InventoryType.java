package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class InventoryType implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nameType;
}
