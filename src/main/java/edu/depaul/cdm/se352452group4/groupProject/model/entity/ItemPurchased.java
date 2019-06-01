package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity
public class ItemPurchased implements Serializable {


    @Id
    @GeneratedValue
    private Long transactionId; //PK, FK
    private Long itemId;    //FK
    private Double pricePurchased;
}
