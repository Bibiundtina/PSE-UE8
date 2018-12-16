import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import java.io.IOException;

/**
 * Write a description of class PainterPaule here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PainterPaule extends SimpleHamsterGame
{
    // instance variables - replace the example below with your own
    private String binary;

    /**
     * Constructor for objects of class PainterPaule
     */
    public PainterPaule()
    {
        game.displayInNewGameWindow();
        try {
            game.initialize("/territories/territory-painting.ter");
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
    
    void multiMove (int numberOfSteps) {
           
        for (int i = 0; i<numberOfSteps; i++) {
            paule.move();
        }
    }
    
    /**
     * Tests the painting of number one ("001") after implementing correctly:
     * initialPosition() - which puts paule in the first position ready to 
     *                     paint a digit
     * paintZero() - paints the digit 0
     * paintOne() - paints the digit 
     * space() - space after a digit one or zero put paule to ready position
     *           for the next digit
     */
   
    void fillTile() {
        for ( int i = 0; i < 12; i++ ) {
            paule.putGrain();
        }
    }
    
    void fillThreeTiles() {
        for ( int i = 0; i < 2; i++) {
            fillTile();
            paule.move();    
        }
        fillTile();
    }
    
    void turnRight() {
        for ( int i = 0; i < 3; i++) {
            paule.turnLeft();
        }
    }
    
    //@ requires Paule is standing in the top left corner of a 3x3 square and facing EAST
    //@ ensures Paule "paints" the number 1
    //@ ensures Paule moves to the tile right of the 3x3 square in the top row
    void paintOne() {
        paule.move();
        turnRight();
        fillThreeTiles();
        paule.turnLeft();
        multiMove (2);
        paule.turnLeft();
        multiMove (2);
        turnRight();
    }
    
    //@ requires Paule is standing in the top left corner of a 3x3 square and facing EAST
    //@ ensures Paule "paints" the number 0
    //@ ensures Paule moves to the tile right of the 3x3 square in the top row
    void paintZero() {
        for (int i = 0; i < 2; i++) {
            fillThreeTiles();
            turnRight();
            paule.move();
            fillTile();
            paule.move();
            turnRight();
        }
        multiMove (3);
    }
    
    //@ requires Paule standing on the top row tile next to an 3x3 square
    //@ ensures Paule creates a blank space by moving one space towards east
    void makeSpace() {
        paule.move();
    }
    
    void testPaintingOne() {
        paintZero();
        makeSpace();
        paintZero();
        makeSpace();
        paintOne();
    }
    
    //@ requires number > 0
    //@ ensures a new String with the binary value of the int input
    String integerToBinary (int number) {
        Integer integer = new Integer (number);
        return integer.toBinaryString (number);
    }
    
    void paintDigit (int inputNumber) {
        if (inputNumber < 0 || inputNumber > 7) {
            System.out.println("The number needs to between 0 and 7");
            /* new input request */
        }
        else {
            binary = integerToBinary (inputNumber);
            for (int i = 0; i < binary.length(); i++) {
                int x = Character.getNumericValue(binary.charAt(i));
                if  (x == 0) {
                    paintZero();
                }
                else {
                    paintOne();
                }
                if (i != binary.length()-1) makeSpace();
            }
        }
    }
    
    /* ###### Aufgabenteil i): Für die Dezimalzahl 4 (100). ##### */
}
