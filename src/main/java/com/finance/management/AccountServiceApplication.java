package com.finance.management;

import com.finance.management.entities.Account;
import com.finance.management.entities.AccountType;
import com.finance.management.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeData(AccountRepository accountRepository){
		return args -> {
			accountRepository.save(new Account(null, Math.random()*9000, new Date(), AccountType.SAVINGS));
			accountRepository.save(new Account(null, Math.random()*9000, new Date(), AccountType.CHECKING));
			accountRepository.save(new Account(null, Math.random()*9000, new Date(), AccountType.SAVINGS));

			accountRepository.findAll().forEach(account -> {
				System.out.println(account.toString());
			});
		};
	}

}
