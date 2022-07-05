package com.uniprojects.schoolsystem.UI;

import com.uniprojects.schoolsystem.models.LessonSchedule;
import com.uniprojects.schoolsystem.models.LessonYear;
import com.uniprojects.schoolsystem.models.Student;

import javax.swing.*;
import java.awt.*;

public class AssignmentsFrame extends JFrame {
    public AssignmentsFrame(Student student, LessonYear lessonYear) {
        super();

        this.student = student;
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
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.insets = new Insets(20, 20, 0, 0);

        mainPanel.add(assignmentsLabel, constraints);

        constraints.gridy = 1;
        constraints.weighty = 0.9;

        assignments = makeAssignments();

        mainPanel.add(assignments, constraints);

        add(mainPanel);
    }

    private JList<LessonSchedule> makeAssignments() {
        JList<LessonSchedule> assignmentList = new JList<>(lessonYear.getLessonSchedules().toArray(new LessonSchedule[0]));
        assignmentList.setFont(BaseFont);

        return assignmentList;
    }

    protected JPanel mainPanel = new JPanel(new GridBagLayout());
    protected JLabel assignmentsLabel = new JLabel("Assignments:");
    protected JList<LessonSchedule> assignments;

    private final Student student;
    private final LessonYear lessonYear;

    private static final Font TitleFont = new Font("OCR A Extended", Font.ITALIC, 30);
    private static final Font BaseFont = new Font("OCR A Extended", Font.PLAIN, 20);

    private static final int ScreenWidth = 1280;
    private static final int ScreenHeight = 720;
}
