package edu.depaul.cdm.se352452group4.groupProject.model.entity;

import com.fasterxml.classmate.GenericType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorID;
    
    private String country;
    
    private String city;
    
    private String state;
    
}
