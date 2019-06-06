package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class CustomerShipments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipping_Id;        // PK. Unique Serial
    private Long transaction_Id;    // PK, FK.
    private Long itemId;
    private Integer quantity;


}
