package P1;

import command.GitHubCommends;
import util.CredentialConstants;
import util.UserReadProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Ali extends JFrame {
    private JButton buttonMSG;
    private JPanel newContactRootPanel;
    private JPanel westLabelPanel;
    private JPanel eastTextFieldPanel;
    private JPanel southButtonsPanel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel cryptoCoinLabel;
    private JLabel gmailAccountLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField cryptoCoinTextField;
    private JTextField gmailAccountTextField;
    private JButton saveButton;

    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    private GitHubCommends gitHubCommends;
    private UserReadProperties userReadProperties;
    private Frame[] frames;

    public Ali() {
        super("Contact Panel");
        usernameTextField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }
        });

        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try (FileInputStream objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\user.properties")) {
                    properties.load(objFile);
                    properties.setProperty(CredentialConstants.USER_NAME, usernameTextField.getText());
                    properties.setProperty(CredentialConstants.PASSWORD, passwordTextField.getText());
                    properties.setProperty(CredentialConstants.CRYPTO_COIN, cryptoCoinTextField.getText());
                    properties.setProperty(CredentialConstants.GMAIL_ACCOUNT, gmailAccountTextField.getText());
                    FileOutputStream output = new FileOutputStream(currentDirectoryPath + "\\src\\main\\resources\\user.properties");
                    properties.store(output, "TEST");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


               // JOptionPane.showMessageDialog(null, "Thanks", "Contact #1", JOptionPane.PLAIN_MESSAGE);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frames = getFrames();
                frames[0].dispose();
                try {
                    gitHubCommends.login();
                    gitHubCommends.writeFile();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ali");
        frame.setContentPane(new Ali().newContactRootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
