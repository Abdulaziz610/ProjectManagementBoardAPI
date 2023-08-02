package com.BoardAPI.ProjectManagementBoardAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ProjectManagementBoardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementBoardApiApplication.class, args);
	}
}
