/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christopher
 */
public class Inventory extends Location {
    public Show showText;
    
    
    public Inventory (String n, int num, String des, int eventNum, int capacity){
        super (n, num, des, eventNum, capacity);
    }
    
    public int wallet = 5;
    
    public void addGold(int amount){
        this.wallet = wallet + amount;
    }
    
    public void payGold (int amount) {
        this.wallet = wallet - amount;
    }
    
    public void checkInventory () {
        System.out.println("Here is what you're carrying:");
        System.out.println("You have " + this.wallet + " gold.");
        for(Item x : this.itemArray){
            if(!"empty".equals(x.name)){
                System.out.println("You have a " + x.description);
            }
        }
        
        
    }
    
    public void loadShow(Show text){
        this.showText = text;
    }
    
    public class Monitor {
        public Location presentLoc;
        public Location previousLoc;
        public int stage = 1;
        
        
        public Monitor() {
            presentLoc = inventory;
            previousLoc = inventory;
            
        }
        
        public void navigate (Location destination){
            previousLoc = presentLoc;
            presentLoc = destination;
            
            
        }
        
        
    }
    
    Monitor gps = new Monitor();
}
