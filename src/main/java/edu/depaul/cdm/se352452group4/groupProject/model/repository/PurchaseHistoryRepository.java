package edu.depaul.cdm.se352452group4.groupProject.model.repository;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.PurchaseHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseHistoryRepository extends CrudRepository<PurchaseHistory, Integer> {
}
