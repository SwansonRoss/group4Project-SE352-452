package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class InventoryItems implements Serializable {

    @Id
    @GeneratedValue
    private Long itemsId;   // PK

    private String size;    // FK
    private String itemType;    //FK
    private String imageId;     //FK
    private String inventoryCategory; //FK
    private Integer quantity;
    private Double price;
}
