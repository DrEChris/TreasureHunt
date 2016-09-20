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
public class ClearItems extends Event {
    
    
    public ClearItems(String eventName, double eventOdds, String eventMessage, String eventTrigger) {
        super(eventName, eventOdds, eventMessage, eventTrigger);
    }
    
    @Override
    public void activate(Inventory inventory){
        Location place = inventory.gps.presentLoc;
        int length = place.itemArray.length;
        for(int i = 0; i < length; i++){
            place.itemArray[i] = place.empty;
        }
    }
}
