package minesweeper;

import java.awt.BorderLayout;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static minesweeper.lang.Lang;
import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;

/**
 * חלון
 */

public class Frame extends JFrame {
 static Logger logger = Logger.getLogger("Frame");
 static String title  = null;
 static String File   = null;
 static String New    = null;
 static String easy   = null;
 static String medium = null;
 static String Hard   = null; 
 static String exit   = null;
 ResourceBundle res;
 Panel Panel;
 static String Language = Lang;

        
    public Frame() {
        
        PropertyConfigurator.configure("src/minesweeper/log4j.properties");
       //here Selected langauge
       if(Language == "en")
       {
           logger.info("Start With English Langauge");
          title  = "Minesweeper";
          File   = "File";
          New    = "New";
          easy   = "Easy";
          medium = "Medium";
          Hard   = "Hard";
          exit   = "Exit";
          
       }else if (Language == "ar")
       {
           logger.info("Start With Arabic Langauge");
          res    = ResourceBundle.getBundle("minesweeper/lang_ar");
          title  = res.getString("Minesweeper");
          File   = res.getString("File");
          New    = res.getString("New");
          easy   = res.getString("Easy");
          medium = res.getString("Medium");
          Hard   = res.getString("Hard");
          exit   = res.getString("Exit");
           
       }else if (Language == "he")
       {
           logger.info("Start With Hebrew Langauge");
          res = ResourceBundle.getBundle("minesweeper/lang_he");
          title  = res.getString("Minesweeper");
          File   = res.getString("File");
          New    = res.getString("New");
          easy   = res.getString("Easy");
          medium = res.getString("Medium");
          Hard   = res.getString("Hard");
          exit   = res.getString("Exit");
       }
     
        this.setTitle(title);
        Panel = new Panel(10, 10, 10, this);
        logger.info("panel start");
         // ערך התחלתי כשמתחיל המשחק
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        logger.info("menu start");
        // יוצר תפריט החדש ומוסיפים עלוי
        JMenu file = new JMenu(File);
        menuBar.add(file);

        JMenuItem neww = new JMenuItem(New);
        JMenuItem Easy = new JMenuItem(easy);
        JMenuItem Medium = new JMenuItem(medium);
        JMenuItem hard = new JMenuItem(Hard);
        JMenuItem Exit = new JMenuItem(exit);
        
        file.add(neww);
        file.addSeparator();
        file.add(Easy);
        file.add(Medium);
        file.add(hard);
        file.addSeparator();
        file.add(Exit);

        //מוסיף myMenu כל תפריטי התפריט 
        Menu myMenuListener = new Menu(this);
        neww.addActionListener(myMenuListener);
        Easy.addActionListener(myMenuListener);
        Medium.addActionListener(myMenuListener);
        hard.addActionListener(myMenuListener);
        Exit.addActionListener(myMenuListener);

        this.getContentPane().add(Panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

   /*
    * גורם לחלון להיות גלוי
    */
    
    public void showIt() {
        setLocationRelativeTo(null);
        this.setVisible(true);
        logger.info("game  start and ready to play...");
    }

   /*
    * מחזיר הפנל שה החלון מכיל
    */
    
    public Panel getPanel() {
        return Panel;
    }

    /**
     * הפנל החדש כשהמשתמש משנה הפנל או מתחיל משחק חדש
     */
    
    public void setPanel(Panel newPanel) {
        this.Panel = newPanel;
    }
}
