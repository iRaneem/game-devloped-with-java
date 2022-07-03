package mainsquidgamewin;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author msi 1
 */
public class MainSquidGameWin extends JFrame {

    //define variables
    JPanel panel1, panel2;
    JLabel introPiclabel;
    JButton loginBut;
    //creat menu bar, menus and its components
    private JMenuBar menubar;
    private JMenu File;
    private JMenuItem exitItem, demoGamItem;
    // create new font
    Font font = new Font("Magic R", Font.BOLD, 14);

    public MainSquidGameWin() {
        // Set this window's title.
        setTitle("Squid Game");
        // Set the size of this window.
        setSize(500, 500);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //using grid layout to arange panels
        setLayout(new GridLayout(2, 1));
        // set the wndow background color 
        setBackground(Color.BLACK);
        // Build the panel and add it to the frame.
        buildpanel1();
        buildpanel2();
        buildMenuBar();      
        // Add the panel to the frame's content pane.
        add(panel1);
        add(panel2);
        // Center the frame 
        setLocationRelativeTo(null);
        // Display the window.
        setVisible(true);

        // creating try-catch to import audio to the program 
        try {
            File file = new File("Pink_Soldiers.wav");
            URI uri = file.toURI();
            URL url = uri.toURL();
            AudioClip sound = Applet.newAudioClip(url);
            sound.play();
            sound.loop();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

//build the image label panel and edit its background
    private void buildpanel1() {
        panel1 = new JPanel();
        introPiclabel = new JLabel();

        ImageIcon image = new ImageIcon("C:\\Users\\msi 1\\OneDrive\\سطح المكتب\\رنو\\squidgamelogo.png");
        introPiclabel.setIcon(image);

        introPiclabel.setBackground(Color.BLACK);
        panel1.setBackground(Color.BLACK);
        panel1.add(introPiclabel);
    }
//build the login button panel and edit its Properties 
    private void buildpanel2() {
        panel2 = new JPanel();
        loginBut = new JButton("Login");

        loginBut.addActionListener(new loginButton());// add the ActionListener 
        loginBut.setForeground(Color.WHITE);
        loginBut.setBackground(Color.BLACK);
        loginBut.setFont(font);// set the new font 
        loginBut.setToolTipText("login the game");
        panel2.setBackground(Color.BLACK);
        panel2.add(loginBut);
    }
    
//////// start of creating menu bar, menus and its components /////////  
    
    private void buildMenuBar() {

        menubar = new JMenuBar();

        buildFileMenu();

        menubar.add(File);

        setJMenuBar(menubar);
    }

    private void buildFileMenu() {

        File = new JMenu("File");

        exitItem = new JMenuItem("Exit");
        exitItem.setToolTipText("exit the program");
        exitItem.addActionListener(new ExitItemListener());

        demoGamItem = new JMenuItem("Demo Game");
        demoGamItem.setToolTipText("try a demo game without login");
        demoGamItem.addActionListener(new DemoItemListener());

        File.add(exitItem);
        File.add(demoGamItem);
    }
    
    
//////// start of creating Action listener to each button /////////
    private class ExitItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitItem) {
                System.exit(0);
               
            }
        }
    }

    private class DemoItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == demoGamItem) {
                teamChooserWin t = new teamChooserWin();
                dispose();
            }
        }
    }

    private class loginButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            PlayersRegister p = new PlayersRegister();
            dispose();
        }
    }

    public static void main(String[] args) throws MalformedURLException {

        MainSquidGameWin game = new MainSquidGameWin();
    }

}
