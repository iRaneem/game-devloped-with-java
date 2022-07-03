package mainsquidgamewin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GameWindow extends JFrame {
//define variables
    private JPanel panel, panel2;
    private JLabel imagelabel, imagelabel2, buttonLabel;
    private JButton odd, even;
    private ImageIcon openHand, closeHand;
    private ArrayList<ImageIcon> ImageList;//to hold the gif images 
    int rightAnsCount = 0;// to hold the player right answers 
    int wrongAnsCount = 0;// to hold the player wrong answers 
    // create new colors
    private Color DarkGreen, FireRed;
    private String color;
    //creat object from color class to hold the background color that was choosed in the team chooser window
    Color x;
    // create new font
    Font font = new Font("Magic R", Font.BOLD, 14);
    //creat menu bar, menus and its components
    private JMenuBar menubar;
    private JMenu File, Edit, instruction;
    private JMenuItem exitItem;
    private JRadioButtonMenuItem blackRadioItem, redRadioItem, greenRadioItem;

    public GameWindow(Color x) {
        // Set this window's title.
        setTitle("Squid Game");
        // Set the size of this window.
        setSize(580, 480);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame 
        setLocationRelativeTo(null);
        //using border layout to arange panels
        setLayout(new BorderLayout());
        // initilize new colors  
        DarkGreen = new Color(0, 100, 0);
        FireRed = new Color(178, 34, 34);
        // Build the panel and add it to the frame.
        bulidimagepanel();
        bulidguessingpanel();
        buildMenuBar();
        // set the background color by user chosen team
        panel.setBackground(x);
        panel2.setBackground(x);
        // Add the panels to the frame's content pane.
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        // Display the window.
        setVisible(true);
    }

//build the image labels panel to edit its properties
    private void bulidimagepanel() {
        panel = new JPanel();

        //image Label 1
        closeHand = new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\game\\closehand1.png");
        imagelabel = new JLabel(closeHand);
        //image Label 2
        imagelabel2 = new JLabel();
        ImageList = new ArrayList<>();
        ImageList.add(new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\game\\openhand2.gif"));
        ImageList.add(new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\game\\openhand3.gif"));

        //adding components to panel
        panel.add(imagelabel);
        panel.add(imagelabel2);
    }

//build the (guessing label and buttons) panel to edit its properties    
    private void bulidguessingpanel() {
        //panel setting
        panel2 = new JPanel();

        //label
        buttonLabel = new JLabel("Guess the value in the closed hand:");
        buttonLabel.setForeground(Color.WHITE);
        buttonLabel.setFont(font);

        //odd button
        odd = new JButton("ODD NUMBER");
        odd.setForeground(Color.WHITE);
        odd.setBackground(x);
        odd.setFont(font);
        odd.addActionListener(new answerListener());

        //even button
        even = new JButton("EVEN NUMBER");
        even.setForeground(Color.WHITE);
        even.setBackground(x);
        even.setFont(font);
        even.addActionListener(new answerListener());

        //adding components to panel
        panel2.add(buttonLabel);
        panel2.add(odd);
        panel2.add(even);
    }

    
    
    //////// start of creating menu bar, menus and its components /////////
    
    private void buildMenuBar() {

        menubar = new JMenuBar();

        buildFileMenu();
        buildEdit();
        buildInstructionsMenu();

        menubar.add(File);
        menubar.add(Edit);
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

    private void buildEdit() {

        Edit = new JMenu("Edit");
        Edit.setToolTipText("Edit the Background Color");

        blackRadioItem = new JRadioButtonMenuItem("Black");
        redRadioItem = new JRadioButtonMenuItem("Red");
        greenRadioItem = new JRadioButtonMenuItem("Green");

        //write to the file the account file 
        blackRadioItem.addActionListener(new ColorListener());
        redRadioItem.addActionListener(new ColorListener());
        greenRadioItem.addActionListener(new ColorListener());

        ButtonGroup group = new ButtonGroup();
        group.add(blackRadioItem);
        group.add(redRadioItem);
        group.add(greenRadioItem);

        Edit.add(blackRadioItem);
        Edit.add(redRadioItem);
        Edit.add(greenRadioItem);
    }

    private void buildInstructionsMenu() {

        instruction = new JMenu("Instructions");

        JTextArea ruleArea = new JTextArea("Game Rules: \n" + " If you got 5 answers right you will win the price !\n"
                + " but If you got 5 wrong you r going to die ! ");

        instruction.add(ruleArea);
    }
    
    
    //////// start of creating Action listener to each button and item /////////

    private class ExitItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitItem) {
                System.exit(0);
                
            }
        }
    }

    private class ColorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (blackRadioItem.isSelected()) {
                panel.setBackground(Color.BLACK);

                panel2.setBackground(Color.BLACK);

            } else if (redRadioItem.isSelected()) {
                panel.setBackground(Color.getColor(color, FireRed));

                panel2.setBackground(Color.getColor(color, FireRed));

            } else if (greenRadioItem.isSelected()) {
                panel.setBackground(Color.getColor(color, DarkGreen));

                panel2.setBackground(Color.getColor(color, DarkGreen));

            }
        }
    }

    private class answerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int index;

            // Create a reference to a Random object.
            Random randimage = new Random();

            // Generate a random number between 0 and the 
            // number of images left in the array list,
            // and store the value in the index variable.
            index = randimage.nextInt(ImageList.size());

            // Get an open hand image from the array list using
            // the index value that was generated randomly.
            openHand = ImageList.get(index);
            // complete
            // Display the open image.
            
            if (e.getSource() == even) {
                imagelabel2.setIcon(openHand);
                //if index is 0 then it is an even number 
                if (index == 0) {

                    JOptionPane.showMessageDialog(null, "You Guessed Well !\n" + "Keep Going");
                    rightAnsCount++;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Guess !\n" + "Carefull You About to be Killed");
                    wrongAnsCount++;
                }
                imagelabel2.setIcon(null);

            } else if (e.getSource() == odd) {
                imagelabel2.setIcon(openHand);
                //if index is 1 then it is an odd number
                if (index == 1) {
                    JOptionPane.showMessageDialog(null, "You Guessed Well !\n" + "Keep Going"); 
                    rightAnsCount++;
                } else {

                    JOptionPane.showMessageDialog(null,"Wrong Guess !\n" + "Carefull You About to be Killed");
                    wrongAnsCount++;
                }
                imagelabel2.setIcon(null);

            }
            // if you got 5 answers right the window6 will open  
            if (rightAnsCount == 5) {
                Windo6 w = new Windo6();
                dispose();// will hide the previous window
            }
            // if you got 5 answers wrong the window5 will open  
            if (wrongAnsCount == 5) {
                Windo5 w = new Windo5();
                dispose();// will hide the previous window

            }
        }
    }
}
