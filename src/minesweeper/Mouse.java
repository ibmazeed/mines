package minesweeper;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static minesweeper.Frame.Language;




public class Mouse implements MouseListener {
    private field Field;
    private Panel Panel;
    private int ScanfRow, ScanfCol;
    static String game     = null;
    static String over     = null;
    static String play     = null;
    static String again    = null;
    static String you      = null;
    static String won      = null;
    static String won_msg  = null;
    static String loss_msg = null;
    static ResourceBundle resbun;      
   
     /*
     * m שדה מוקשים שכבר עבר מField p הפנל שעבר מ panel
     */
    
    public Mouse(field f, Panel p) {
        this.Field = f;
        this.Panel = p;
       //here select language
          if(Language == "en")
       {
           
           game  = "game";
           over  = "over";
           play  = "play";
           again = "again?";
           you   = "you";
           won   = "won";
           won_msg  = you +" "+ won +" " + play +" "+ again+" ";
           loss_msg = game +" "+ over +" "+ play +" "+ again+" ";
       }else if (Language == "ar")
       {
        resbun    = ResourceBundle.getBundle("minesweeper/lang_ar");
           game     = resbun.getString("game");
           over     = resbun.getString("over");
           play     = resbun.getString("play");
           again    = resbun.getString("again");
           you      = resbun.getString("you");
           won      = resbun.getString("won");
             won_msg  = you +" "+ won +" " + play +" "+ again+" ";
           loss_msg = game +" "+ over +" "+ play +" "+ again+" ";
       }else if (Language == "he")
       {
             resbun    = ResourceBundle.getBundle("minesweeper/lang_he");
           game     = resbun.getString("game");
           over     = resbun.getString("over");
           play     = resbun.getString("play");
           again    = resbun.getString("again");
           you      = resbun.getString("you");
           won      = resbun.getString("won");
           won_msg  = you +" "+ won +" " + play +" "+ again+" ";
           loss_msg = game +" "+ over +" "+ play +" "+ again+" ";
       }
        
    }

     /*
     * כדי לעשות הדגשה "דגל" i שורות להדגשה j עמודות להדגשה
     */
    
    public void mark(int i, int j) {
        Field.mark(i, j);
        if (Field.areAllMinesFound()) {
            Panel.updateGUI();
            int response = JOptionPane.showConfirmDialog(null, won_msg, "", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.NO_OPTION) {
                endGame();
            } else if (response == JOptionPane.YES_OPTION) {
                newGame();
            }
        }
    }

    /*
     * מסיים את המשחק על ידי סגירת החלון.
     */
    
    public void endGame() {
        SwingUtilities.windowForComponent(Panel).dispose();
    }

    /*
     * יוצר משחק חדש, מסיר את מסגרת שולה המוקשים הישנה ומוסיף אחד חדש.
     */
    
    public void newGame() {
        Panel = Panel.getFrame().getPanel();
        Window parent = SwingUtilities.windowForComponent(Panel);
        parent.remove(Panel);
        Panel miPanel = new Panel(Field.getRows(), Field.getColumns(), Field.getMines(), Panel.getFrame());
        Panel.getFrame().setPanel(miPanel);
        parent.add(miPanel, BorderLayout.CENTER);
        parent.validate();

    }

    
    public void step(int i, int j) {
        if (!Field.step(i, j)) {
            int response = JOptionPane.showConfirmDialog(null, loss_msg, "", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.NO_OPTION) {
                endGame();
            } else if (response == JOptionPane.YES_OPTION) {
                newGame();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    /*
     * אירוע שמופעל כאשר העכבר שוחרר
     */
    
    @Override
    public void mouseReleased(MouseEvent e) {
        Button source = (Button) e.getSource();
        int r = source.getRow();
        int c = source.getColumn();
        if (r == ScanfRow && c == ScanfCol) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                this.step(r, c);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                this.mark(r, c);
            }

            Panel.updateGUI();
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        Button source = (Button) e.getSource();
        ScanfRow = source.getRow();
        ScanfCol = source.getColumn();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
