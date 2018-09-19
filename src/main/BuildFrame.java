package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *  Areeba Waheed
 *  SEP 17, 2018
 *  Comp 585: GUI
 *  Project 1: Calculator
 *
 **/

public class BuildFrame extends JFrame {

    private JPanel panel;
    private JPanel panel1;
    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem exit;
    private JTextField textField;
    private KeyListener keyListener;

    private static final int FRAME_WIDTH =  400;
    private static final int FRAME_HEIGHT = 400;

    private Operation o ;

    public BuildFrame() {
        o = new Operation();
        createKeyListener();
        createTextField();
        buildMenu();
        createFrame();
        addMenuListeners();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }


    public void createKeyListener() {
        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() != KeyEvent.VK_SHIFT) {
                    char x = e.getKeyChar();
                    System.out.println("key pressed: " + x);
                    o.updateTextField(String.valueOf(x), textField);
                }
            }
        };
    }
    
    private void createTextField(){
        textField = new JTextField(11);
        Font bigFont = textField.getFont().deriveFont(Font.PLAIN, 40f);
        textField.setFont(bigFont);
        textField.addKeyListener(keyListener);
    }


    public void buildMenu() {
        bar = new JMenuBar();
        menu = new JMenu("Options");
        exit = new JMenuItem("Exit");
        menu.add(exit);
        bar.add(menu);
    }

    private void createFrame() {
        panel = new JPanel();
        panel1 = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(textField);
        panel.setLayout(new GridLayout(1,0));
        panel1.setLayout(new GridLayout(6,3));
        addButtons();
        add(panel, BorderLayout.NORTH);
        add(panel1, BorderLayout.SOUTH);
        setJMenuBar(bar);
    }

    private void addButtons() {
        ActionListener listener = new ClickListener();
        String labels = "C%+89/67*45-23.01=";
        for(int i =0; i<labels.length(); i++) {
            JButton b = new JButton(labels.substring(i, i+1));
            b.setBackground(Color.WHITE);
            b.setFont(new Font("Arial", Font.BOLD, 31));

            panel1.add(b);
            b.addActionListener(listener);
        }
    }

    public void addMenuListeners(){
        exit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {exitActionPerformed();}
        });
    }


    private void exitActionPerformed() { System.exit (0);}

    public class ClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String c = e.getActionCommand();
            o.updateTextField(c, textField);

        }
    }

}
