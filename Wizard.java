
/**
 * The Wizard class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [15/2]
 * Implements a maximum/minimum hitpoint total for the creature type [28/10]
 *
 * The Wizard is a old spell caster that has a 20% chance to deal magical damage which
 * doubles its base damage. Wizards do not deal as much damage as Elves, but they have
 * slightly greater health and a better chance of dealing magical damage.
 * 
 * @author Nolan Canto
 * @version 2025.04.09
 */
public class Wizard extends Creature
{
    private static final int MAX_WIZARD_HP = 28;
    private static final int MIN_WIZARD_HP = 10;
    private static final int MAX_WIZARD_STR = 15;
    private static final int MIN_WIZARD_STR = 2;
    private static final double MAGIC_CHANCE = 0.20;

    /**
     * Constructor for Wizard - generates a creature with random stats within
     * Wizard ranges.
     */
    public Wizard()
    {
        super(
            Randomizer.nextInt(MAX_WIZARD_STR-MIN_WIZARD_STR)+MIN_WIZARD_STR,
            Randomizer.nextInt(MAX_WIZARD_HP-MIN_WIZARD_HP)+MIN_WIZARD_HP        
        );
    }

    /**
     * Wizard attack has a 20% chance to return double the amount of base damage.
     * @return damage value
     */
    @Override
    public int attack() {
        int baseDamage = super.attack();
        if (Randomizer.nextInt(100) < (MAGIC_CHANCE * 100)) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
