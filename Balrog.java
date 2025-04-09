
/**
 * The Balrog class implements a wrapper for the base Demon class with the following additions
 * Implements a maximum/minimum strength for the demon type [100/50]
 * Implements a maximum/minimum hitpoint total for the demon type [200/80]
 * 
 * The Balrog is the most powerful demon subclass, having very high attack and
 * health stats. Balrogs attack twice each round. Like other demons, Balrogs have
 * a 5% chance to inflict +50 bonus damage with each attack. 
 *
 * @author Nolan Canto
 * @version 2025.04.09
 */
public class Balrog extends Demon
{
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;

    /**
     * Constructor Balrog - generates a demon with random stats within
     * Balrog ranges.
     */
    public Balrog()
    {
        super(
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR,
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP        
        );
    }
    
    /**
     * Balrogs attack twice each round and have a 5% chance to inflict
     * +50 bonus damage with each attack like other demons.
     */
    @Override
    public int attack() {
        int firstAttack = super.attack();
        int secondAttack = super.attack();
        
        return firstAttack + secondAttack;
    }
}
