package newJavaTicTac;

public enum Field {
    FLD_EMPTY(" "),
    FLD_CIRCLE("O"),
    FLD_CROSS("X");

    private String field;

    Field(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public static Field ofSymbol(char symbol) {
        if(symbol == 'X') {
            return FLD_CROSS;
        } else if(symbol == 'O') {
            return FLD_CIRCLE;
        } else {
            return FLD_EMPTY;
        }
    }
}
