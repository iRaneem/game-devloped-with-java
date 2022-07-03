package mainsquidgamewin;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class PlayersRegister extends JFrame {
    
    //define variables
    private JPanel panelO, panelO2, panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    private JLabel nameLabel, passLabel, gendLabel, ageLabel;
    private JTextField nameText, passText, ageText;
    private JRadioButton maleradio, Fmaleradio;
    private ButtonGroup group;
    private JButton startButton, clearButton;
    // create new font
    Font font = new Font("Magic R", Font.BOLD, 14);
    
    //creat menu bar, menus and its components
    private JMenuBar menubar;
    private JMenu File, Accaount;
    private JMenuItem exitItem, fileInfo, startGamItem, clearItem;
    

    public PlayersRegister() {
        // Set this window's title.
        setTitle("Squid Game");
        // Set the size of this window.
        setSize(510, 450);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //using border layout to arange panels
        setLayout(new BorderLayout());
        //initilize ButtonGroup to grouping radio buttons
        group = new ButtonGroup();
        // Build the panel and add it to the frame.
        buildpanelbig1();
        buildpanelbig2();
        buildMenuBar();
        // Add the panels to the frame's content pane.
        add(panelO, BorderLayout.CENTER);
        add(panelO2, BorderLayout.SOUTH);
        // Center the frame 
        setLocationRelativeTo(null);
        // Display the window.
        setVisible(true);
        
    }
    
//build the first big panel to use it in border setlayout   
    private void buildpanelbig1() {
        panelO = new JPanel();
        panelO.setLayout(new GridLayout(2, 2));
        // call the methods
        buildpanel1();
        buildpanel2();
        buildpanel3();
        buildpanel4();

        panelO.setBackground(Color.BLACK);
        //adding components to panel
        panelO.add(panel1);
        panelO.add(panel2);
        panelO.add(panel3);
        panelO.add(panel4);
    }
    
//build the first big panel to use it in border setlayout
    private void buildpanelbig2() {
        panelO2 = new JPanel();
        panelO2.setLayout(new GridLayout(1, 2));
        // call the methods
        buildpanel5();
        buildpanel6();

        panelO2.setBackground(Color.BLACK);
        //adding components to panel
        panelO2.add(panel5);
        panelO2.add(panel6);
    }
    
//build the (username label and text field) panel to edit its properties
    private void buildpanel1() {

        panel1 = new JPanel();
        
        nameLabel = new JLabel("Username: ");//initilize name label
        nameText = new JTextField(10);// initilize name text field 10 characters wide.
        
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setFont(font);//set the new font 
        
        panel1.setBackground(Color.BLACK);
        //adding components to panel
        panel1.add(nameLabel);
        panel1.add(nameText);
    }
    
//build the (Password label and text field) panel to edit its properties
    private void buildpanel2() {
        panel2 = new JPanel();

        passLabel = new JLabel("Password: ");//initilize password label
        passText = new JTextField(10);// initilize password text field 10 characters wide.

        passLabel.setForeground(Color.WHITE);
        passLabel.setBackground(Color.BLACK);
        passLabel.setFont(font);

        panel2.setBackground(Color.BLACK);
        //adding components to panel
        panel2.add(passLabel);
        panel2.add(passText);
    }
    
//build the (Gender label and radioButtons) panel to edit its properties    
    private void buildpanel3() {
        panel3 = new JPanel();

        gendLabel = new JLabel("Gender: ");//initilize gender label
        maleradio = new JRadioButton("Male");//initilize male radio button
        Fmaleradio = new JRadioButton("Female");//initilize female radio button
        //group the radio buttons
        group.add(maleradio);
        group.add(Fmaleradio);

        gendLabel.setForeground(Color.WHITE);
        gendLabel.setBackground(Color.BLACK);
        gendLabel.setFont(font);

        maleradio.setForeground(Color.WHITE);
        Fmaleradio.setForeground(Color.WHITE);
        maleradio.setBackground(Color.BLACK);
        Fmaleradio.setBackground(Color.BLACK);
        maleradio.setFont(font);
        Fmaleradio.setFont(font);

        panel3.setBackground(Color.BLACK);
        //adding components to panel
        panel3.add(gendLabel);
        panel3.add(maleradio);
        panel3.add(Fmaleradio);
    }

//build the (Age label and text field) panel to edit its properties
    private void buildpanel4() {
        panel4 = new JPanel();
        
        ageLabel = new JLabel("Age: ");//initilize age label
        ageText = new JTextField(10);// initilize age text field 10 characters wide.

        ageLabel.setForeground(Color.WHITE);
        ageLabel.setBackground(Color.BLACK);
        ageLabel.setFont(font);//set the new font 

        panel4.setBackground(Color.BLACK);
        //adding components to panel
        panel4.add(ageLabel);
        panel4.add(ageText);
    }
    
//build the clear button panel and edit its Properties 
    private void buildpanel5() {
        panel5 = new JPanel();
             
        clearButton = new JButton("Clear");//initilize clear button 
        clearButton.addActionListener(new clearListener());// add the actionListener
        clearButton.setToolTipText("erase the information content");
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setFont(font);

        panel5.setBackground(Color.BLACK);
        panel5.add(clearButton);//adding component to panel
    }
    
//build the start button panel and edit its Properties 
    private void buildpanel6() {
        panel6 = new JPanel();

        startButton = new JButton("Start Game");//initilize start button 
        startButton.addActionListener(new startListener());// add the actionListener
        startButton.setToolTipText("start a new game ");
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.BLACK);
        startButton.setFont(font);

        panel6.setBackground(Color.BLACK);
        panel6.add(startButton);//adding component to panel
    }
    

//////// start of creating menu bar, menus and its components ///////// 
    
    private void buildMenuBar() {

        menubar = new JMenuBar();

        buildFileMenu();

        buildAccaount();

        menubar.add(File);

        menubar.add(Accaount);

        setJMenuBar(menubar);
    }

    private void buildFileMenu() {

        File = new JMenu("File");
        
        exitItem = new JMenuItem("Exit");
        exitItem.setToolTipText("exit the program");
        exitItem.addActionListener(new ExitItemListener());
        
        startGamItem = new JMenuItem("Start Game");
        startGamItem.setToolTipText("start a new game ");
        startGamItem.addActionListener(new startListener());
        
        clearItem = new JMenuItem("Clear");
        clearItem.setToolTipText("erase the information content");
        clearItem.addActionListener(new clearListener());

        File.add(exitItem);
        File.addSeparator();
        File.add(startGamItem);
        File.addSeparator();
        File.add(clearItem);
    }

    private void buildAccaount() {

        Accaount = new JMenu("Accaount");
        fileInfo = new JMenuItem("save file info");
        fileInfo.setToolTipText("player can save his own information for next login");
        fileInfo.addActionListener(new fileInfoListener());
        
        Accaount.add(fileInfo);
    }
    
    
//////// start of creating Action listener to each button and item /////////
    
    private class ExitItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitItem) {
                System.exit(0);
           
            }
        }
    }
    
    private class clearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //set the text to null to clear it      
            nameText.setText("");
            passText.setText("");
            ageText.setText("");
            //set the radio buttons to false to clear it 
            maleradio.setSelected(false);
            Fmaleradio.setSelected(false);
            
        }
    }


    private class fileInfoListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String nameInput, passInput, gendInput, ageInput;
        // check the user input validation and then save to the file   
            if (inputValidation()) {

                try {
                    //READ THE FILE by try-catch
                    PrintWriter inputFile = new PrintWriter("PlayerInfo.txt");

                    nameInput = nameText.getText();
                    passInput = passText.getText();
                    ageInput = ageText.getText();
                    gendInput = "";
                    if (maleradio.isSelected()) {
                        gendInput = "Male";
                    } else if (Fmaleradio.isSelected()) {
                        gendInput = "Female";
                    }
           
                    inputFile.println(nameInput);
                    inputFile.println(passInput);
                    inputFile.println(gendInput);
                    inputFile.println(ageInput);

                    inputFile.close();
                    JOptionPane.showMessageDialog(null, "Successfully saved. " );

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }

    private class startListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String nameInput, passInput, gendInput, ageInput;
        // check the user input validation and then save to the file 
            if (inputValidation()) {

                try {
                    //READ THE FILE and try catch

                    PrintWriter inputFile = new PrintWriter("PlayerInfo.txt");

                    nameInput = nameText.getText();
                    passInput = passText.getText();
                    ageInput = ageText.getText();
                    gendInput = "";
                    if (maleradio.isSelected()) {
                        gendInput = "Male";
                    } else if (Fmaleradio.isSelected()) {
                        gendInput = "Female";
                    }

                    inputFile.println(nameInput);
                    inputFile.println(passInput);
                    inputFile.println(gendInput);
                    inputFile.println(ageInput);

                    inputFile.close();

                } catch (IOException eX) {
                    JOptionPane.showMessageDialog(null, eX.getMessage());

                }
                teamChooserWin t = new teamChooserWin();
                dispose();
            }
        }
    }
    
//////// start of creating validation methods /////////   

    private boolean validateName() {
        //must be only letters
        return nameText.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    private boolean validatePass() {
        //must be only 8 digits
        return passText.getText().matches("\\d{8}");

    }

    private boolean validateAge() {
        //must be only 2 digits
        return ageText.getText().matches("\\d{2}");

    }

    private boolean validateGender() {

        if (maleradio.isSelected()) {
            return true;
        } else if (Fmaleradio.isSelected()) {
            return true;
        }
        return false;

    }

    private boolean inputValidation() {

        //check that all fields are valid
        if (!validateName()) {
            //only letters
            JOptionPane.showMessageDialog(null, "Error ! Invalid Name ");
            return false;

        }
        if (!validatePass()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Error ! Invalid pass (must be 8 digits) ");
            return false;

        }

        if (!validateGender()) {
            JOptionPane.showMessageDialog(null, "Error ! must select a gender ");
            return false;
        }

        if (!validateAge()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Error ! Invalid Age ");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PlayersRegister CPHP = new PlayersRegister();
    }
}
