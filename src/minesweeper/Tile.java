package minesweeper;

public class Tile {
    private boolean flag = false;
    private int minesquare = 0;
    private boolean mined = false;
    private boolean reveale = false;

    /*
     * מחזים אם מתגלה
     */
    
    public boolean isRevealed() {
        return reveale;
    }

    public void toggleRevealed() {
        this.reveale = !this.reveale;
    }

     /*
     * מחזים אם מסומן או לא
     */
    
    public boolean flaged() {
        return flag;
    }

    /*
     * מחליף אם מסומן או לא
     */
    
    public void toggleMarked() {
        this.flag = !this.flag;
    }

    /*
     * כמות המוקשים מסביב
     */
    
    public int getMinedNeighbours() {
        return minesquare;
    }

    /*
     * הגדלת המוקשים מסביב
     */
    
    public void incMinedNeighbours() {
        this.minesquare++;
    }

    /*
     * אם נמצא מוקש
     */
    
    public boolean Mined() {
        return mined;
    }

     /**
     * מחליף אם נמצא מוקש או לא
     */
    
    public void toggleMined() {
        this.mined = !this.mined;
    }

 
    public String toString() {
         // מצב הנוכחי של ה TILE
        if (reveale) {
            if (mined) {
                return "*";
            } else {
                return "" + minesquare;
            }
        } else {
            if (flag) {
                return "F";
            } else {
                return "";
            }
        }
    }

    /*
     * קובע אם האריח מתגלה או לא
     */
    
    public void setRevealed(boolean revealed) {
        this.reveale = revealed;
    }

}
