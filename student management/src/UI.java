import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private JTextField nameField, emailField, courseField;
    private StudentDAO studentDAO = new StudentDAO();

    public UI() {
        frame = new JFrame("Student Management System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 50, 165, 25);
        panel.add(emailField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(10, 80, 80, 25);
        panel.add(courseLabel);

        courseField = new JTextField(20);
        courseField.setBounds(100, 80, 165, 25);
        panel.add(courseField);

        JButton addButton = new JButton("Add Student");
        addButton.setBounds(10, 110, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String course = courseField.getText();
                studentDAO.addStudent(new Student(0, name, email, course));
                JOptionPane.showMessageDialog(null, "Student Added!");
            }
        });
    }

    public static void main(String[] args) {
        new UI();
    }
}