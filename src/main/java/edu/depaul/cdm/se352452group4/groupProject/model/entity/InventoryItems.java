package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Inventory_Items")
public class InventoryItems implements Serializable {
    private final long serialVersionUID = 2L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // PK

    private String size;    // FK

    @Column(name = "item_type")
    private String itemType;    //FK

    @Column(name = "image_id")
    private String imageId;     //FK

    @Column(name = "inventory_category")
    private String inventoryCategory; //FK

    private Integer quantity;

    private Double price;

    public void setPrice(double p) {
        this.price = p;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }
}
