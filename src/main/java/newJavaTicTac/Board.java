package newJavaTicTac;

public class Board {
    private Field[][] fields;
    private boolean blocked;
    public static final int BOARD_SIZE = 3;

    public void clean() {
        for (int i = 0; i < fields.length; i++){
            for (int j = 0; j < fields.length; j++) {
                fields[i][j] = Field.FLD_EMPTY;
            }
        }
    }

    public Board() {
        fields = new Field[BOARD_SIZE][BOARD_SIZE];
        clean();
    }

    public void fillField(int x, int y, Field symbol) {
        if(blocked) {
            return;
        }
        if (getField(x,y) != Field.FLD_EMPTY) {
            throw new IllegalArgumentException();
        }
        fields[x][y] = symbol;
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    public void block() {
        this.blocked = true;
    }

    public void unblock() {
        this.blocked = false;
    }

    public boolean isBlocked() {
        return blocked;
    }
}






