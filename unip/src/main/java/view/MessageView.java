//package view;
//
//import model.Message;
//import model.MessageManager;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class MessageView extends JFrame {
//    private JTextArea messageArea;
//    private JTextField messageField;
//    private JButton sendButton;
//    private MessageManager messageManager;
//
//    public MessageView(MessageManager messageManager) {
//        this.messageManager = messageManager;
//
//        setTitle("Public Chat");
//        setSize(400, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        messageArea = new JTextArea();
//        messageArea.setEditable(false);
//        add(new JScrollPane(messageArea), BorderLayout.CENTER);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        messageField = new JTextField();
//        sendButton = new JButton("Send");
//        panel.add(messageField, BorderLayout.CENTER);
//        panel.add(sendButton, BorderLayout.EAST);
//        add(panel, BorderLayout.SOUTH);
//
//        sendButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sendMessage();
//            }
//        });
//
//        loadMessages();
//        setVisible(true);
//    }
//
//    private void sendMessage() {
//        String content = messageField.getText().trim();
//        if (!content.isEmpty()) {
//            Message message = new Message("Student", content); // You can customize the sender's name
//            messageManager.addMessage(message);
//            messageField.setText("");
//            loadMessages();
//        }
//    }
//
//    private void loadMessages() {
//        List<Message> messages = messageManager.getMessages();
//        messageArea.setText("");
//        for (Message message : messages) {
//            messageArea.append(message.toString() + "\n");
//        }
//    }
//
//    public static void main(String[] args) {
//        MessageManager messageManager = new MessageManager();
//        new MessageView(messageManager);
//    }
//}