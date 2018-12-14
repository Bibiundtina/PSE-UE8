import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import java.io.IOException;

/**
 * The collector class contains methods, that allow paule to pick up more than one grain. 
 * The class also contains methods testing different error sources.
 *
 * @author Nikita Paffenroth, Niklas Mertens
 * @version 1.0
 */
public class CollectorPaule extends SimpleHamsterGame
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class PainterPaule
     */
    public CollectorPaule()
    {
        game.displayInNewGameWindow();
        try {
            game.initialize("/territories/territory-collector.ter");
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
    
    //@ requieres that there is no wall on numberOfSteps tiles in front of paule.
    //@ requieres numberOfSteps > 0
    //@ ensures paules position is numberOfSteps steps in front of its ealier position
    void multiMove (int numberOfSteps) {
        
        for (int i = 0; i<numberOfSteps; i++) {
            paule.move();
        }
    }
    
    //@ requires at least 10 Grains on the current tile
    //@ ensures paule.grainCount() += 10
    void collectTen() {
        for (int i = 0; i < 10; i++) {
            paule.pickGrain();
        }
    }
    
    
    void testFail() {
        collectTen();
    }
    
    void testNotAllGrains() {
        multiMove (6);
        collectTen();
    }
    
    //@ ensures that paule has picked up all Grains on the current tile
    void collectAll() {
        while ( paule.grainAvailable() ) {
            paule.pickGrain();
        }
    }
    
}


