package com.uniprojects.schoolsystem.UI;

import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ScreenWidth, ScreenHeight);
        setTitle("SchoolSystem Authorize");

    }

    protected JTextField loginField = new JTextField();
    protected JPasswordField passwordField = new JPasswordField();

    private static final int ScreenWidth = 1920;
    private static final int ScreenHeight = 1080;
}
