/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Christopher
 */
public class Event {
    //Events to be triggered at different points in the game.
    
    public String name;
    public double odds;
    public String message;
    public String trigger;
    public Location current;
    public Set<String> aliasSet = new HashSet<>();
    /**
     *
     */
    
    
    public Event(String eventName, double eventOdds, String eventMessage, String eventTrigger) {
        name = eventName;
        odds = eventOdds;
        message = eventMessage;
        trigger = eventTrigger;
        
    }
    
    public void activate (Inventory inventory) {
        current = inventory.gps.presentLoc;
        inventory.display(message);
    }
    
    public void changeOdds (double newOdds){
        odds = newOdds;
    }
    
    public void changeTrigger (String newTrigger){
        trigger = newTrigger;
    }
    
    public void aka (String newTrigger) {
        this.aliasSet.add(newTrigger);
    }
}
