package minesweeper;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * החלון הראשי המכיל את  שולה המוקשים
 */
public class Panel extends JPanel {

    private field Field;
    private Frame Frame;
    private Button[][] Buttons;

    /*
     * filedכמות השורות שקבלנו מ filedכמות העמודות שקבלנו מ filedכמות המוקשים
     * שקבלנו מ filedכמות המוקשים שקבלנו מ Frame שמכיל הפנל
     */
    
        //בונה המטריצה 
    public Panel(int rows, int columns, int mines, Frame Frame) {
        this.Frame = Frame;
        this.Buttons = new Button[rows][columns];
        this.Field = new field(rows, columns, mines);
        Mouse mouseList = new Mouse(Field, this);
        this.setLayout(new GridLayout(rows, columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.add(Buttons[i][j] = new Button(Field.getMineTile(i, j).toString(), i, j));
                Buttons[i][j].addMouseListener(mouseList);
                Buttons[i][j].setPreferredSize(new Dimension(40, 40));
            }
        }
    }

    /*
     * עדכונים ללוח
     */
    public void updateGUI() {
        for (int i = 0; i < Field.getRows(); i++) {
            for (int j = 0; j < Field.getColumns(); j++) {
                if (Field.getMineTile(i, j).toString() == "F") {
                    ImageIcon flag = new ImageIcon(getClass().getResource("/photo/flag.gif"));
                    Buttons[i][j].setIcon(flag);
                } else {
                    switch (Field.getMineTile(i, j).getMinedNeighbours()) {
                        case 1:
                            Buttons[i][j].setText("<html>" + Field.getMineTile(i, j).toString() + "</html>");
                            break;
                        case 2:
                            Buttons[i][j].setText("<html>" + Field.getMineTile(i, j).toString() + "</html>");
                            break;
                        case 3:
                            Buttons[i][j].setText("<html>" + Field.getMineTile(i, j).toString() + "</html>");
                            break;
                        case 4:
                            Buttons[i][j].setText("<html>" + Field.getMineTile(i, j).toString() + "</html>");
                            break;
                        default:
                            break;
                    }
                }
                if (Field.getMineTile(i, j).isRevealed()) {
                    Buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    /*
     * החזרת את כמות השורות שב  field
     */
    public int getRows() {
        return Field.getRows();
    }

    /*
     * החזרת את כמות העמודות שב  field
     */
    public int getColumns() {
        return Field.getColumns();
    }

    /*
     * החזרת את כמות ממוקשים שב  field
     */
    public int getMines() {
        return Field.getMines();
    }

    /*
     * מחזיר החלון
     */
    public Frame getFrame() {
        return Frame;
    }
}
