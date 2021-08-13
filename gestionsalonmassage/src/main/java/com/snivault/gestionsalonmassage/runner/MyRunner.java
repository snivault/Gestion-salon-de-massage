package com.snivault.gestionsalonmassage.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.snivault.gestionsalonmassage.dao.service.ClientService;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ClientService clientService;

	@Override
	public void run(String... args) throws Exception {
		clientService.proposerMassagesAdaptes(1);
	}
}
