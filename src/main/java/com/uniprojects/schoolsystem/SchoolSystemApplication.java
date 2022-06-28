package com.uniprojects.schoolsystem;

import com.uniprojects.schoolsystem.UI.LoginFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class SchoolSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);

		System.setProperty("java.awt.headless", "false");
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
	}

}
