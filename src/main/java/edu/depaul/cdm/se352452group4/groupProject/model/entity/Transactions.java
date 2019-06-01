package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Transactions implements Serializable {

    @Id
    @GeneratedValue
    private Integer transactionId; // PK.
    private Double transactionsTotal; // small money
    private Integer totalItems;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

}
