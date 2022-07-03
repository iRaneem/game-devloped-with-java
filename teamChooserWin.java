package mainsquidgamewin;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;



public class teamChooserWin extends JFrame {
//define variables
    private JPanel panel, panel2;
    private JLabel imagelabel, choosingLabel, imagelabel2;
    private JButton green, red;
    final int WINDO_WIDTH = 500;
    final int WINDO_HIGHT = 500;
    // create new colors
    private final Color DarkGreen;
    private final Color FireRed;
    private String color;
    // create new font
    Font font = new Font("Magic R", Font.BOLD, 14);
    
    //creat menu bar, menus and its components
    private JMenuBar menubar;
    private JMenu File, instruction;
    private JMenuItem exitItem;
   
   
    public teamChooserWin() {
        // Set this window's title.
        setTitle("Squid Game");
        // Set the size of this window.
        setSize(WINDO_WIDTH, WINDO_HIGHT);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame 
        setLocationRelativeTo(null);
        setBackground(Color.black);
        //using border layout to arange panels
        setLayout(new BorderLayout());
        // initilize new colors   
        DarkGreen = new Color(0,100,0);
        FireRed = new Color(178,34,34);
        // Build the panel and add it to the frame.
        bulidimagepanel();
        bulidchoosingpanel();
        buildMenuBar();
        // Add the panels to the frame's content pane.
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        // Display the window.
        setVisible(true);       
    }
    
//build the image label panel to edit its properties
    private void bulidimagepanel() {

        //panel setting
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.setBackground(Color.BLACK);

        //image choosingLabel
        imagelabel = new JLabel(new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\game\\redTeam_ado.jpg"));
        imagelabel2 = new JLabel(new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\game\\greenTeam_ado.jpg"));
        imagelabel.setBackground(Color.BLACK);
        imagelabel2.setBackground(Color.BLACK);
        
        //adding components to panel
        panel.add(imagelabel);
        panel.add(imagelabel2);
    }
    
//build the (choosing team label and buttons) panel to edit its properties
    private void bulidchoosingpanel() {

        //panel setting
        panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);

        //label
        choosingLabel = new JLabel("Choose a Side :");
        choosingLabel.setForeground(Color.WHITE);
        choosingLabel.setBackground(Color.BLACK);
        choosingLabel.setFont(font);
        
        //green button
        green = new JButton("Green");
        green.setToolTipText("Green Team");
        green.setForeground(Color.WHITE);
        green.setBackground(Color.BLACK);
        green.setFont(font);
        green.addActionListener(new teamListener());

        //red button
        red = new JButton("Red");
        red.setToolTipText("Red Team");
        red.setForeground(Color.WHITE);
        red.setBackground(Color.BLACK);
        red.setFont(font);
        red.addActionListener(new teamListener());
        
        //adding components to panel
        panel2.add(choosingLabel);
        panel2.add(red);
        panel2.add(green);
    }
    
    

 //////// start of creating menu bar, menus and its components /////////
    
    private void buildMenuBar() {

        menubar = new JMenuBar();

        buildFileMenu();
     
        buildInstructionsMenu();
        
        menubar.add(File);
     
        menubar.add(instruction);

        setJMenuBar(menubar);
    }

    private void buildFileMenu() {

        File = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        exitItem.setToolTipText("exit the program");
        exitItem.addActionListener(new ExitItemListener());
        
        File.add(exitItem);
    }
    
    private void buildInstructionsMenu() {

        instruction = new JMenu("Instructions");

        JTextArea ruleArea = new JTextArea("Game Rules: \n"+" If you got 5 answers right you will win the price !\n"
                + " but If you got 5 wrong you are going to die ! ");

        instruction.add(ruleArea);      
    }
 
    
    
//////// start of creating Action listener to each button and item /////////
    
    private class teamListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == red){
                // set the background of the game window when open which depends on the team chooser 
                GameWindow w = new GameWindow(Color.getColor(color, FireRed));//the background will turn red when user choose red 
                // will hide the previous window
                dispose();
            }
            else if(e.getSource() == green){
                // set the background of the game window when open which depends on the team chooser 
                GameWindow w = new GameWindow(Color.getColor(color, DarkGreen));//the background will turn green when user choose green 
                // will hide the previous window
                dispose();
            }
        }
    }
    private class ExitItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitItem) {
                System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) {

        new teamChooserWin();

    }

}
