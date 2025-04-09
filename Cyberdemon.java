
/**
 * The Cyberdemon class implements a wrapper for the base Demon class with the following additions
 * Implements a maximum/minimum strength for the demon type [40/20]
 * Implements a maximum/minimum hitpoint total for the demon type [100/25]
 *
 * The Cyberdemon is a powerful demon which has high health and attack stats.
 * Like other demons, it has a 5% chance to inflict +50 bonus damage.
 * Unfortunately, Cyberdemons are prone to being ripped and teared by angry
 * space marines.
 *
 * @author Nolan Canto
 * @version 2025.04.09
 */
public class Cyberdemon extends Demon
{
    private static final int MAX_CYBERDEMON_HP = 100;
    private static final int MIN_CYBERDEMON_HP = 25;
    private static final int MAX_CYBERDEMON_STR = 40;
    private static final int MIN_CYBERDEMON_STR = 20;
    
    /**
     * Constructor Cyberdemon - generates a demon with random stats within
     * Cyberdemon ranges.
     */
    public Cyberdemon()
    {
        super(
            Randomizer.nextInt(MAX_CYBERDEMON_STR-MIN_CYBERDEMON_STR)+MIN_CYBERDEMON_STR,
            Randomizer.nextInt(MAX_CYBERDEMON_HP-MIN_CYBERDEMON_HP)+MIN_CYBERDEMON_HP        
        );
    }
}
