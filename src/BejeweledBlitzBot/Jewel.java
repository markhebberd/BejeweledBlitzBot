package BejeweledBlitzBot;

import java.awt.Color;

public class Jewel {

    Colour enumColour;
    boolean isMulti;
    boolean isPowerBlock;
    boolean isHypercube;

    public void initialiseJewel(Colour colour, boolean isPowerBlock, boolean isMulti) {
        this.enumColour = colour;
        this.isMulti = isMulti;
        this.isPowerBlock = isPowerBlock;
        if (enumColour.getStringRepresentation().equals("black")) {
            isHypercube = true;
        }
    }

    public Color getJewelColour() {
        if (enumColour != null && enumColour.equals(Colour.YELLOW)) {
            return Color.yellow;
        }
        if (enumColour != null && enumColour.equals(Colour.RED)) {
            return Color.red;
        }
        if (enumColour != null && enumColour.equals(Colour.GREEN)) {
            return Color.green;
        }
        if (enumColour != null && enumColour.equals(Colour.WHITE)) {
            return Color.white;
        }
        if (enumColour != null && enumColour.equals(Colour.PURPLE)) {
            return Color.PINK;
        }
        if (enumColour != null && enumColour.equals(Colour.BLUE)) {
            return Color.blue;
        }
        if (enumColour != null && enumColour.equals(Colour.ORANGE)) {
            return Color.orange;
        }
        if (enumColour != null && enumColour.equals(Colour.HYPERCUBE)) {
            return Color.black;
        }
        return Color.getColor("#CCCCCC");
    }
}
