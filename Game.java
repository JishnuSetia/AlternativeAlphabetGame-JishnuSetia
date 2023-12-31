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
    String[] actionCardPath={"res/Alternative.png", "res/DEFINE.png", "res/draw.png", "res/question.png", "res/reflect.png"};
    String[] wordCardPath={"res/A.png","res/B.png","res/C.png","res/D.png","res/E.png","res/F.png","res/G.png","res/H.png","res/I.png","res/J.png","res/K.png","res/L.png","res/M.png","res/N.png","res/O.png","res/P.png","res/Q.png","res/R.png","res/S.png","res/T.png","res/U.png","res/V.png","res/W.png","res/X.png","res/Y.png","res/Z.png"};
    String[] players = {"Player 1", "Player 2", "Player 3", "Player 4", "Player 5","Player 6"};
    int[] points = {0,0,0,0,0,0};
    int playerCount=0;
    int currentPlayer = 1;

    //Borders
    JPanel side1Panel, side2Panel, topPanel, bottomPanel;
    JLabel side1, side2, top, bottom;

    //Title Screen
    JPanel titleImagePanel, whiteLine, startButtonPanel, exitButtonPanel,howToPlayPanel, creditsPanel;
    JLabel titleImageLabel;
    JButton startButton, exitButton, howToPlayButton, creditsButton;

    //Credits Screen
    JPanel creditsTitlePanel, creditsTextPanel, creditsBackButtonPanel;
    JLabel creditsTitle;
    JTextArea creditsText;
    JButton creditsBackButton;

    //How to Play Screen
    JPanel htpTitlePanel, htpTextPanel, htpBackButtonPanel;
    JLabel htpTitle;
    JTextArea htpText;
    JButton htpBackButton;

    //Players Screen
    JPanel playerTitlePanel, player2Panel,player3Panel,player4Panel,player5Panel,player6Panel, playersBackButtonPanel;
    JLabel playerTitle;
    JButton player2, player3, player4, player5, player6, playersBackButton;

    //Game Screen
    JPanel currentPlayerPanel, doneButtonPanel, forfeitPanel, actionCardPanel, wordCardPanel;
    JLabel currentPlayerL, actionCard, wordCard;
    JButton doneButton, forfeitButton;

    //Score Board
    JPanel scoreTitlePanel, scoreBoardPanel, sbContinuePanel, sbEndGamePanel;
    JLabel scoreTitle;
    JTextArea scoreBoard;
    JButton sbContinueButton, sbEndGameButton;

    //End Screen
    JPanel endTitlePanel, newGamePanel, exitPanel;
    JLabel endTitle;
    JButton newGameButton, endExitButton;

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
        //content coordinates range from (140, 170) to (750, 500)
        titleImagePanel = new JPanel();
        titleImagePanel.setBounds(140, 170, 400, 400);
        titleImagePanel.setBackground(mainColor);
        titleImageLabel = new JLabel();
        ImageIcon icon = resizeImage("res/logoWText.png", 400, 400);
        titleImageLabel.setIcon(icon);
        titleImagePanel.add(titleImageLabel);
        con.add(titleImagePanel);

        whiteLine = new JPanel();
        whiteLine.setBounds(540, 170, 1, 400);
        whiteLine.setBackground(Color.white);
        con.add(whiteLine);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(550, 220, 200, 70);
        startButtonPanel.setBackground(mainColor);
        startButton = new JButton("Start");
        startButton.setFont(font.deriveFont(35f));
        startButton.setForeground(mainColor);
        startButton.setBackground(Color.white);
        startButton.addActionListener((ActionEvent e) -> {
            hideTitleScreen();
            playersScreen();
        });
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        howToPlayPanel = new JPanel();
        howToPlayPanel.setBounds(545, 300, 325, 70);
        howToPlayPanel.setBackground(mainColor);
        howToPlayButton = new JButton("How to Play");
        howToPlayButton.setFont(font.deriveFont(35f));
        howToPlayButton.setForeground(mainColor);
        howToPlayButton.setBackground(Color.white);
        howToPlayButton.addActionListener((ActionEvent e) -> {
            hideTitleScreen();
            howToPlayScreen();
        });
        howToPlayPanel.add(howToPlayButton);
        con.add(howToPlayPanel);

        creditsPanel = new JPanel();
        creditsPanel.setBackground(mainColor);
        creditsPanel.setBounds(570, 380, 200, 70);
        creditsButton = new JButton("Credits");
        creditsButton.setFont(font.deriveFont(35f));
        creditsButton.setForeground(mainColor);
        creditsButton.setBackground(Color.white);
        creditsButton.addActionListener((ActionEvent e) -> {
            hideTitleScreen();
            creditsScreen();
        });
        creditsPanel.add(creditsButton);
        con.add(creditsPanel);

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(545, 460, 200, 70);
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
    private void hideTitleScreen(){
        titleImagePanel.setVisible(false);
        whiteLine.setVisible(false);
        startButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
        howToPlayPanel.setVisible(false);
        creditsPanel.setVisible(false);
    }
    private void hideCreditsScreen(){
        creditsTitlePanel.setVisible(false);
        creditsTextPanel.setVisible(false);
        creditsBackButtonPanel.setVisible(false);
    }
    private void creditsScreen(){
        //content coordinates range from (140, 170) to (750, 500)
        creditsTitlePanel = new JPanel();
        creditsTitlePanel.setBounds(140, 170, 700, 100);
        creditsTitlePanel.setBackground(mainColor);
        creditsTitle = new JLabel("Credits");
        creditsTitle.setFont(font);
        creditsTitle.setForeground(Color.white);
        creditsTitlePanel.add(creditsTitle);
        con.add(creditsTitlePanel);

        creditsTextPanel = new JPanel();
        creditsTextPanel.setBounds(140, 290, 700, 200);
        creditsTextPanel.setBackground(mainColor);
        creditsText = new JTextArea("Game Creator - GEMS Education\n\nDeveloper - Jishnu Setia\n\nIdeas - Prasanna Adithya Balagopal and Archit Lakhani");
        creditsText.setBackground(mainColor);
        creditsText.setEditable(false);
        creditsText.setFont(font.deriveFont(28f));
        creditsText.setForeground(Color.white);
        creditsTextPanel.add(creditsText);
        con.add(creditsTextPanel);

        creditsBackButtonPanel = new JPanel();
        creditsBackButtonPanel.setBounds(140,500,700,200);
        creditsBackButtonPanel.setBackground(mainColor);
        creditsBackButton=new JButton("<- Back");
        creditsBackButton.setFont(font.deriveFont(35f));
        creditsBackButton.setForeground(mainColor);
        creditsBackButton.setBackground(Color.white);
        creditsBackButton.addActionListener((ActionEvent e) -> {
            hideCreditsScreen();
            titleScreen();
        });
        creditsBackButtonPanel.add(creditsBackButton);
        con.add(creditsBackButtonPanel);
    }
    private void howToPlayScreen(){
        //content coordinates range from (140, 170) to (750, 500)
        htpTitlePanel = new JPanel();
        htpTitlePanel.setBounds(140, 170, 700, 100);
        htpTitlePanel.setBackground(mainColor);
        htpTitle = new JLabel("How to Play");
        htpTitle.setFont(font);
        htpTitle.setForeground(Color.white);
        htpTitlePanel.add(htpTitle);
        con.add(htpTitlePanel);

        htpTextPanel = new JPanel();
        htpTextPanel.setBounds(140,290,700,200);
        htpTextPanel.setBackground(mainColor);
        String text = "In this game, players get 1 random action card and 1 \nrandom word card. They must complete the action on the card \nto get points. The player with the most points wins";
        htpText=new JTextArea(text);
        htpText.setBackground(mainColor);
        htpText.setFont(font.deriveFont(25f));
        htpText.setForeground(Color.white);
        htpText.setEditable(false);
        htpTextPanel.add(htpText);
        con.add(htpTextPanel);
        
        htpBackButtonPanel = new JPanel();
        htpBackButtonPanel.setBounds(140,500,700,200);
        htpBackButtonPanel.setBackground(mainColor);
        htpBackButton = new JButton("<- Back");
        htpBackButton.setFont(font.deriveFont(35f));
        htpBackButton.setForeground(mainColor);
        htpBackButton.setBackground(Color.white);
        htpBackButton.addActionListener((ActionEvent e) -> {
            hideHTPScreen();
            titleScreen();
        });
        htpBackButtonPanel.add(htpBackButton);
        con.add(htpBackButtonPanel);
    }
    private void hideHTPScreen(){
        htpTitlePanel.setVisible(false);
        htpTextPanel.setVisible(false);
        htpBackButtonPanel.setVisible(false);;
    }
    private void playersScreen(){
        //content coordinates range from (140, 170) to (750, 500)
        playerTitlePanel = new JPanel();
        playerTitlePanel.setBounds(140, 170, 700, 50);
        playerTitlePanel.setBackground(mainColor);
        playerTitle = new JLabel("Select Number of Players");
        playerTitle.setFont(font.deriveFont(35f));
        playerTitle.setForeground(Color.white);
        playerTitlePanel.add(playerTitle);
        con.add(playerTitlePanel);

        player2Panel = new JPanel();
        player2Panel.setBounds(200,250, 100,100);
        player2Panel.setBackground(mainColor);
        player2 = new JButton("2");
        player2.setBackground(Color.white);
        player2.setForeground(mainColor);
        player2.setFont(font);
        player2.addActionListener((ActionEvent e) -> {
            playerCount=2;
            hidePlayerScreen();
            gameScreen();
        });
        player2Panel.add(player2);
        con.add(player2Panel);

        player3Panel = new JPanel();
        player3Panel.setBounds(430,250, 100,100);
        player3Panel.setBackground(mainColor);
        player3 = new JButton("3");
        player3.setBackground(Color.white);
        player3.setForeground(mainColor);
        player3.setFont(font);
        player3.addActionListener((ActionEvent e) -> {
            playerCount=3;
            hidePlayerScreen();
            gameScreen();
        });
        player3Panel.add(player3);
        con.add(player3Panel);

        player4Panel = new JPanel();
        player4Panel.setBounds(660,250, 100,100);
        player4Panel.setBackground(mainColor);
        player4 = new JButton("4");
        player4.setBackground(Color.white);
        player4.setForeground(mainColor);
        player4.setFont(font);
        player4.addActionListener((ActionEvent e) -> {
            playerCount=4;
            hidePlayerScreen();
            gameScreen();
        });
        player4Panel.add(player4);
        con.add(player4Panel);

        player5Panel = new JPanel();
        player5Panel.setBounds(320,370, 100,100);
        player5Panel.setBackground(mainColor);
        player5 = new JButton("5");
        player5.setBackground(Color.white);
        player5.setFont(font);
        player5.setForeground(mainColor);
        player5.addActionListener((ActionEvent e) -> {
            playerCount=5;
            hidePlayerScreen();
            gameScreen();
        });
        player5Panel.add(player5);
        con.add(player5Panel);

        player6Panel = new JPanel();
        player6Panel.setBounds(550,370, 100,100);
        player6Panel.setBackground(mainColor);
        player6 = new JButton("6");
        player6.setBackground(Color.white);
        player6.setFont(font);
        player6.setForeground(mainColor);
        player6.addActionListener((ActionEvent e) -> {
            playerCount=6;
            hidePlayerScreen();
            gameScreen();
        });
        player6Panel.add(player6);
        con.add(player6Panel);

        playersBackButtonPanel = new JPanel();
        playersBackButtonPanel.setBounds(140,500,700,100);
        playersBackButtonPanel.setBackground(mainColor);
        playersBackButton = new JButton("<- Back");
        playersBackButton.setBackground(Color.white);
        playersBackButton.setFont(font.deriveFont(30f));
        playersBackButton.setForeground(mainColor);
        playersBackButton.addActionListener((ActionEvent e) -> {
            hidePlayerScreen();
            titleScreen();
        });
        playersBackButtonPanel.add(playersBackButton);
        con.add(playersBackButtonPanel);
    }
    private void hidePlayerScreen(){
        playerTitlePanel.setVisible(false);
        player2Panel.setVisible(false);
        player3Panel.setVisible(false);
        player4Panel.setVisible(false);
        player5Panel.setVisible(false);
        player6Panel.setVisible(false);
        playersBackButtonPanel.setVisible(false);
    }
    private void gameScreen(){
        //content coordinates range from (140, 170) to (750, 500)
        currentPlayerPanel = new JPanel();
        currentPlayerPanel.setBounds(140,170,700,50);
        currentPlayerPanel.setBackground(mainColor);
        currentPlayerL = new JLabel("It's "+players[currentPlayer-1]+"'s turn");
        currentPlayerL.setFont(font.deriveFont(35f));
        currentPlayerL.setForeground(Color.white);
        currentPlayerPanel.add(currentPlayerL);
        con.add(currentPlayerPanel);

        actionCardPanel = new JPanel();
        actionCardPanel.setBounds(140,270,193,300);
        actionCardPanel.setBackground(mainColor);//new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256))
        actionCard = new JLabel();
        ImageIcon icon = resizeImage(actionCardPath[(int) (Math.random() * 5)], 193, 310);
        actionCard.setIcon(icon);
        actionCardPanel.add(actionCard);
        con.add(actionCardPanel);

        wordCardPanel = new JPanel();
        wordCardPanel.setBounds(400,270,193,300);
        wordCardPanel.setBackground(mainColor);
        wordCard = new JLabel();
        icon = resizeImage(wordCardPath[(int) (Math.random() * 26)], 193, 310);
        wordCard.setIcon(icon);
        wordCardPanel.add(wordCard);
        con.add(wordCardPanel);

        doneButtonPanel = new JPanel();
        doneButtonPanel.setBounds(700, 300, 150, 100);
        doneButtonPanel.setBackground(mainColor);
        doneButton = new JButton("Done");
        doneButton.setBackground(Color.white);
        doneButton.setForeground(mainColor);
        doneButton.setFont(font.deriveFont(35f));
        doneButton.addActionListener((ActionEvent e) -> {
            points[currentPlayer-1]+=10;
            hideGameScreen();
            if(currentPlayer!=playerCount){
                currentPlayer++;
            }else{
                currentPlayer=1;
            }
            scoreBoard();
        });
        doneButtonPanel.add(doneButton);
        con.add(doneButtonPanel);

        forfeitPanel = new JPanel();
        forfeitPanel.setBounds(700, 400, 150, 100);
        forfeitPanel.setBackground(mainColor);
        forfeitButton = new JButton("Forfeit");
        forfeitButton.setBackground(Color.white);
        forfeitButton.setForeground(mainColor);
        forfeitButton.setFont(font.deriveFont(35f));
        forfeitButton.addActionListener((ActionEvent e) -> {
            hideGameScreen();
            if(currentPlayer!=playerCount){
                currentPlayer++;
            }else{
                currentPlayer=1;
            }
            scoreBoard();
        });
        forfeitPanel.add(forfeitButton);
        con.add(forfeitPanel);
    }
    private void hideGameScreen(){
        currentPlayerPanel.setVisible(false);
        doneButtonPanel.setVisible(false);
        forfeitPanel.setVisible(false);
        actionCardPanel.setVisible(false);
        wordCardPanel.setVisible(false);
    }
    private void scoreBoard(){
        //content coordinates range from (140, 170) to (750, 500)
        scoreTitlePanel = new JPanel();
        scoreTitlePanel.setBounds(140, 170, 700, 50);
        scoreTitlePanel.setBackground(mainColor);
        scoreTitle = new JLabel("Score Board");
        scoreTitle.setForeground(Color.white);
        scoreTitle.setFont(font.deriveFont(35f));
        scoreTitlePanel.add(scoreTitle);
        con.add(scoreTitlePanel);

        scoreBoardPanel = new JPanel();
        scoreBoardPanel.setBounds(140, 250,700,250);
        scoreBoardPanel.setBackground(mainColor);
        String text = "";
        for(int i = 1; i<=playerCount;i++){
            text = text.concat(players[i-1]+" - "+points[i-1]+"\n");
        }
        scoreBoard = new JTextArea(text);
        scoreBoard.setBackground(mainColor);
        scoreBoard.setForeground(Color.white);
        scoreBoard.setFont(font.deriveFont(30f));
        scoreBoard.setEditable(false);
        scoreBoardPanel.add(scoreBoard);
        con.add(scoreBoardPanel);

        sbContinuePanel = new JPanel();
        sbContinuePanel.setBounds(200, 520, 200, 100);
        sbContinuePanel.setBackground(mainColor);
        sbContinueButton = new JButton("Continue");
        sbContinueButton.setBackground(Color.white);
        sbContinueButton.setForeground(mainColor);
        sbContinueButton.setFont(font.deriveFont(30f));
        sbContinueButton.addActionListener((ActionEvent e) -> {
            hideScoreBoard();
            gameScreen();
        });
        sbContinuePanel.add(sbContinueButton);
        con.add(sbContinuePanel);

        sbEndGamePanel = new JPanel();
        sbEndGamePanel.setBounds(600, 520, 150, 100);
        sbEndGamePanel.setBackground(mainColor);
        sbEndGameButton = new JButton("End");
        sbEndGameButton.setBackground(Color.white);
        sbEndGameButton.setForeground(mainColor);
        sbEndGameButton.setFont(font.deriveFont(30f));
        sbEndGameButton.addActionListener((ActionEvent e) -> {
            hideScoreBoard();
            endGame();
        });
        sbEndGamePanel.add(sbEndGameButton);
        con.add(sbEndGamePanel);
    }
    private void hideScoreBoard(){
        scoreTitlePanel.setVisible(false);
        scoreBoardPanel.setVisible(false);
        sbContinuePanel.setVisible(false);
        sbEndGamePanel.setVisible(false);
    }
    private void endGame(){
        //content coordinates range from (140, 170) to (750, 500)
        reset();
        endTitlePanel = new JPanel();
        endTitlePanel.setBounds(140, 170, 700, 100);
        endTitlePanel.setBackground(mainColor);
        endTitle = new JLabel("Game Over");
        endTitle.setFont(font);
        endTitle.setForeground(Color.white);
        endTitlePanel.add(endTitle);
        con.add(endTitlePanel);

        newGamePanel = new JPanel();
        newGamePanel.setBounds(200, 350, 200, 100);
        newGamePanel.setBackground(mainColor);
        newGameButton = new JButton("New Game");
        newGameButton.setBackground(Color.white);
        newGameButton.setForeground(mainColor);
        newGameButton.setFont(font.deriveFont(30f));
        newGameButton.addActionListener((ActionEvent e) -> {
            hideEndScreen();
            titleScreen();
        });
        newGamePanel.add(newGameButton);
        con.add(newGamePanel);

        exitPanel = new JPanel();
        exitPanel.setBounds(650, 350, 200, 100);
        exitPanel.setBackground(mainColor);
        endExitButton = new JButton("Exit");
        endExitButton.setBackground(Color.white);
        endExitButton.setForeground(mainColor);
        endExitButton.setFont(font.deriveFont(30f));
        endExitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        exitPanel.add(endExitButton);
        con.add(exitPanel);
    }
    private void hideEndScreen(){
        endTitlePanel.setVisible(false);
        newGamePanel.setVisible(false); 
        exitPanel.setVisible(false);
    }
    private void createWindow(){
        window = new JFrame("Alternative Alphabet");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(mainColor);
        window.setBackground(mainColor);
        window.setLayout(null);
        window.setResizable(false);
        con = window.getContentPane();

        side1Panel = new JPanel();
        side1Panel.setBounds(-10, 0, 150, 800);
        side1Panel.setBackground(mainColor);
        side1 = new JLabel();
        ImageIcon icon = resizeImage("res/sidedesign.png", 141, 750);
        side1.setIcon(icon);
        side1Panel.add(side1);
        con.add(side1Panel);

        topPanel = new JPanel();
        topPanel.setBounds(141, 0, 700, 170);
        topPanel.setBackground(mainColor);
        top=new JLabel();
        icon = resizeImage("res/horizontalDesign.png", 600, 146);
        top.setIcon(icon);
        topPanel.add(top);
        con.add(topPanel);

        bottomPanel = new JPanel();
        bottomPanel.setBounds(141, 600, 700, 170);
        bottomPanel.setBackground(mainColor);
        bottom=new JLabel();
        icon = resizeImage("res/horizontalDesign.png", 600, 146);
        bottom.setIcon(icon);
        bottomPanel.add(bottom);
        con.add(bottomPanel);

        side2Panel = new JPanel();
        side2Panel.setBounds(850, 0, 150, 800);
        side2Panel.setBackground(mainColor);
        side2 = new JLabel();
        icon = resizeImage("res/sidedesign.png", 141, 750);
        side2.setIcon(icon);
        side2Panel.add(side2);
        con.add(side2Panel);
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
    private void reset(){
        points = null;
        int[] arr = {0,0,0,0,0,0};
        points = arr.clone();
        playerCount=0;
        currentPlayer = 1;
    }
}