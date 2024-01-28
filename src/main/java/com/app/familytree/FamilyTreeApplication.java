package com.app.familytree;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.familytree.cli.FamilyTreeCLI;

import picocli.CommandLine;

@SpringBootApplication
public class FamilyTreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyTreeApplication.class, args);
	}
	
    @Bean
    CommandLineRunner commandLineRunner(FamilyTreeCLI userCLI) {
        return args -> new CommandLine(userCLI).execute(args);
    }
}
