package BejeweledBlitzBot;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ArrayWork {

    private static int basex = 0;
    private static int basey = 0;

    public int[] findBase() throws AWTException {

        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(2000, 2000);
        //Capture are of screen for analysis
        BufferedImage screenCapture = robot.createScreenCapture(rectangle);
        for (int row = 0; row < rectangle.getWidth(); row++) {
            for (int col = 0; col < rectangle.getHeight(); col++) {

                int colour = screenCapture.getRGB(row, col);
                int r = (colour >> 16) & 0xFF;
                int g = (colour >> 8) & 0xFF;
                int b = (colour) & 0xFF;

                if (r == 135 && g == 149 && b == 171) {
//               System.out.println("1st point  x " + row + " y " + col);

                    if (row + 20 < rectangle.getWidth() && col + 15 < rectangle.getHeight()) {
                        int colourcheck = screenCapture.getRGB((row + 20), (col + 15));
                        r = (colourcheck >> 16) & 0xFF;
                        g = (colourcheck >> 8) & 0xFF;
                        b = (colourcheck) & 0xFF;

                        if (r == 123 && g == 126 && b == 156) {
                            basex = row + 170;
                            basey = col + 53;
                            System.out.println("Base x " + basex + " Base y " + basey);
                            int foundBase[] = {basex, basey};
                            return foundBase;
                        }
                    }
                }
            }
        }
        int baseNoFound[] = {0, 0};
        return baseNoFound;
    }

    public void clickPlayNowButton() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(basex + 80, basey + 285);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(10);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public Jewel[][] buildArray() throws Exception {

        Robot robot = new Robot();
        int[] powerDifference = {0, 5};
        //declare and initialise Jewel matrix
        Jewel matrix[][] = new Jewel[8][8];

        Rectangle rectangle = new Rectangle(basex, basey, 281, 289);
        BufferedImage screenCapture = robot.createScreenCapture(rectangle);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == null) {
                    matrix[row][col] = new Jewel();
                }
                    int timeout = 0;
                    while ( timeout < 1) {
                        timeout++;

                        int colourStd = screenCapture.getRGB(col * 40, row * 40);
                        int rStd = (colourStd >> 16) & 0xFF;
                        int gStd = (colourStd >> 8) & 0xFF;
                        int bStd = (colourStd) & 0xFF;

                        int colourMulti = screenCapture.getRGB(((col * 40) + powerDifference[0]), ((row * 40) + powerDifference[1]));
                        int rMulti = (colourMulti >> 16) & 0xFF;
                        int gMulti = (colourMulti >> 8) & 0xFF;
                        int bMulti = (colourMulti) & 0xFF;

                        int colourBlazingSpeedCheck = screenCapture.getRGB(22, 288);
                        int rBlaze = (colourBlazingSpeedCheck >> 16) & 0xFF;
                        int gBlaze = (colourBlazingSpeedCheck >> 8) & 0xFF;
                        int bBlaze = (colourBlazingSpeedCheck) & 0xFF;
// WHITE 
                        if (rStd == 136 && gStd == 136 && bStd == 135) {
                            matrix[row][col].initialiseJewel(Colour.WHITE, true, false);
                            break;
                        }
                        if (rStd == 134 && gStd == 134 && bStd == 134) {
                            matrix[row][col].initialiseJewel(Colour.WHITE, false, false);
                            break;
                        }
                        if (rMulti == 99 && gMulti == 99 && bMulti == 99) {
                            matrix[row][col].initialiseJewel(Colour.WHITE, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 59) {
                            if (rStd > 136 - 10 && rStd < 136 + 10 && gStd > 136 - 10 && gStd < 136 + 10 && bStd > 135 - 10 && bStd < 135 + 10) {
                                matrix[row][col].initialiseJewel(Colour.WHITE, false, false);
                                break;
                            }
                        }
//RED
                        if (rStd == 255 && gStd == 38 && bStd == 70) {
                            matrix[row][col].initialiseJewel(Colour.RED, true, false);
                            break;
                        }
                        if (rStd == 254 && gStd == 36 && bStd == 69) {
                            matrix[row][col].initialiseJewel(Colour.RED, false, false);
                            break;
                        }
                        if (rMulti == 162 && gMulti == 11 && bMulti == 19) {
                            matrix[row][col].initialiseJewel(Colour.RED, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 59) {
                            if (rStd > 254 - 10 && rStd < 254 + 10 && gStd > 36 - 10 && gStd < 36 + 10 && bStd > 69 - 10 && bStd < 69 + 10) {
                                matrix[row][col].initialiseJewel(Colour.RED, false, false);
                                break;
                            }
                        }
// BLUE
                        if (rStd == 27 && gStd == 101 && bStd == 219) {
                            matrix[row][col].initialiseJewel(Colour.BLUE, true, false);
                            break;
                        }
                        if (rStd == 0 && gStd == 85 && bStd == 215) {
                            matrix[row][col].initialiseJewel(Colour.BLUE, false, false);
                            break;
                        }
                        if (rMulti == 0 && gMulti == 91 && bMulti == 182) {
                            matrix[row][col].initialiseJewel(Colour.BLUE, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 59) {
                            if (rStd > 0 - 10 && rStd < 0 + 10 && gStd > 85 - 10 && gStd < 85 + 10 && bStd > 215 - 10 && bStd < 215 + 10) {
                                matrix[row][col].initialiseJewel(Colour.BLUE, false, false);
                                break;
                            }
                        }
//GREEN
                        if (rStd == 18 && gStd == 209 && bStd == 39) {
                            matrix[row][col].initialiseJewel(Colour.GREEN, true, false);
                            break;
                        }
                        if (rStd == 14 && gStd == 208 && bStd == 36) {
                            matrix[row][col].initialiseJewel(Colour.GREEN, false, false);
                            break;
                        }
                        if (rMulti == 5 && gMulti == 138 && bMulti == 9) {
                            matrix[row][col].initialiseJewel(Colour.GREEN, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 59) {
                            if (rStd > 14 - 10 && rStd < 14 + 10 && gStd > 208 - 10 && gStd < 208 + 10 && bStd > 36 - 10 && bStd < 36 + 10) {
                                matrix[row][col].initialiseJewel(Colour.GREEN, false, false);
                                break;
                            }
                        }
//PURPLE
                        if (rStd == 204 && gStd == 22 && bStd == 203) {
                            matrix[row][col].initialiseJewel(Colour.PURPLE, true, false);
                            break;
                        }
                        if (rStd == 202 && gStd == 13 && bStd == 202) {
                            matrix[row][col].initialiseJewel(Colour.PURPLE, false, false);
                            break;
                        }
                        if (rMulti == 142 && gMulti == 19 && bMulti == 146) {
                            matrix[row][col].initialiseJewel(Colour.PURPLE, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 109) {
                            if (rStd > 202 - 10 && rStd < 202 + 10 && gStd > 13 - 10 && gStd < 13 + 10 && bStd > 202 - 10 && bStd < 202 + 10) {
                                matrix[row][col].initialiseJewel(Colour.PURPLE, false, false);
                                break;
                            }
                        }
//YELLOW
                        if (rStd == 255 && gStd == 255 && bStd == 54) {
                            matrix[row][col].initialiseJewel(Colour.YELLOW, true, false);
                            break;
                        }
                        if (rStd == 254 && gStd == 254 && bStd == 45) {
                            matrix[row][col].initialiseJewel(Colour.YELLOW, false, false);
                            break;
                        }
                        if (rMulti == 153 && gMulti == 149 && bMulti == 0) {
                            matrix[row][col].initialiseJewel(Colour.YELLOW, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 59) {
                            if (rStd > 254 - 10 && rStd < 254 + 10 && gStd > 254 - 10 && gStd < 254 + 10 && bStd > 45 - 10 && bStd < 45 + 5) {
                                matrix[row][col].initialiseJewel(Colour.YELLOW, false, false);
                                break;
                            }
                        }
//YELLOW COIN                    
                        if (rStd == 169 && gStd == 128 && bStd == 37) {
                            matrix[row][col].initialiseJewel(Colour.YELLOW, false, false);
                            break;
                        }
//ORANGE
                        if (rStd == 255 && gStd == 135 && bStd == 37) {
                            matrix[row][col].initialiseJewel(Colour.ORANGE, true, false);
                            break;
                        }
                        if (rStd == 254 && gStd == 133 && bStd == 33) {
                            matrix[row][col].initialiseJewel(Colour.ORANGE, false, false);
                            break;
                        }
                        if (rMulti == 208 && gMulti == 81 && bMulti == 0) {
                            matrix[row][col].initialiseJewel(Colour.ORANGE, false, true);
                            break;
                        }
                        if (row == 7 && rBlaze != 124 && gBlaze != 70 && bBlaze != 59) {
                            if (rStd > 254 - 10 && rStd < 254 + 10 && gStd > 133 - 10 && gStd < 133 + 10 && bStd > 33 - 10 && bStd < 33 + 10) {
                                matrix[row][col].initialiseJewel(Colour.ORANGE, false, false);
                                break;
                            }
                        }
//HYPERCHECK

                        if (rStd == 19 && gStd == 20 && bStd == 12) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 24 && gStd == 24 && bStd == 21) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 70 && gStd == 62 && bStd == 44) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 187 && gStd == 182 && bStd == 156) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 114 && gStd == 113 && bStd == 63) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 219 && gStd == 220 && bStd == 142) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 233 && gStd == 234 && bStd == 156) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 195 && gStd == 194 && bStd == 126) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 117 && gStd == 110 && bStd == 51) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 127 && gStd == 125 && bStd == 71) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 254 && gStd == 247 && bStd == 205) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 255 && gStd == 255 && bStd == 203) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 250 && gStd == 246 && bStd == 168) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 255 && gStd == 255 && bStd == 174) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 229 && gStd == 136 && bStd == 228) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 188 && gStd == 197 && bStd == 129) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 115 && gStd == 117 && bStd == 73) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 101 && gStd == 84 && bStd == 61) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 177 && gStd == 162 && bStd == 130) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 55 && gStd == 52 && bStd == 30) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 5 && gStd == 11 && bStd == 4) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 21 && gStd == 20 && bStd == 11) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 76 && gStd == 54 && bStd == 88) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 205 && gStd == 158 && bStd == 200) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 249 && gStd == 189 && bStd == 249) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 243 && gStd == 168 && bStd == 229) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 246 && gStd == 249 && bStd == 227) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 202 && gStd == 131 && bStd == 199) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 213 && gStd == 123 && bStd == 214) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 215 && gStd == 133 && bStd == 213) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 232 && gStd == 148 && bStd == 228) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 204 && gStd == 129 && bStd == 214) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 176 && gStd == 112 && bStd == 181) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 159 && gStd == 89 && bStd == 157) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 134 && gStd == 58 && bStd == 125) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 105 && gStd == 60 && bStd == 110) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 71 && gStd == 49 && bStd == 59) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 64 && gStd == 74 && bStd == 63) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 97 && gStd == 132 && bStd == 92) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 85 && gStd == 114 && bStd == 76) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 0 && gStd == 8 && bStd == 0) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 12 && gStd == 17 && bStd == 6) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 41 && gStd == 28 && bStd == 38) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 141 && gStd == 87 && bStd == 96) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 195 && gStd == 123 && bStd == 134) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 162 && gStd == 84 && bStd == 101) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 87 && gStd == 32 && bStd == 22) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 124 && gStd == 78 && bStd == 75) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 213 && gStd == 165 && bStd == 148) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 255 && gStd == 191 && bStd == 193) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 220 && gStd == 168 && bStd == 167) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 131 && gStd == 75 && bStd == 73) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 83 && gStd == 42 && bStd == 33) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 162 && gStd == 106 && bStd == 102) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 206 && gStd == 139 && bStd == 141) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 126 && gStd == 139 && bStd == 141) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 126 && gStd == 74 && bStd == 69) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 89 && gStd == 41 && bStd == 34) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 78 && gStd == 71 && bStd == 73) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 100 && gStd == 98 && bStd == 110) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }
                        if (rStd == 43 && gStd == 54 && bStd == 76) {
                            matrix[row][col].initialiseJewel(Colour.HYPERCUBE, false, false);
                            break;
                        }


                        /**
                         * Diagnostics...
                         *
                         * if (matrix[row][col].GetColour() == ""){ int
                         * rowPlusOne = row + 1; int colPlusOne = col + 1;
                         * System.out.println("Row " + rowPlusOne + " Column " +
                         * colPlusOne); System.out.println("Red = " +
                         * color.getRed()); System.out.println("Green = " +
                         * color.getGreen()); System.out.println("Blue = " +
                         * color.getBlue()); }
                         */
                    }
                }
            }
            return matrix;
        }

    public int[] findMove(Jewel[][] matrix) throws Exception {
        int[] toMove = new int[4];
        // records highest found move score. 
        int highestMoveRating = 0;
        int[] hasHyper = new int[2];
        hasHyper[1] = 99;
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col < 8; col++) {
                //check move down

//              set tempJewelsFound to 1 to represent 1 Jewel. ++ if a consecutive matching Jewel in line.
                int numberOfJewelsFound = 1;
                // updates if special brick is found
                int jewelsFoundMultiplier = 1;

//              iterate Left and increase tempJewelsFound if matching Jewel found.
                int colAdjust = 1;
                try {
                    while (row < 7 && colAdjust < 3 && col - colAdjust > -1
                            && matrix[row][col].getJewelColour().equals(matrix[row + 1][col - colAdjust].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row + 1][col - colAdjust].isMulti || matrix[row][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row + 1][col - colAdjust].isPowerBlock || matrix[row][col].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        colAdjust++;
                    }

                } catch (Exception dL) {
//                    System.out.println("Error on move down, iterate left- row " + row + " col " + col + " " + dL);
                }
                //iterate Right and increase tempRating[1] if matching Jewel found.
                colAdjust = 1;
                try {
                    while (row < 7 && colAdjust < 3 && col + colAdjust < 8
                            && matrix[row][col].getJewelColour().equals(matrix[row + 1][col + colAdjust].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row + 1][col + colAdjust].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row + 1][col + colAdjust].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        colAdjust++;
                    }
                } catch (Exception dR) {
                    //                  System.out.println("Error on move down, iterate right - row " + row + " col " + col + " " + dR);
                }
                if (numberOfJewelsFound > 2 && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row + 1;
                    toMove[3] = col;
                }
                numberOfJewelsFound = 1;
                try {
                    if (row < 5
                            && matrix[row][col].getJewelColour().equals(matrix[row + 2][col].getJewelColour())
                            && matrix[row][col].getJewelColour().equals(matrix[row + 3][col].getJewelColour())) {
                        numberOfJewelsFound = 3;
                        if (matrix[row][col].isMulti || matrix[row + 2][col].isMulti || matrix[row + 3][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (matrix[row][col].isMulti || matrix[row + 2][col].isMulti || matrix[row + 3][col].isMulti) {
                            jewelsFoundMultiplier += 10;
                        }
                    }

                } catch (Exception dD) {
//                    System.out.println("Error on move down creating column " + row + " col " + col + " " + dD);
                }

                if (numberOfJewelsFound > 2
                        && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row + 1;
                    toMove[3] = col;
                }
//check move UP
// set tempJewelsFound to 1 to represent 1 Jewel. ++ if a consecutive matching Jewel in line.
                numberOfJewelsFound = 1;
                // updates if special brick is found
                jewelsFoundMultiplier = 1;
                //iterate Left and increase tempJewelsFound if matching Jewel found.
                colAdjust = 1;
                try {
                    while (row > 0 && colAdjust < 3 && col - colAdjust > -1
                            && matrix[row][col].getJewelColour().equals(matrix[row - 1][col - colAdjust].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row - 1][col - colAdjust].isMulti || matrix[row][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row - 1][col - colAdjust].isPowerBlock || matrix[row][col].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        colAdjust++;
                    }

                } catch (Exception uL) {
//                    System.out.println("Error on move UP, iterate left- row " + row + " col " + col + " " + uL);
                }
//                iterate Right and increase tempRating[1] if matching Jewel found.
                colAdjust = 1;
                try {
                    while (row > 0 && colAdjust < 3 && col + colAdjust < 8
                            && matrix[row][col].getJewelColour().equals(matrix[row - 1][col + colAdjust].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row][col].isMulti || matrix[row - 1][col + colAdjust].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row][col].isPowerBlock || matrix[row - 1][col + colAdjust].isMulti) {
                            jewelsFoundMultiplier += 10;
                        }
                        colAdjust++;
                    }
                } catch (Exception uR) {
//                    System.out.println("Error on move UP, iterate right - row " + row + " col " + col + " " + uR);
                }
                if (numberOfJewelsFound > 2 && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row - 1;
                    toMove[3] = col;
                }
                numberOfJewelsFound = 1;
                try {
                    if (row > 2
                            && matrix[row][col].getJewelColour().equals(matrix[row - 2][col].getJewelColour())
                            && matrix[row][col].getJewelColour().equals(matrix[row - 3][col].getJewelColour())) {
                        numberOfJewelsFound = 3;
                        if (matrix[row][col].isMulti || matrix[row - 2][col].isMulti || matrix[row - 3][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (matrix[row][col].isMulti || matrix[row - 2][col].isMulti || matrix[row - 3][col].isMulti) {
                            jewelsFoundMultiplier += 10;
                        }
                    }

                } catch (Exception uU) {
//                    System.out.println("Error on move UP creating column above" + row + " col " + col + " " + uU);
                }

                if (numberOfJewelsFound > 2
                        && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row - 1;
                    toMove[3] = col;
                }

// move block RIGHT
                // loop variable of amount to move while checking blocks
                int rowAdjust = 1;

// set tempJewelsFound to 1 to represent 1 Jewel. ++ if a consecutive matching Jewel in line.
                numberOfJewelsFound = 1;
                // updates if special brick is found
                jewelsFoundMultiplier = 1;
                //iterate UP and increase numberOfJewelsFound if matching Jewel found.
                try {
                    while (row - rowAdjust >= 0 && col < 7 && rowAdjust < 3
                            && matrix[row][col].getJewelColour().equals(matrix[row - rowAdjust][col + 1].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row - rowAdjust][col + 1].isMulti || matrix[row][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row - rowAdjust][col + 1].isPowerBlock || matrix[row][col].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        rowAdjust++;
                    }

                } catch (Exception rU) {
//                    System.out.println("Error on move RIGHT, iterate up- row " + row + " col " + col + " " + rU);
                }
//                iterate Down and increase numberOfJewelsFound if matching Jewel found.
                rowAdjust = 1;
                try {
                    while (row + rowAdjust < 8 && col < 7 && rowAdjust < 3
                            && matrix[row][col].getJewelColour().equals(matrix[row + rowAdjust][col + 1].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row + rowAdjust][col + 1].isMulti || matrix[row][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row + rowAdjust][col + 1].isPowerBlock || matrix[row][col].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        rowAdjust++;
                    }
                } catch (Exception dR) {
//                    System.out.println("Error on move RIGHT, iterate down- row " + row + " col " + col + " " + dR);
                }
                if (numberOfJewelsFound > 2 && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row;
                    toMove[3] = col + 1;
                }
                numberOfJewelsFound = 1;
                try {
                    if (col < 5
                            && matrix[row][col].getJewelColour().equals(matrix[row][col + 2].getJewelColour())
                            && matrix[row][col].getJewelColour().equals(matrix[row][col + 3].getJewelColour())) {
                        numberOfJewelsFound = 3;
                        if (matrix[row][col].isMulti || matrix[row][col + 2].isMulti || matrix[row][col + 3].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (matrix[row][col].isMulti || matrix[row][col + 2].isMulti || matrix[row][col + 3].isMulti) {
                            jewelsFoundMultiplier += 10;
                        }
                    }

                } catch (Exception rR) {
//                    System.out.println("Error on move RIGHT creating Row to the right " + row + " col " + col + " " + rR);
                }

                if (numberOfJewelsFound > 2
                        && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row;
                    toMove[3] = col + 1;
                }

// move block LEFT
                // loop variable of amount to move while checking blocks
                rowAdjust = 1;
                numberOfJewelsFound = 1;
                // updates if special brick is found
                jewelsFoundMultiplier = 1;
                //iterate UP and increase numberOfJewelsFound if matching Jewel found.
                try {
                    while (row - rowAdjust >= 0 && col > 0 && rowAdjust < 3
                            && matrix[row][col].getJewelColour().equals(matrix[row - rowAdjust][col - 1].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row - rowAdjust][col - 1].isMulti || matrix[row][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row - rowAdjust][col - 1].isPowerBlock || matrix[row][col].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        rowAdjust++;
                    }

                } catch (Exception lU) {
//                    System.out.println("Error on move LEFT, iterate up- row " + row + " col " + col + " " + lU);
                }
//                iterate Down and increase numberOfJewelsFound if matching Jewel found.
                rowAdjust = 1;
                try {
                    while (row + rowAdjust < 8 && col > 0 && rowAdjust < 3
                            && matrix[row][col].getJewelColour().equals(matrix[row + rowAdjust][col - 1].getJewelColour())) {
                        numberOfJewelsFound++;
                        if (matrix[row + rowAdjust][col - 1].isMulti || matrix[row][col].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (numberOfJewelsFound == 5) {
                            jewelsFoundMultiplier += 100;
                        }
                        if (matrix[row + rowAdjust][col - 1].isPowerBlock || matrix[row][col].isPowerBlock) {
                            jewelsFoundMultiplier += 10;
                        }
                        rowAdjust++;
                    }
                } catch (Exception lR) {
//                    System.out.println("Error on move LEFT, iterate down- row " + row + " col " + col + " " + lR);
                }
                if (numberOfJewelsFound > 2 && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row;
                    toMove[3] = col - 1;
                }
                numberOfJewelsFound = 1;
                try {
                    if (col > 2
                            && matrix[row][col].getJewelColour().equals(matrix[row][col - 2].getJewelColour())
                            && matrix[row][col].getJewelColour().equals(matrix[row][col - 3].getJewelColour())) {
                        numberOfJewelsFound = 3;
                        if (matrix[row][col].isMulti || matrix[row][col - 2].isMulti || matrix[row][col - 3].isMulti) {
                            jewelsFoundMultiplier += 1000;
                        }
                        if (matrix[row][col].isMulti || matrix[row][col - 2].isMulti || matrix[row][col - 3].isMulti) {
                            jewelsFoundMultiplier += 10;
                        }
                    }
                } catch (Exception lL) {
//                    System.out.println("Error on move LEFT creating Row to the left " + row + " col " + col + " " + lL);
                }

                if (numberOfJewelsFound > 2
                        && numberOfJewelsFound * jewelsFoundMultiplier > highestMoveRating) {
                    highestMoveRating = numberOfJewelsFound * jewelsFoundMultiplier;
                    toMove[0] = row;
                    toMove[1] = col;
                    toMove[2] = row;
                    toMove[3] = col - 1;
                }
//                Jewel hyperCheck = new Jewel();
//                hyperCheck.initialiseJewel(Colour.HYPERCUBE, false, false);
                if (matrix[row][col].getJewelColour() == Color.black) {
                    hasHyper[0] = row;
                    hasHyper[1] = col;
                }
            }
        }
        if (hasHyper[1] != 99 && highestMoveRating < 10) {
            if (hasHyper[0] < 7) {
                toMove[0] = hasHyper[0];
                toMove[1] = hasHyper[1];
                toMove[2] = hasHyper[0] + 1;
                toMove[3] = hasHyper[1];
            }
            if (hasHyper[0] == 7) {
                toMove[0] = hasHyper[0];
                toMove[1] = hasHyper[1];
                toMove[2] = hasHyper[0] - 1;
                toMove[3] = hasHyper[1];
            }
        }
        return toMove;
    }

    public void mouseclick(int[] toMove) throws Exception {
        Robot robot = new Robot();

        int rowInitial = toMove[0];
        int colInitial = toMove[1];
        int rowFinal = toMove[2];
        int colFinal = toMove[3];
        int lazy = 10;

        robot.mouseMove(basex + 40 * colInitial, basey + 40 * rowInitial);
        Thread.sleep(lazy);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(lazy);
        robot.mouseMove(basex + 40 * colFinal, basey + 40 * rowFinal);
        Thread.sleep(lazy);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void textDisplayJewel(Jewel[][] matrix) {
        System.out.println(" Column       1        2        3        4        5        6        7        8");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print("Row  (" + (i + 1) + ")");
            for (int j = 0; j < 8; j++) {
                //evening out textDisplayJewel.
                for (int g = matrix[i][j].enumColour.getStringRepresentation().length(); g < 8; g++) {
                    System.out.print(" ");
                }

                if (matrix[i][j] != null) {
                    System.out.print(matrix[i][j].enumColour.getStringRepresentation() + " ");
                }

            }
            System.out.println();
            System.out.println();
        }

    }
}
