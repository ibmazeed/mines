package minesweeper;
import javax.swing.JButton;

/*
 * מייצג לחצנים  בתוך שדה המוקשים.
 */

public class Button extends JButton {

    private int row;
    private int column;

    public Button(String text, int row, int column) {
        this.setText(text);
        this.row = row;
        this.column = column;
    }

    /*
    * תחזיר את השורות של Tile
    */
    
    public int getRow() {
        return row;
    }

   /*
    * תחזיר את העמודות של Tile
    */
    
    public int getColumn() {
        return column;
    }

}
