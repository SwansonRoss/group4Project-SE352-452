package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class InventoryItems {



    @Column(unique = true, name = "ItemsID")
    private int itemID;

    @Column(name = "Size")
    private String size;

    @Column(name = "Item Type")
    private String itemType;

    @Column(name = "ImageID")
    private String imageID;

    @Column(name = "InventoryCategory")
    private String inventoryCategory;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private float price;
}
