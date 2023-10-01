import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame implements ActionListener
{
    private JPanel mainPanel;
    private JPanel iconPnl;
    private JPanel displayPnl;
    private JPanel controlPnl;
    private JTextArea displayTA;
    private JScrollPane scroller;
    private JLabel titleLbl;
    private ImageIcon icon;
    private JButton rockBtn;
    private JButton paperBtn;
    private JButton scissorsBtn;
    private JButton quitBtn;
    private JPanel statsPanel;
    private JLabel pWin;
    private JLabel cWin;
    private JLabel tie;
    private int computerWinCnt = 0;
    private int playerWinCnt = 0;
    private JTextArea statsTA;

    public RockPaperScissorsFrame()
    {
        // Center Game on screen
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create icon panel
        iconPnl = new JPanel();
        icon = new ImageIcon("src/RPS.jpg");
        iconPnl.setSize(20, 20);
        titleLbl = new JLabel("Rock Paper Scissors", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconPnl.add(titleLbl);

        // Add icon panel to main panel
        mainPanel.add(iconPnl, BorderLayout.NORTH);

        // Create display panel
        displayPnl = new JPanel();
        displayTA = new JTextArea(20, 86);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
        TitledBorder displayBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game Play Results");
        displayBorder.setTitleJustification(TitledBorder.CENTER);
        displayPnl.setBorder(displayBorder);

        // Add display panel to main panel
        mainPanel.add(displayPnl, BorderLayout.WEST);

        // Create stats panel
        createStatsPanel();
        mainPanel.add(statsPanel, BorderLayout.EAST);
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game Stats");
        border.setTitleJustification(TitledBorder.CENTER);
        statsPanel.setBorder(border);

        // Create control panel
        createControlPanel();
        mainPanel.add(controlPnl, BorderLayout.SOUTH);

        add(mainPanel);
        setSize(800, 800);
        setTitle("Rock-Paper-Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createStatsPanel()
    {
        statsPanel = new JPanel();
        statsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Game Stats"));
        statsTA = new JTextArea(20, 80);
        statsTA.setEditable(false);
        scroller = new JScrollPane(statsTA);
        statsPanel.add(scroller);

        pWin = new JLabel("Player Wins:");
        cWin = new JLabel("Computer Wins:");
        tie = new JLabel("Tie Games:");

        statsPanel.add(pWin);
        statsPanel.add(cWin);
        statsPanel.add(tie);
        statsPanel.setVisible(true);
    }
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(), "Game Buttons"));
        controlPnl.setLayout(new GridLayout(1, 4));

        icon = new ImageIcon("src/Rock.jpg");
        rockBtn = new JButton(icon);
        rockBtn.addActionListener(this);

        icon = new ImageIcon("src/Paper.jpg");
        paperBtn = new JButton(icon);
        paperBtn.addActionListener(this);

        icon = new ImageIcon("src/Scissors.jpg");
        scissorsBtn = new JButton(icon);
        scissorsBtn.addActionListener(this);

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Calibri", Font.PLAIN, 35));

        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == rockBtn)
        {
            playGame("rock");
        }
        else if (ae.getSource() == paperBtn)
        {
            playGame("paper");
        }
        else if (ae.getSource() == scissorsBtn)
        {
            playGame("scissors");
        }
    }
    private void playGame(String playerChoice)
    {
        String computerChoice = generateComputerChoice();
        String result = determineWinner(playerChoice, computerChoice);

        String gameResult = playerChoice + " vs " + computerChoice + " (" + result + ")";
        statsTA.append(gameResult + "\n");

        if (result.equals("You win!"))
        {
            playerWinCnt++;
        }
        else if (result.equals("Computer wins!"))
        {
            computerWinCnt++;
        }

        pWin.setText("Player Wins: " + playerWinCnt);
        cWin.setText("Computer Wins: " + computerWinCnt);
        tie.setText("Tie Games: " + (playerWinCnt + computerWinCnt - 1));
    }
    private String determineWinner(String playerChoice, String computerChoice)
    {
        if (playerChoice.equals(computerChoice))
        {
            return "It's a tie!";
        }
        else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")))
        {
            return "You win!";
        }
        else
        {
            return "Computer wins!";
        }
    }
    private String generateComputerChoice()
    {
        String[] choices = {"rock", "paper", "scissors"};
        int randomIndex = (int) (Math.random() * choices.length);
        return choices[randomIndex];
    }
}
