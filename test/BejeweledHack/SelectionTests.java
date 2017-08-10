/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BejeweledHack;

import BejeweledBlitzBot.Colour;
import BejeweledBlitzBot.Jewel;
import BejeweledBlitzBot.StaticMethods;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mark
 */
public class SelectionTests {

    Jewel[][] matrix = new Jewel[8][8];
    StaticMethods arrayWork = new StaticMethods();

    public SelectionTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                matrix[row][col] = new Jewel();
            }
        }
    }

    @After
    public void tearDown() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                matrix[row][col] = null;
            }
        }
    }

    /**
     * Test of findMove method, of class StaticMethods.
     */
    @Test
    public void testFindMove() throws Exception {
        //Check move right iterate  down at array edges. 
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][1].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][1].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(5, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(5, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[0][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        //Check move right iterate up at array edges
        matrix[0][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][6].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][6].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        //move down check column
        setUp();
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[3][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(1, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[4][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(4, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[3][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(1, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[4][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(4, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
//check move up and iterate right
        setUp();
        matrix[1][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][2].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(1, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[1][5].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(1, arrayWork.findMove(matrix)[0]);
        assertEquals(5, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(5, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][5].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(5, arrayWork.findMove(matrix)[1]);
        assertEquals(6, arrayWork.findMove(matrix)[2]);
        assertEquals(5, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][2].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][3].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(1, arrayWork.findMove(matrix)[1]);
        assertEquals(6, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move up and iterate left
        setUp();
        matrix[1][2].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(1, arrayWork.findMove(matrix)[0]);
        assertEquals(2, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(2, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[1][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][5].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(1, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][2].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(2, arrayWork.findMove(matrix)[1]);
        assertEquals(6, arrayWork.findMove(matrix)[2]);
        assertEquals(2, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][5].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(6, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        //iterate up and check for columns
        setUp();
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[4][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(6, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[3][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(3, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[4][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(6, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[3][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(3, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move right iterate up
        setUp();
        matrix[2][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][1].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][1].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[2][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(5, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move right and down
        setUp();
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][1].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][1].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[2][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(6, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(7, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move right and create row to the right
        setUp();
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][2].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][3].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[0][4].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(4, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(5, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][2].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][3].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(0, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(1, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][4].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(4, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(5, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move left and iterate UP
        setUp();
        matrix[2][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(1, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[2][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][6].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(2, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(2, arrayWork.findMove(matrix)[2]);
        assertEquals(6, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(1, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[5][6].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(6, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move left and iterate down
        setUp();
        matrix[0][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(1, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[1][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[2][6].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(6, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][0].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(5, arrayWork.findMove(matrix)[0]);
        assertEquals(1, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(0, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[5][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[6][6].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][6].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(5, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(5, arrayWork.findMove(matrix)[2]);
        assertEquals(6, arrayWork.findMove(matrix)[3]);
        tearDown();
        //check move left and create row
        setUp();
        matrix[0][3].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(3, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(2, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][3].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][1].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][0].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(3, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(2, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[0][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][5].initialiseJewel(Colour.WHITE, false, false);
        matrix[0][4].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(0, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(0, arrayWork.findMove(matrix)[2]);
        assertEquals(6, arrayWork.findMove(matrix)[3]);
        tearDown();
        setUp();
        matrix[7][7].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][5].initialiseJewel(Colour.WHITE, false, false);
        matrix[7][4].initialiseJewel(Colour.WHITE, false, false);
        assertEquals(7, arrayWork.findMove(matrix)[0]);
        assertEquals(7, arrayWork.findMove(matrix)[1]);
        assertEquals(7, arrayWork.findMove(matrix)[2]);
        assertEquals(6, arrayWork.findMove(matrix)[3]);
        tearDown();
    }
}