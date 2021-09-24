package com.rudyah.protaskinator;

import com.rudyah.protaskinator.domain.AppUser;
import com.rudyah.protaskinator.domain.Role;
import com.rudyah.protaskinator.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ProtaskinatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtaskinatorApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "Rudy A. Hernandez", "rudyah", "loveGod", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Samantha Hernandez", "sammi", "loveRu", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Noah T. Mayoral", "noaht", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Imogen S. Hernandez", "imogen", "loveLove", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Kage", "kage", "loveFam", new ArrayList<>()));

			userService.addRoleToUser("rudyah", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("rudyah", "ROLE_ADMIN");
			userService.addRoleToUser("rudyah", "ROLE_USER");
			userService.addRoleToUser("sammi", "ROLE_ADMIN");
			userService.addRoleToUser("sammi", "ROLE_MANAGER");
			userService.addRoleToUser("sammi", "ROLE_USER");
			userService.addRoleToUser("noaht", "ROLE_USER");
			userService.addRoleToUser("imogen", "ROLE_USER");
			userService.addRoleToUser("kage", "ROLE_USER");
		};
	}

}
