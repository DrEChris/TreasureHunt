/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

/**
 *
 * @author Christopher
 */
public class EndGame extends Location{
    
    public EndGame (String n, int num, String des, int eventNum, int capacity){
        super (n, num, des, eventNum, capacity);
    }
    
    @Override
    public void activate(Inventory inventory){
        int score = inventory.wallet;
        System.out.println("Game Over \n");
        System.out.println("\nYour Treasure: \n");
        for(Item x : inventory.itemArray){
            if(!x.name.equals("empty")){
                System.out.println(x.name + "\t Value:  $" + x.value + "\n");
                score = score + x.value;
            }
            
        }
        System.out.println("Gold Value: $" + inventory.wallet);
        System.out.println("\n   Total Score: " + score);
    }
}
