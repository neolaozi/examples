package com.lgcns.example.lambda.collection;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author MikeW
 */
public class ListenerTest {
  public static void main(String[] args) {
        
    JButton testButton = new JButton("Test Button");
    testButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        System.out.println("Click Detected by Anon Class");
      }
    });
    
    testButton.addActionListener(e -> { 
      System.out.println("Click Detected by Lambda Listner");
    });
    
    // Swing stuff
    JFrame frame = new JFrame("Listener Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(testButton, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    
  }
}
