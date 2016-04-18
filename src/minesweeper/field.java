package minesweeper;

public class field {

    private Tile[][] field;

    private int rows, columns, numMines;

    public field(int rows, int columns, int numMines) {
        this.rows = rows;
        this.columns = columns;
        this.numMines = numMines;
        field = new Tile[rows][columns];
        // יצירת מטריצה
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = new Tile();
            }
        }
        populateMines(numMines);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return numMines;
    }

    public void mineSquare(int row, int column) {
        field[row][column].toggleMined();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && j >= 0 && i < field.length && j < field[i].length) {
                    field[i][j].incMinedNeighbours();
                }

            }
        }
    }

    //מחלק
    private void populateMines(int num) {
        int created = 0;
        while (created < num) {
            int row = (int) (Math.random() * this.rows);
            int col = (int) (Math.random() * this.columns);
            if (!field[row][col].Mined() && !(row == 0 && col == 0)) {
                mineSquare(row, col);
                created++;
            }

        }
    }

    public void mark(int row, int column) {
        this.field[row][column].toggleMarked();

    }

    private void checkReveal(int row, int column) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && j >= 0 && i < field.length
                        && j < field[i].length) {
                    if (!(i == row && j == column)) {
                        if (!field[i][j].isRevealed()) {
                            field[i][j].setRevealed(true);
                            if (field[i][j].getMinedNeighbours() == 0) {
                                checkReveal(i, j);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean step(int row, int column) {
        if (row >= 0 && row < getRows() && column >= 0 && column < getColumns()) {
            if (field[row][column].Mined()) {
                // אם יש דגל מחזירים FALSE
                return false;
            } else {
                // אחרת לחשוף
                field[row][column].setRevealed(true);
                if (field[row][column].getMinedNeighbours() == 0) {
                    checkReveal(row, column);
                }
            }

        }
        return true;

    }

    public boolean areAllMinesFound() {
        // בודק אם כל המקומות שבהן מוקש מסומנים
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if ((field[i][j].Mined() && !field[i][j].flaged()) || (!field[i][j].Mined() && field[i][j].flaged())) {
                    return false;
                }
            }
        }
        return true;
    }

    public Tile getMineTile(int row, int col) {
        return field[row][col];
    }

    public Tile[][] getMineTileArray() {
        return field;
    }

}
