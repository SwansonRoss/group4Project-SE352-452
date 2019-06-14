package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Inventory_Items")
public class InventoryItems implements Serializable {
    //private final long serialVersionUID = 2L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // PK

    private String size;    // FK

    @Column(name = "itemtype")
    private String itemType;    //FK

    @Column(name = "image_id")
    private String imageId;     //FK

    @Column(name = "inventorycategory")
    private String inventoryCategory; //FK

    private Integer quantity;

    private Double price;
    @Column(name = "itemname")
    private String itemName;
}
