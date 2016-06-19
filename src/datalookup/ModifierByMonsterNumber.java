package datalookup;

/**
 *
 * @author Andrew J Toms II
 */
public class ModifierByMonsterNumber {
    
    private static float[] modifiers = {0.5f, 1, 1.5f, 2, 2.5f, 3, 4, 5};
    
    public static float getMultiplier(int numMonsters, int numParty)
    {
        int index = -1;
        if(numMonsters >= 15)
        {
            index = 6;
        } else if (numMonsters >= 11)
        {
            index = 5;
        } else if (numMonsters >= 7)
        {
            index = 4;
        } else if (numMonsters >= 3)
        {
            index = 3;
        } else if (numMonsters == 2)
        {
            index = 2;
        } else if (numMonsters == 1)
        {
            index = 1;
        } else {
            throw new IllegalArgumentException("Negative number of monsters provided.");
        }
        
        if(numParty > 5) 
        {
            index--;
        } 
        else if (numParty < 4)
        {
            index++;
        }
        
        return modifiers[index];
    }

}
