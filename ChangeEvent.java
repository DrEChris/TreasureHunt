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
public class ChangeEvent extends Event {
    public Event event;
    public boolean alterOdds;
    public double newOdds;
    public boolean alterTrigger;
    public String newTrigger;
    
    public ChangeEvent (String eventName, double eventOdds, String eventMessage, 
            String eventTrigger, Event targetEvent, boolean oddsChange, double oddsNew, 
            boolean triggerChange, String triggerNew) {
        super(eventName, eventOdds, eventMessage, eventTrigger);
        event = targetEvent;
        alterOdds = oddsChange;
        newOdds = oddsNew;
        alterTrigger = triggerChange;
        newTrigger = triggerNew;
    }
    
    /**
     *
     * @param inventory
     */
    @Override
    public void activate(Inventory inventory){
        current = inventory.gps.presentLoc;
        if(alterOdds){
            event.changeOdds(newOdds);
        }
        if(alterTrigger) {
            event.changeTrigger(newTrigger);
        }
        inventory.display(message);
        
    }
}
