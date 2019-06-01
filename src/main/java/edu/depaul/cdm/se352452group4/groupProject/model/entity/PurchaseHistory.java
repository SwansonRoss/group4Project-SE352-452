package edu.depaul.cdm.se352452group4.groupProject.model.entity;


import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
//UserID, Date, TransactionID, Amount spent
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;
    private Long transactionID;
    private Long itemID;
}
