package com.uniprojects.schoolsystem.UI;

import com.uniprojects.schoolsystem.models.Student;
import com.uniprojects.schoolsystem.models.Teacher;
import com.uniprojects.schoolsystem.models.User;
import com.uniprojects.schoolsystem.models.UserType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ScreenWidth, ScreenHeight);
        setTitle("SchoolSystem Authorize");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        GridBagConstraints constraints = new GridBagConstraints();

        titleLabel.setFont(TitleFont);
        constraints.gridx = 0;
        constraints.gridy = 0;

        loginPanel.add(titleLabel, constraints);

        loginLabel.setFont(BaseFont);
        constraints.insets = new Insets(90, 0, 0, 0);
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        loginPanel.add(loginLabel, constraints);

        loginField.setFont(BaseFont);
        constraints.insets = new Insets(20, 0, 0, 0);
        constraints.gridy = 2;

        loginPanel.add(loginField, constraints);

        passwordLabel.setFont(BaseFont);
        constraints.insets = new Insets(50, 0, 0, 0);
        constraints.gridy = 3;

        loginPanel.add(passwordLabel, constraints);

        passwordField.setFont(BaseFont);
        constraints.insets = new Insets(20, 0, 0, 0);
        constraints.gridy = 4;

        loginPanel.add(passwordField, constraints);

        loginButton.setFont(BaseFont);
        constraints.insets = new Insets(40, 0, 0, 0);
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.NONE;

        loginPanel.add(loginButton, constraints);

        exitButton.setFont(BaseFont);
        constraints.insets = new Insets(20, 0, 15, 15);
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;

        loginPanel.add(exitButton, constraints);

        loginButton.addActionListener(e -> {
            String enteredLogin = loginField.getText();
            String enteredPassword = String.valueOf(passwordField.getPassword()); // TODO normal password check

            User user = null;
            String GET_URL;
            RestTemplate restTemplate = new RestTemplate();

            if (enteredLogin == null || enteredLogin.equals("") || enteredPassword.equals("")) {
                new AnnounceDialog(this, "Login or password is empty").setVisible(true);
                return;
            }

            UserType type;
            try {
                type = User.getUserType(enteredLogin); // throws exception on "ash" here
            } catch (HttpServerErrorException ex) {
                new AnnounceDialog(this, "Login or password is incorrect").setVisible(true);
                return;
            }

            if (type == null) {
                new AnnounceDialog(this, "Login or password is incorrect").setVisible(true);
                return;
            }

            switch (type) {
                case Student -> {
                    GET_URL = "http://localhost:8080/api/v1/students/login/" + enteredLogin + "/" + enteredPassword;
                    user = restTemplate.getForObject(GET_URL, Student.class);
                }
                case Teacher -> {
                    GET_URL = "http://localhost:8080/api/v1/teachers/login/" + enteredLogin + "/" + enteredPassword;
                    user = restTemplate.getForObject(GET_URL, Teacher.class);
                }
            }

            if (user == null) {
                new AnnounceDialog(this, "Login or password is incorrect").setVisible(true);
                return;
            }

            UserFrame newUserFrame = new UserFrame(user);
            dispose();
            newUserFrame.setVisible(true);
        });

        exitButton.addActionListener(e -> System.exit(0));

        add(loginPanel);
    }

    protected JPanel loginPanel = new JPanel(new GridBagLayout());
    protected JLabel titleLabel = new JLabel("Welcome to SchoolSystem");
    protected JLabel loginLabel = new JLabel("Enter login:");
    protected JTextField loginField = new JTextField();
    protected JLabel passwordLabel = new JLabel("Enter password:");
    protected JPasswordField passwordField = new JPasswordField();
    protected JButton loginButton = new JButton("Login");
    protected JButton exitButton = new JButton("Exit");

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 70);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 30);

    private static final int ScreenWidth = 1280;
    private static final int ScreenHeight = 720;
}
