public enum Sign {
    SGN_CIRCLE("O"),
    SGN_CROSS("X");

    private String sign;

    Sign(String sing) {
        this.sign = sing;
    }

    public String getSign() {
        return sign;
    }
}
