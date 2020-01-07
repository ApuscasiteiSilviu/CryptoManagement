package P1;

import command.GitHubCommand;
import util.UserCredentialConstants;
import util.UserReadProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Properties;

public class UserInterface extends JFrame {
    private JButton buttonMSG;
    private JPanel newContactRootPanel;
    private JPanel southButtonsPanel;
    private JLabel gmailAccountLabel;
    private JTextField usernameTextField;
    private JTextField cryptoCoinTextField;
    private JTextField gmailAccountTextField;
    private JButton saveButton;
    private JRadioButton radioButtonSelectAll;
    private JCheckBox BTCCheckBox;
    private JCheckBox ETHCheckBox;
    private JCheckBox XRPCheckBox;
    private JCheckBox EOSCheckBox;
    private JCheckBox BCHCheckBox;
    private JCheckBox LTCCheckBox;
    private JCheckBox BNBCheckBox;
    private JCheckBox BSVCheckBox;
    private JCheckBox XMRCheckBox;
    private JCheckBox XLMCheckBox;
    private JCheckBox TRXCheckBox;
    private JCheckBox NEOCheckBox;
    private JCheckBox XTZCheckBox;
    private JCheckBox ETCCheckBox;
    private JCheckBox MKRCheckBox;

    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    private GitHubCommand gitHubCommand;
    private UserReadProperties userReadProperties;
    private Frame[] frames;

    public UserInterface() {
        super("Contact Panel");

        gmailAccountTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        gmailAccountTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try (FileInputStream objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\user.properties")) {
                    properties.load(objFile);
                    properties.setProperty(UserCredentialConstants.CRYPTO_COIN, cryptoCoinTextField.getText());
                    properties.setProperty(UserCredentialConstants.GMAIL_ACCOUNT, gmailAccountTextField.getText());
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
//                try {
//                    gitHubCommand = new GitHubCommand();
//                    gitHubCommand.login();
//                    gitHubCommand.deleteFile();
//                    gitHubCommand.createNewFile(usernameTextField.getText(), passwordTextField.getText(), cryptoCoinTextField.getText(), gmailAccountTextField.getText());
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(new UserInterface().newContactRootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
