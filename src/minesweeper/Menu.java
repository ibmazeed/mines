package minesweeper;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static minesweeper.Frame.Language;

public class Menu implements ActionListener {

    private Frame Frame;
    private Panel Panel1, Panel2;
    static String File   = null;
    static String New    = null;
    static String easy   = null;
    static String medium = null;
    static String Hard   = null; 
    static String exit   = null;
    static String start  = null;
    static String ask    = null;
    static String game   = null;
    ResourceBundle res;  
   
    
    public Menu(Frame Frame) {
        this.Frame = Frame;
        
          if(Language == "en")
       {
          File   = "File";
          New    = "New";
          easy   = "Easy";
          medium = "Medium";
          Hard   = "Hard";
          exit   = "Exit";
          ask    = "start a new game ?";
          
       }else if (Language == "ar")
       {
          res    = ResourceBundle.getBundle("minesweeper/lang_ar");
          File   = res.getString("File");
          New    = res.getString("New");
          easy   = res.getString("Easy");
          medium = res.getString("Medium");
          Hard   = res.getString("Hard");
          exit   = res.getString("Exit");
          start  = res.getString("start");
          game   = res.getString("game");
          ask    = New +" " +game +" "+start +" ?" ; 
       }else if (Language == "he")
       {
          res = ResourceBundle.getBundle("minesweeper/lang_he");
          File   = res.getString("File");
          New    = res.getString("New");
          easy   = res.getString("Easy");
          medium = res.getString("Medium");
          Hard   = res.getString("Hard");
          exit   = res.getString("Exit");
          start  = res.getString("start");
          game   = res.getString("game");
          ask    = start +" "+ game +" "+New +"?";
       }
      
    }

    /*
     * כשאשר לוחצים על החלון מה קורה
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Panel1 = Frame.getPanel();
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals(New)) {
            newGame(Panel1.getRows(), Panel1.getColumns(), Panel1.getMines());
        } else if (actionCommand.equals(easy)) {
            newGame(10, 10, 10);
        } else if (actionCommand.equals(medium)) {
            newGame(16, 16, 40);
        } else if (actionCommand.equals(Hard)) {
            newGame(16, 30, 99);
        } else if (actionCommand.equals(exit)) {
            Frame.dispose();
        }

    }

    /*
     * מספר השורות במשחק החדש
     *מספר העמודות במשחק החדש
     * מספר המוקשים במשחק החדש
     */
    private void newGame(int rows, int col, int mine) {
        Panel2 = new Panel(rows, col, mine, Panel1.getFrame());
        startNewGame();
    }

    /*
     * מתחיל משחק חדש, מסיר  שדה הלוח הישן ומחליף אותו עם אחד החדש.
     */
    private void startNewGame() {
        int response = JOptionPane.showConfirmDialog(null, ask, null, JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            Window parent = SwingUtilities.windowForComponent(Panel1);
            parent.remove(Panel1);
            Frame.setPanel(Panel2);
            parent.add(Panel2, BorderLayout.CENTER);
            parent.validate();
            Frame.pack();
        }
    }

}
