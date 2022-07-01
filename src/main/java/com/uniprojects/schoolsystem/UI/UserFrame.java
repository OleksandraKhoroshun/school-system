package com.uniprojects.schoolsystem.UI;

import com.uniprojects.schoolsystem.models.User;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    public UserFrame(User user) {
        super();

        this.user = user;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ScreenWidth, ScreenHeight);
        setTitle("School System");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        GridBagConstraints constraints = new GridBagConstraints();

        mainLabel.setFont(TitleFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        //constraints.insets = new Insets(20, 20, 0, 0);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        mainPanel.add(mainLabel, constraints);

        nameLabel.setFont(TitleFont);
        constraints.gridx = 1;
        //constraints.insets = new Insets(20, 0 ,0, 20);
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;

        mainPanel.add(nameLabel, constraints);

        name2Label.setFont(TitleFont);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        mainLabel.add(name2Label, constraints);

        add(mainPanel);
    }

    protected JPanel mainPanel = new JPanel(new GridBagLayout());
    protected JLabel mainLabel = new JLabel("School System");
    protected JLabel nameLabel = new JLabel("Name Surname (maybe photo)");
    protected JLabel name2Label = new JLabel("Name Surname (maybe photo)");

    private User user;

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 30);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 20);

    private static final int ScreenWidth = 1920;
    private static final int ScreenHeight = 1080;
}