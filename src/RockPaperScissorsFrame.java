import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPanel;
    JPanel iconPnl; //top
    JPanel displayPnl; //center
    JPanel controlPnl; //Bottom
    JPanel comboPnl;
    JTextArea displayTA;
    JScrollPane scroller;
    JLabel titleLbl;
    ImageIcon icon;
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;
    JPanel statsPanel;
    JLabel pWin; //Player wins
    JLabel cWin; //computer wins
    JLabel tie; //Tie game
    int winComputerCnt = 0; //Track number of wins Computer has against player in the status panel
    int winPlayerCnt = 0; //Track number of wins Player has against player in the status panel
    JLabel statsLabel;
    JTextArea statsTA;
    public RockPaperScissorsFrame()
    {   //Center Game on screen
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        JPanel mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH); //this holds the RPS Game Image

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.WEST); //This displays the game results as it is played
        TitledBorder displayBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game Play Results");
        displayBorder.setTitleJustification(TitledBorder.CENTER);
        displayPnl.setBorder(displayBorder);

        //Stats panel in East
        createStatsPanel();
        mainPnl.add(statsPanel, BorderLayout.EAST); //This shows the stats of the game. How many wins per player TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game Stats");
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game Stats");
        border.setTitleJustification(TitledBorder.CENTER);
        statsPanel.setBorder(border);
        

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH); //This contains all the buttons used to play the game

        add(mainPnl);
        setSize(800,800);
        setTitle("Rock-Paper-Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createStatsPanel() //This shows the stats of the game on right side of the screen. How many wins per player
    {
        statsPanel = new JPanel();
        statsTA = new JTextArea(20, 85);
        statsTA.setEditable(false);
        scroller = new JScrollPane(statsTA);
        statsPanel.add(scroller);
        setVisible(true);
    }
    private void createComboPanel()
    {
        comboPnl = new JPanel();
        comboPnl.setBorder(new TitledBorder(new EtchedBorder(), "Home"));

    }
    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/RPS.jpg");
        iconPnl.setSize(20,20);
        titleLbl = new JLabel("Rock Paper Scissors", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconPnl.add(titleLbl);
    }
    private void createDisplayPanel() //WEST/ Left panel with the game results
    {
        displayPnl = new JPanel();
//        displayPnl.setBorder(new TitledBorder("Game Stats"));//
//        displayPnl.setLayout(new GridLayout(1,3));
        displayTA = new JTextArea(20,85);

        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
        //displayPnl.add(statsLabel);
    }
    private void createControlPanel() //SOUTH panel with buttons
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Game Buttons")); //Button border
        controlPnl.setLayout(new GridLayout(1, 4));

        icon = new ImageIcon("src/Rock.jpg");
        rockBtn = new JButton(icon);
        rockBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You chose ROCK!\n");
        });

        icon = new ImageIcon("src/Paper.jpg");
        paperBtn = new JButton(icon);
        paperBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You chose PAPER!\n");
        });

        icon = new ImageIcon("src/Scissors.jpg");
        scissorsBtn = new JButton(icon);
        scissorsBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You chose SCISSORS!\n");
        });

        icon = new ImageIcon("src/QuitGame.png");
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Calibri", Font.PLAIN, 35));

        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);

//        rpsGroup.add(rockBtn);
//        rpsGroup.add(paperBtn);
//        rpsGroup.add(scissorsBtn);
    }
}
