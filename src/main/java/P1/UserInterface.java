package P1;

import command.GitHubCommand;
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
    private JPanel newContactRootPanel;
    private JPanel southButtonsPanel;

    private JTextField gmailAccountTextField;
    private JTextField insertCoinTextField;

    private JRadioButton radioButtonSelectAll;
    private JButton saveButton;

    private JCheckBox BTCCheckBox;
    private JCheckBox ETHCheckBox;
    private JCheckBox XRPCheckBox;
    private JCheckBox EOSCheckBox;
    private JCheckBox BCHCheckBox;
    private JCheckBox LTCCheckBox;
    private JCheckBox BNBCheckBox;
    private JCheckBox XMRCheckBox;
    private JCheckBox XLMCheckBox;
    private JCheckBox TRXCheckBox;
    private JCheckBox NEOCheckBox;
    private JCheckBox XTZCheckBox;
    private JCheckBox ETCCheckBox;
    private JCheckBox MKRCheckBox;
    private JCheckBox BSVCheckBox1;
    private JCheckBox ADACheckBox1;

    String coins = "";

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

        radioButtonSelectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonSelectAll.isSelected()){
                    BTCCheckBox.setSelected(true);
                    ETHCheckBox.setSelected(true);
                    XRPCheckBox.setSelected(true);
                    EOSCheckBox.setSelected(true);
                    BCHCheckBox.setSelected(true);
                    LTCCheckBox.setSelected(true);
                    BNBCheckBox.setSelected(true);
                    XMRCheckBox.setSelected(true);
                    XLMCheckBox.setSelected(true);
                    TRXCheckBox.setSelected(true);
                    NEOCheckBox.setSelected(true);
                    XTZCheckBox.setSelected(true);
                    ETCCheckBox.setSelected(true);
                    MKRCheckBox.setSelected(true);
                    BSVCheckBox1.setSelected(true);
                    ADACheckBox1.setSelected(true);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(BTCCheckBox.isSelected()){
                    coins = coins + "BTC,";
                }
                if(ETHCheckBox.isSelected()){
                    coins = coins + "ETH,";
                }
                if(XRPCheckBox.isSelected()){
                    coins = coins + "XRP,";
                }
                if(EOSCheckBox.isSelected()){
                    coins = coins + "EOS,";
                }
                if(BCHCheckBox.isSelected()){
                    coins = coins + "BCH,";
                }
                if(ADACheckBox1.isSelected()){
                    coins = coins + "ADA,";
                }
                if(LTCCheckBox.isSelected()){
                    coins = coins + "LTC,";
                }
                if(XMRCheckBox.isSelected()){
                    coins = coins + "XMR,";
                }
                if(BNBCheckBox.isSelected()){
                    coins = coins + "BNB,";
                }
                if(TRXCheckBox.isSelected()){
                    coins = coins + "TRX,";
                }
                if(XLMCheckBox.isSelected()){
                    coins = coins + "XLM,";
                }
                if(NEOCheckBox.isSelected()){
                    coins = coins + "NEO,";
                }
                if(XTZCheckBox.isSelected()){
                    coins = coins + "XTZ,";
                }
                if(ETCCheckBox.isSelected()){
                    coins = coins + "ETC,";
                }
                if(MKRCheckBox.isSelected()){
                    coins = coins + "MKR,";
                }
                if(BSVCheckBox1.isSelected()){
                    coins = coins + "BSV,";
                }

                coins = coins + insertCoinTextField.getText();
                System.out.println("coins: " + coins);

                JOptionPane.showMessageDialog(null, "Thanks! You will receive an email validation soon", "Popup validation", JOptionPane.PLAIN_MESSAGE);

                frames = getFrames();
                frames[0].dispose();

                gitHubCommand = new GitHubCommand();
                gitHubCommand.login();
                gitHubCommand.deleteFile();
                gitHubCommand.createNewFile(coins, gmailAccountTextField.getText());
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
