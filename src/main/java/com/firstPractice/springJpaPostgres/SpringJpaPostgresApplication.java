package com.firstPractice.springJpaPostgres;

import com.firstPractice.springJpaPostgres.entity.Address;
import com.firstPractice.springJpaPostgres.entity.Users;
import com.firstPractice.springJpaPostgres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringJpaPostgresApplication {

    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPostgresApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() {
        Address addressBogatkova = new Address();
        addressBogatkova.setCity("Novosibirsk");
        addressBogatkova.setHomeNumber("245");
        addressBogatkova.setStreet("Borisa Bogatkova");

        Address addressRed = new Address();
        addressRed.setCity("Novosibirsk");
        addressRed.setHomeNumber("15");
        addressRed.setStreet("Red Avenue");

        Users userJon = new Users();
        userJon.setName("Jon Dorian");
        userJon.setEmail("jon_email@gmail.com");
        userJon.setAddress(addressBogatkova);

        Users userSmith = new Users();
        userSmith.setName("Smith");
        userSmith.setEmail("smith_email@gmail.com");
        userSmith.setAddress(addressRed);

        userService.createUsers(userJon);
        userService.createUsers(userSmith);

        userService.findAll().forEach(System.out::println);
        userService.findAllByName("Smith").forEach(System.out::println);
        userService.findWhereEmailIsGmail().forEach(System.out::println);
        userService.findWhereNameStartsFromSmith().forEach(System.out::println);

    }

}
