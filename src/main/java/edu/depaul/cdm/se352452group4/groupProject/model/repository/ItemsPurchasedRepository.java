package edu.depaul.cdm.se352452group4.groupProject.model.repository;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.ItemPurchased;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemsPurchasedRepository extends CrudRepository<ItemPurchased, Long> {
}
