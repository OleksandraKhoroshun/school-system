package com.uniprojects.schoolsystem.UI;

import com.uniprojects.schoolsystem.models.LessonSchedule;
import com.uniprojects.schoolsystem.models.LessonYear;
import com.uniprojects.schoolsystem.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AssignmentsFrame extends JFrame {
    public AssignmentsFrame(User user, LessonYear lessonYear) {
        super();

        this.user = user;
        this.lessonYear = lessonYear;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(ScreenWidth, ScreenHeight);
        setTitle(lessonYear.getLesson().getLesson_name());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        GridBagConstraints constraints = new GridBagConstraints();

        assignmentsLabel.setFont(TitleFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.insets = new Insets(20, 20, 0, 0);

        mainPanel.add(assignmentsLabel, constraints);

        taskLabel.setFont(TitleFont);
        constraints.gridx = 1;
        constraints.weightx = 0.8;

        mainPanel.add(taskLabel, constraints);

        assignments = makeAssignments();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.9;

        mainPanel.add(assignments, constraints);

        taskArea.setEditable(false);
        taskArea.setFont(BaseFont);

        constraints.gridx = 1;
        constraints.weightx = 0.8;
        constraints.fill = GridBagConstraints.BOTH;

        mainPanel.add(taskArea, constraints);

        assignments.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                taskArea.setText(assignments.getSelectedValue().getTask());
            }
        });

        add(mainPanel);
    }

    private JList<LessonSchedule> makeAssignments() {
        JList<LessonSchedule> assignmentList = new JList<>(lessonYear.getLessonSchedules().toArray(new LessonSchedule[0]));
        assignmentList.setFont(BaseFont);

        return assignmentList;
    }

    protected JPanel mainPanel = new JPanel(new GridBagLayout());
    protected JLabel assignmentsLabel = new JLabel("Assignments:");
    protected JLabel taskLabel = new JLabel("Task:");
    protected JList<LessonSchedule> assignments;
    protected JTextArea taskArea = new JTextArea();

    private final User user;
    private final LessonYear lessonYear;

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 30);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 20);

    private static final int ScreenWidth = 1280;
    private static final int ScreenHeight = 720;
}
