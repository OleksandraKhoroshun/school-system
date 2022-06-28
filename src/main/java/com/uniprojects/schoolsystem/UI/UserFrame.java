package com.uniprojects.schoolsystem.UI;

import com.uniprojects.schoolsystem.models.Student;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    public UserFrame(Student student) {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ScreenWidth, ScreenHeight);
    }

    protected JPanel mainPanel = new JPanel(new GridBagLayout());

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 70);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 30);

    private static final int ScreenWidth = 1920;
    private static final int ScreenHeight = 1080;
}
