public enum Field {
    EMPTY(" "),
    FLD_CIRCLE("O"),
    FLD_CROSS("X");

    private String field;

    Field(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
