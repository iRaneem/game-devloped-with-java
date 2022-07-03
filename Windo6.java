package mainsquidgamewin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Windo6 extends JFrame {
    //define variables
    private JPanel panel, panel2, panel3, panel4;
    private JLabel imagelabel, label;
    private JButton replay, exit;
    final int WINDO_WIDTH = 500;
    final int WINDO_HIGHT = 500;
    // create new font
    Font font = new Font("Magic R", Font.BOLD, 14);

    public Windo6() {
        // Set this window's title.
        setTitle("Squid Game");
        // Set the size of this window.
        setSize(WINDO_WIDTH, WINDO_HIGHT);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame 
        setLocationRelativeTo(null);
        setBackground(Color.black);
        // using border layout to arange panels
        setLayout(new BorderLayout());
        // Build the panel and add it to the frame.
        bulidimagepanel();
        buildcontainerPanel();
        // Add the panels to the frame's content pane.
        add(panel, BorderLayout.CENTER);
        add(panel4, BorderLayout.SOUTH);
        // Display the window.
        setVisible(true);
    }

//build the image label panel and edit its properties    
    private void bulidimagepanel() {

        //panel setting
        panel = new JPanel();
        panel.setBackground(Color.BLACK);

        //image label
        imagelabel = new JLabel(new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\game\\price.jpeg"));
        imagelabel.setBackground(Color.BLACK);

        //adding components to panel
        panel.add(imagelabel);
    }
    
//build the Text Area panel to edit its properties
    private void buildLabelPanel() {

        //panel2 setting
        panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        try {
            //Using the File class to print out the outbut details 
            File fileName = new File("PlayerInfo.txt");
            Scanner outputFile = new Scanner(fileName);// to read from file 
            
            String str = outputFile.nextLine();// to hold player name 

            label = new JLabel("Congratulations " + str +" you Win the Price !");
            
            outputFile.close(); //close the file 
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, " to see the result you should login the game ");        
        }

        //label
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setFont(font);
        
        //adding components to panel
        panel2.add(label);
    }
    
//build the reply and exit buttons panel and edit its Properties     
    private void bulidbuttonspanel() {

        //panel2 setting
        panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);
        panel3.setLayout(new GridLayout(1, 2));
        
        //replay button
        replay = new JButton("replay");
        replay.setForeground(Color.WHITE);
        replay.setBackground(Color.BLACK);
        replay.setFont(font);
        replay.setToolTipText("this button start over the game");
        replay.addActionListener(new replyListener());
        
        //replay button
        exit = new JButton("Exit");
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setFont(font);
        exit.setToolTipText("this button exit the game");
        exit.addActionListener(new ExitListener());
        
        //adding components to panel
        panel3.add(exit);
        panel3.add(replay);
    }
    
    
// build container panel to hold all other panels     
    private void buildcontainerPanel() {
        panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        
        buildLabelPanel();
        bulidbuttonspanel();

        
        panel4.add(panel2, BorderLayout.CENTER);
        panel4.add(panel3, BorderLayout.SOUTH);
    }
    
    
    
    //////// start of creating Action listener to each button /////////
    
    private class ExitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }
    }

    private class replyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            teamChooserWin reply = new teamChooserWin();
            dispose();
        }
    }

    public static void main(String[] args) {

        new Windo6();
    }

}
