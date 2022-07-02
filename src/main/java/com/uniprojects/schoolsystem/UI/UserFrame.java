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
        mainLabel.setText(user.getUsertype().toString());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 0, 0);
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        mainPanel.add(mainLabel, constraints);

        nameLabel.setFont(TitleFont);
        nameLabel.setText(user.getFirst_name() + " " + user.getLast_name());
        constraints.gridx = 1;
        constraints.insets = new Insets(20, 0 ,0, 20);
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;

        mainPanel.add(nameLabel, constraints);

        // make user panel

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        mainPanel.add(userPanel, constraints);

        add(mainPanel);
    }

    protected JPanel mainPanel = new JPanel(new GridBagLayout());
    protected JPanel userPanel = new JPanel(new GridBagLayout());
    protected JLabel mainLabel = new JLabel("School System");
    protected JLabel nameLabel = new JLabel("Name Surname (maybe photo)");

    private final User user;

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 30);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 20);

    private static final int ScreenWidth = 1920;
    private static final int ScreenHeight = 1080;
}