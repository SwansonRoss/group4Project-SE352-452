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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shippingId;        // PK. Unique Serial
    private Long transactionId ;    // PK, FK.
    private Long itemId;
    private Integer quantity;
    private Integer VenderId;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date accountCreated;
}
