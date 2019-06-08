package edu.depaul.cdm.se352452group4.groupProject.model.repository;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// Manager Repo
@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long>{
   Manager findByEmail(String email);
}
