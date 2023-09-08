import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
public class Game{
    //Game Base
    JFrame window;
    Container con;
    Color mainColor = new Color(0,78,143);//128,222,255
    Font font = new Font("Avenir", Font.PLAIN, 60);

    //title screen
    JPanel titleImagePanel1, titleTextPanel, titleImagePanel2, startButtonPanel, exitButtonPanel,howToPlayPanel;
    JLabel titleImageLabel1, titleTextLabel, titleImageLabel2;
    JButton startButton, exitButton, howToPlayButton;

    //how to play screen

    //Players Screen

    //Game Screen


    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        createWindow();
        addComponentsToPane();
        window.setVisible(true);
    }
    private void addComponentsToPane() {
        titleScreen();
    }
    private void titleScreen(){
        titleImagePanel2 = new JPanel();
        titleImagePanel2.setBounds(50, 20, 100, 100);
        titleImagePanel2.setBackground(mainColor);
        titleImageLabel2 = new JLabel();
        ImageIcon icon1 = resizeImage("res/logoV2.png", 100, 100);
        titleImageLabel2.setIcon(icon1);
        titleImagePanel2.add(titleImageLabel2);
        con.add(titleImagePanel2);

        titleTextPanel = new JPanel();
        titleTextPanel.setBounds(150, 30, 700, 150);
        titleTextPanel.setBackground(mainColor);
        titleTextLabel= new JLabel("The Alternative Alphabet");
        titleTextLabel.setFont(font);
        titleTextLabel.setForeground(new Color(40,171,255));//new Color(103,46,105)
        titleTextPanel.add(titleTextLabel);
        con.add(titleTextPanel);

        titleImagePanel1 = new JPanel();
        titleImagePanel1.setBounds(50, 150, 800, 300);
        titleImagePanel1.setBackground(mainColor);
        titleImageLabel1 = new JLabel();
        ImageIcon icon = resizeImage("res/head.png", 800, 285);
        titleImageLabel1.setIcon(icon);
        titleImagePanel1.add(titleImageLabel1);
        con.add(titleImagePanel1);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(50, 450, 800, 60);
        startButtonPanel.setBackground(mainColor);
        startButton = new JButton("Start");
        startButton.setFont(font.deriveFont(35f));
        startButton.setForeground(mainColor);
        startButton.setBackground(Color.white);
        startButton.addActionListener((ActionEvent e) -> {
            System.out.println("Start");
        });
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        howToPlayPanel = new JPanel();
        howToPlayPanel.setBounds(50, 520, 800, 60);
        howToPlayPanel.setBackground(mainColor);
        howToPlayButton = new JButton("How to Play");
        howToPlayButton.setFont(font.deriveFont(35f));
        howToPlayButton.setForeground(mainColor);
        howToPlayButton.setBackground(Color.white);
        howToPlayButton.addActionListener((ActionEvent e) -> {
            System.out.println("How to Play");
        });
        howToPlayPanel.add(howToPlayButton);
        con.add(howToPlayPanel);

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(50, 590, 800, 60);
        exitButtonPanel.setBackground(mainColor);
        exitButton = new JButton("Exit");
        exitButton.setFont(font.deriveFont(35f));
        exitButton.setForeground(mainColor);
        exitButton.setBackground(Color.white);
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        exitButtonPanel.add(exitButton);
        con.add(exitButtonPanel);
    }
    private void createWindow(){
        window = new JFrame("Alternative Alphabet");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 800);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(mainColor);
        window.setBackground(mainColor);
        window.setLayout(null);
        window.setResizable(false);
        con = window.getContentPane();
    }
    private void hide(){
        titleImagePanel1.setVisible(false);
        titleTextPanel.setVisible(false);
        titleImagePanel2.setVisible(false);
        startButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        howToPlayPanel.setVisible(false);
    }
    private ImageIcon resizeImage(String imagePath, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}