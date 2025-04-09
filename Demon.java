
/**
 * Abstract class Demon - 
 * The main class which provides base functionality for all demonic creatures.
 * 
 * @author Nolan Canto
 * @version 2025.04.09
 */
public abstract class Demon extends Creature
{
    private static final double MAGIC_CHANCE = 0.05;

    /**
     * Constructor for Demon subclasses
     * @param str demon strength
     * @param hp demon hit points
     */
    public Demon(int str, int hp)
    {
        super(str, hp);
    }
    
    /**
     * Demon attack has a 5% chance to inflict +50 bonus damage.
     * @return damage value
     */
    @Override
    public int attack() {
        int baseDamage = super.attack();
        if (Randomizer.nextInt(100) < (MAGIC_CHANCE * 100)) {
            return baseDamage + 50;
        }
        return baseDamage;
    }
}
