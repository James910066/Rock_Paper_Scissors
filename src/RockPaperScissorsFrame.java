import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
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

    int winComputerCnt = 0; //Track number of wins Computer has against player in the status panel
    int winPlayerCnt = 0; //Track number of wins Player has against player in the status panel
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
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

       add(mainPnl);
        setSize(800,800);
       setTitle("Rock-Paper-Scissors");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
//        JLabel RPSLabel = new JLabel("");
//        JTextField rpsTf = new JTextField(40);
//        rpsTf.setText("Choose weapon: Rock, Paper or Scissors");
//        rpsTf.setEditable(false);
//
//        JButton rockBtn = new JButton("Rock");
//        add(rockBtn);
//
//        JButton paperBtn = new JButton("Paper");
//        add(paperBtn);
//
//        JButton scissorsBtn = new JButton("Scissors");
//        add(scissorsBtn);
//
//        JButton quitBtn = new JButton("Quit");
//
//        mainPnl.add(RPSLabel);
//        mainPnl.add(rpsTf);
//        mainPnl.add(rockBtn);
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
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(20,45);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }
//    private void createRadioPanel()
//    {
//        radioPnl = new JPanel();
//        radioPnl.setLayout(new GridLayout(1, 4));
//        radioPnl.setBorder(new TitledBorder(new EtchedBorder(),"Radio Buttons"));
//
//
//        rockBtn  = new JRadioButton("Rock");
//        paperBtn = new JRadioButton("Paper");
//        scissorsBtn  = new JRadioButton("Scissors");
//
//
//        radioPnl.add(rockBtn);
//        radioPnl.add(paperBtn);
//        radioPnl.add(scissorsBtn);
//
//        rockBtn.setSelected(true);
//
//        ButtonGroup rpsGroup = new ButtonGroup();
//        rpsGroup.add(rockBtn);
//        rpsGroup.add(paperBtn);
//        rpsGroup.add(scissorsBtn);
//
//    }
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        ButtonGroup rpsGroup = new ButtonGroup();
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


        rpsGroup.add(rockBtn);
        rpsGroup.add(paperBtn);
        rpsGroup.add(scissorsBtn);


    }





}