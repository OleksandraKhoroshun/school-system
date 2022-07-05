package com.uniprojects.schoolsystem.UI;

import com.uniprojects.schoolsystem.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        mainPanel.add(mainLabel, constraints);

        nameLabel.setFont(TitleFont);
        nameLabel.setText(user.getFirst_name() + " " + user.getLast_name());
        constraints.gridx = 1;
        constraints.insets = new Insets(20, 0 ,0, 20);
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;

        mainPanel.add(nameLabel, constraints);

        userPanel = makePanel();
        userPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 0.9;
        mainPanel.add(userPanel, constraints);

        add(mainPanel);
    }

    private JPanel makePanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JLabel courseListLabel = new JLabel("Your courses:");
        courseListLabel.setFont(BaseFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.insets = new Insets(20, 20, 0, 0);

        panel.add(courseListLabel, constraints);

        JLabel scheduleLabel = new JLabel("Schedule:");
        scheduleLabel.setFont(BaseFont);
        constraints.gridx = 1;
        constraints.weightx = 0.8;

        panel.add(scheduleLabel, constraints);

        JList<Lesson> list = new JList<>(user.getLessons().toArray(new Lesson[0]));
        list.setFont(BaseFont);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.9;

        panel.add(list, constraints);

        JTable scheduleTable = makeSchedule();
        constraints.gridx = 1;
        constraints.weightx = 0.8;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        panel.add(new JScrollPane(scheduleTable), constraints);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (user.getUsertype() == UserType.Student) {
                    for (LessonYear ly : list.getSelectedValue().getLessonsYears()) {
                        if (ly.getLesson() == list.getSelectedValue()) { // yes, I compare pointers, I use c++
                            new AssignmentsFrame((Student) user, ly).setVisible(true);
                            return;
                        }
                    }
                }
            }
        });

        return panel;
    }

    private JTable makeSchedule() {
        String[] headers = { "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        String[][] data = new String[5][8];
        data[0][0] = "8:30 - 9:15";
        data[1][0] = "9:25 - 10:10";
        data[2][0] = "10:20 - 11:05";
        data[3][0] = "11:25 - 12:10";
        data[4][0] = "12:30 - 13:15";
        
        List<LessonYear> lessonYears;
        switch (user.getUsertype()) {
            case Student -> {
                Student student = (Student) user;
                lessonYears = student.getYear().getLessonsYears();
            }
            case Teacher -> {
                Teacher teacher = (Teacher) user;
                lessonYears = teacher.getLessonsYears();
            }
            default -> throw new IllegalStateException("Unexpected value: " + user.getUsertype());
        }

        for (LessonYear ly : lessonYears) {
            for (LessonSchedule ls : ly.getLessonSchedules()) {
                data[Math.toIntExact(ls.getTimeSlot().getTime_slot_id()) - 1][Math.toIntExact(ls.getDay().getDay_id())] = ly.getLesson().getLesson_name();
            }
        }

        JTable schedule = new JTable(data, headers);
        schedule.setFont(BaseFont);
        schedule.setRowHeight(30);

        return schedule;
    }

    protected JPanel mainPanel = new JPanel(new GridBagLayout());
    protected JPanel userPanel;
    protected JLabel mainLabel = new JLabel("School System");
    protected JLabel nameLabel = new JLabel("Name Surname (maybe photo)");

    private final User user;

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 30);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 20);

    private static final int ScreenWidth = 1920;
    private static final int ScreenHeight = 1080;
}