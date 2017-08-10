package BejeweledBlitzBot;

public enum Colour {

    RED("red"),
    WHITE("white"),
    GREEN("green"),
    PURPLE("purple"),
    ORANGE("orange"),
    BLUE("blue"),
    YELLOW("yellow"),
    HYPERCUBE("HYPER");
    
    private final String stringRep;

    private Colour(String stringRep) {
        this.stringRep = stringRep;
    }

    public String getStringRepresentation() {
        return stringRep;
    }
}
