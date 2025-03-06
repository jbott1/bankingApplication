package com.thor.demo.menu;

import com.thor.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class LightningApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LightningApplication.class, args);
		Scanner sc = new Scanner(System.in);


		User user = Driver.startGame();
		Driver.playGame(user);


		}


	}



