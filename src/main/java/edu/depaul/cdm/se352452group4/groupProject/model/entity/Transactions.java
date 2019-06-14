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
    private Integer transaction_Id; // PK.
    private Double transactions_Total; // small money
    private Integer total_Items;

    @Temporal(TemporalType.DATE)
    private Date order_Date;

}
