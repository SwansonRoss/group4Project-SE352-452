package edu.depaul.cdm.se352452group4.groupProject.model.repository;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



// Account Repo
@Repository
public interface AccountRepository extends CrudRepository <Account, Integer> {
    Account findByEmail(String email);
}
