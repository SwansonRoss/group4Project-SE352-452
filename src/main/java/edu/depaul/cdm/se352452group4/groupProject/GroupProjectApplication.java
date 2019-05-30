package edu.depaul.cdm.se352452group4.groupProject;

import edu.depaul.cdm.se352452group4.groupProject.model.entity.Account;
import edu.depaul.cdm.se352452group4.groupProject.model.repository.iAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GroupProjectApplication {
//	private static final Logger log = LoggerFactory.getLogger(GroupProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);
                System.out.println("Group 4 project running on port 8080");
                
	}

//	@Bean
//	public CommandLineRunner demo(iAccount iAccount){
//		return (args) -> {
//			iAccount.save(new Account("Tuan", "Nguyen", "tng.one@gmail.com", "test0"));
//			iAccount.save(new Account("Simon", "Nguyen", "sng.one@gmail.com", "test1"));
//			iAccount.save(new Account("Johnny", "Nguyen", "jng.one@gmail.com", "test2"));
//			iAccount.save(new Account("Lisa", "Nguyen", "lng.one@gmail.com", "test3"));
//			iAccount.save(new Account("Oanh", "Nguyen", "ong.one@gmail.com", "test4"));
//
//			log.info("Accounts found with findAll():");
//			log.info("------------------------------");
//			for (Account a : iAccount.findAll()) {
//				log.info(a.toString());
//			}
//			log.info("");
//
////			// fetch an individual customer by ID
////			repository.findById(1L)
////					.ifPresent(customer -> {
////						log.info("Customer found with findById(1L):");
////						log.info("--------------------------------");
////						log.info(customer.toString());
////						log.info("");
////					});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			iAccount.findByLastName("Nguyen").forEach(Nguyen -> {
//				log.info(Nguyen.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// 	log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}
}
