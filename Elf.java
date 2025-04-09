
/**
 * The Elf class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [18/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/8]
 *
 * The Elf creature has a 10% chance to deal magical damage, which will double
 * the amount of base damage it does.
 * 
 * @author Nolan Canto
 * @version 2025.04.09
 */
public class Elf extends Creature
{
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;
    private static final double MAGIC_CHANCE = 0.10;
    
    /**
     * Constructor for Elf - generates a creature with random stats within
     * Elf ranges.
     */
    public Elf() {
        super(
            Randomizer.nextInt(MAX_ELF_STR-MIN_ELF_STR)+MIN_ELF_STR,
            Randomizer.nextInt(MAX_ELF_HP-MIN_ELF_HP)+MIN_ELF_HP        
        );
    }
    
    /**
     * Elf attack has a 10% chance to return double the amount of base damage.
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
