//package view;
//
//
//import model.EnrollmentManager;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//public class MainView extends JFrame {
//    private JButton enrollButton;
//    private EnrollmentManager enrollmentManager;
////
//    public MainView(EnrollmentManager enrollmentManager) {
//        this.enrollmentManager = enrollmentManager;
//        enrollButton = new JButton("Enroll in Course");
//
//        enrollButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                EnrollmentView enrollmentView = new EnrollmentView(enrollmentManager);
//                enrollmentView.displayMenu();
//            }
//        });
//
//        this.add(enrollButton);
//        this.setSize(300, 200);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        EnrollmentManager enrollmentManager = new EnrollmentManager();
//        new MainView(enrollmentManager);
//    }
//}
