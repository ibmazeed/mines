/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Eng
 */
public class lang extends JFrame{
     JButton Start = null;
     JRadioButton en = null;
     JRadioButton ar = null;
     JRadioButton he = null;
     public static String Lang = null;
     
    public  lang()
    {
        final int WINDOWS_WIDTH = 230;
        final int WINDOWS_HEIGHT = 110;
        String title = "Choose Language";
        //set title
        
        setTitle(title);
        setSize(WINDOWS_WIDTH,WINDOWS_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         en = new JRadioButton("English" , true);
         ar = new JRadioButton("العربية");
         he = new JRadioButton("עברי");
        Start =  new JButton("Start");
        
        //here button group 
        ButtonGroup gr = new ButtonGroup();
        
        gr.add(en);
        gr.add(ar);
        gr.add(he);
        
        //here add event
        en.addActionListener(new EventHandleren());
        ar.addActionListener(new EventHandlerar());
        he.addActionListener(new EventHandlerhe());
        Start.addActionListener(new EventHandlerbutton());
        
        // here button that add in it all component
        JPanel panel = new JPanel();
        panel.add(en);
        panel.add(ar);
        panel.add(he);
        panel.add(Start);
        
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
class EventHandleren implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Start.setText("Start");
    }
}
    
class EventHandlerar implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Start.setText("ابدأ");
    }
}

class EventHandlerhe implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Start.setText("הַתחָלָה");
    }
}

class EventHandlerbutton implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if(en.isSelected())
        {
        Lang = "en";
        Frame mineSweeper = new Frame();
        mineSweeper.showIt();
        setVisible(false);
        }
        
        if(ar.isSelected())
        {
        Lang = "ar";
        Frame mineSweeper = new Frame();
        mineSweeper.showIt();
        setVisible(false);
        }
         
        if(he.isSelected())
        {
        Lang  = "he";
        Frame mineSweeper = new Frame();
        mineSweeper.showIt();
        setVisible(false);
        }
    }
    
}

}
