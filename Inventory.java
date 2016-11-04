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
    public THUI gui;
    
    
    public Inventory (String n, int num, String des, int eventNum, int capacity){
        super (n, num, des, eventNum, capacity);
        gui = new THUI();
        gui.setVisible(true);
    }
    
    public int wallet = 5;
    
    public void addGold(int amount){
        this.wallet = wallet + amount;
    }
    
    public void payGold (int amount) {
        this.wallet = wallet - amount;
    }
    
    public void checkInventory () {
        display("Here is what you're carrying:");
        display("You have " + this.wallet + " gold.");
        for(Item x : this.itemArray){
            if(!"empty".equals(x.name)){
                display("You have a " + x.description);
            }
        }
        
    }
    
    public void display (String text) {
        gui.outputDisp.append(text + "\n");
        int length = gui.outputDisp.getText().length();
        gui.outputDisp.setCaretPosition(length);
        System.out.println(text);
    }
    
    
    
    
    public class Monitor {
        public Location presentLoc;
        public Location previousLoc;
        public String facing = "south";
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
