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
        inventory.display("Game Over \n");
        inventory.display("\nYour Treasure: \n");
        for(Item x : inventory.itemArray){
            if(!x.name.equals("empty")){
                inventory.display(x.name + "\t Value:  $" + x.value + "\n");
                score = score + x.value;
            }
            
        }
        inventory.display("Gold Value: $" + inventory.wallet);
        inventory.display("\n   Total Score: " + score);
    }
}
