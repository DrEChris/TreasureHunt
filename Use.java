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
public class Use extends Event {
    
    public Item item;
    public Event outcome;
    public Boolean drop;
    public String dropSpot;
    
    public Use(String eventName, double eventOdds, String eventMessage, 
            String eventTrigger, Item usedItem, Event whatHappens, 
            Boolean leaveItem, String dropWhere) {
        super(eventName, eventOdds, eventMessage, eventTrigger);
        
        item = usedItem;
        outcome = whatHappens;
        drop = leaveItem;
        dropSpot = dropWhere;
    }
    
    /**
     *
     * @param inventory
     */
    @Override
    public void activate(Inventory inventory){
        current = inventory.gps.presentLoc;
        boolean dontHave = true;
        for (Item x : inventory.itemArray){
            if (x == item){
                dontHave = false;
                if(drop){
                    if(current.itemCheck("empty")){
                        this.leaves(inventory);
                        item.hide(dropSpot);
                        inventory.display(message);
                        outcome.activate(inventory);
                        break;
                    }
                    else {
                        inventory.display("You can't use the " + item.name + " here. \n"
                                + "There are too many things already at this location.");
                        break;
                    }
                }
                else {
                    inventory.display(message);
                    outcome.activate(inventory);
                    break;
                }
            }
        }
        if (dontHave){
            inventory.display("You don't have the " + item.name);
            
        }
    }
    
    public void leaves(Inventory inventory){
            int itemSpot = -1;
            int locSpot = -1;
            int count = 0;
            for(Item x : inventory.itemArray){                
                if(x == item){
                    itemSpot = count;
                    break;
                }
                count ++;       
            }
            count = 0;
            for(Item x : current.itemArray){
                if(x.name.equals("empty")){
                    locSpot = count;
                    break;
                }
                count ++;
            }
            current.itemArray[locSpot] = inventory.itemArray[itemSpot];
            inventory.itemArray[itemSpot] = inventory.empty;
    }
}
