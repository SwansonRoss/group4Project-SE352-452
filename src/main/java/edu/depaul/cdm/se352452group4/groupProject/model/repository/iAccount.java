package edu.depaul.cdm.se352452group4.groupProject.model.repository;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface iAccount extends CrudRepository <Account, Integer> {
}
