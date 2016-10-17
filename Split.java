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
public class Split extends Event {
    public Event event1;
    public Event event2;
    
    public Split(String eventName, double eventOdds, String eventMessage, 
            String eventTrigger, Event firstEvent, Event secondEvent){
        super(eventName, eventOdds, eventMessage, eventTrigger);
        event1 = firstEvent;
        event2 = secondEvent;
        
    }
    
    /**
     *
     * @param inventory
     */
    @Override
    public void activate(Inventory inventory){
        current = inventory.gps.presentLoc;
        inventory.display(message);
        event1.activate(inventory);
        event2.activate(inventory);
    }
}
