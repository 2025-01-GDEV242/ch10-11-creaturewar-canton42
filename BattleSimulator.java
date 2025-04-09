import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class BattleSimulator here.
 *
 * @author Nolan Canto
 * @version 2025.04.09
 */
public class BattleSimulator
{
    private List<Creature> armyOne; // a.k.a the "good" army
    private List<Creature> armyTwo; // a.k.a the "evil" army
    private int armyOneInitialSize;
    private int armyTwoInitialSize;
    private int battlesFought;
    private int drawKnockouts; // when 2 creatures defeat eachother at the same time

    /**
     * No-arg constructor for BattleSimulator class.
     */
    public BattleSimulator()
    {
        armyOne = new ArrayList<>();
        armyTwo = new ArrayList<>();
        battlesFought = 0;
        drawKnockouts = 0;
        
    }
    
    /**
     * Creates two armies for the battle. Army one is weaker but larger
     * in numbers while Army two is stronger but lesser in numbers.
     */
    private void createArmies() {
        armyOneInitialSize = 100;
        
        for (int i = 0; i < armyOneInitialSize; i++) {
            int creatureType = Randomizer.nextInt(10);
            if (creatureType <= 6) { // should be 70% chance for human
                armyOne.add(new Human());
            } else if (creatureType <= 8) { // should be 20% chance for elf
                armyOne.add(new Elf());
            } else {  // 10% chance for a custom creature in which I haven't made yet.
                armyOne.add(new Human()); // human placeholder for now
            }
        }
        
        armyTwoInitialSize = 40;
        
        for (int i = 0; i < armyTwoInitialSize; i++) {
            int creatureType = Randomizer.nextInt(25);
            if (creatureType <= 18) { // should be 76% chance for human, because humans can be evil too.
                armyTwo.add(new Human());
            } else if (creatureType <= 25) { // should be 24% chance for Cyberdemon
                armyTwo.add(new Cyberdemon());
            } else {  // should be 4% chance for Balrog
                armyTwo.add(new Balrog()); // human placeholder for now
            }
        }
    }
    
    public void runBattle() {
        // juicy lore dump. Also sets up the size and indexes of both armies.
        System.out.println("In the dark distant future. Humans" +
                            " and elves unite to battle against the world's"
                            + " greatest threat... unchecked capitalism."
                            + " Just kidding, it's demons. It's always demons.");
        System.out.println("The Humanity Alliance: " + armyOne.size() + " units.");
        System.out.println("The Demon Alliance: " + armyTwo.size() + " units.");
        
        int armyOneIndex = 0;
        int armyTwoIndex = 0;
        
        while (armyOneIndex < armyOne.size() && armyTwoIndex < armyTwo.size()) {
            Creature armyOneCreature = armyOne.get(armyOneIndex);
            Creature armyTwoCreature = armyTwo.get(armyTwoIndex);
            battlesFought++;
            
            // handles individual battles
            while (armyOneCreature.isAlive() && armyTwoCreature.isAlive()) {
                int armyOneDamage = armyOneCreature.attack();
                int armyTwoDamage = armyTwoCreature.attack();
                
                armyTwoCreature.takeDamage(armyOneDamage);
                armyOneCreature.takeDamage(armyTwoDamage);
            }
            // handles battle outcomes
            if (armyOneCreature.isAlive() && !armyTwoCreature.isAlive()) {
                drawKnockouts++;
                armyOneIndex++;
                armyTwoIndex++;
                System.out.println("Both units fell in battle!");
            } else if (!armyOneCreature.isAlive()) {
                armyOneIndex++;
                System.out.println("The Humanity Alliance loses a unit!");
            } else if (!armyTwoCreature.isAlive()) {
                armyTwoIndex++;
                System.out.println("The Demon Alliance loses a unit!");
            }
        }
        
        // the battle results
        
        System.out.println("\n===== BATTLE RESULTS =====");
        System.out.println("\nBattles fought: " + battlesFought);
        System.out.println("Draw Knockouts: " + drawKnockouts);
        System.out.println(" Human Alliance remaining: " + (armyOne.size() - armyOneIndex));
        System.out.println(" Demon Alliance remaining: " + (armyTwo.size() - armyTwoIndex));
        
        if (armyOneIndex >= armyOne.size() && armyTwoIndex >= armyTwo.size()) {
            System.out.println("\nThe battle ended with both armies eliminating eachother. Awkward.");
        } else if (armyOneIndex >= armyOne.size()) {
            System.out.println("The Demon Alliance has won the battle!");
        } else {
            System.out.println("The Humanity Alliance has won the battle!");
        }
    }
}
