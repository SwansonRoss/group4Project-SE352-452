package edu.depaul.cdm.se352452group4.groupProject.model.entity;


import com.fasterxml.classmate.GenericType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

//UserID, Date, TransactionID, Amount spent
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseID;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date purchaseDate;
    
    @OneToOne
    private Long transactionID;
    
    private Long purchaseAmount; 
    
    private int itemsPurchased; 
}
