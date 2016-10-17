/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christopher
 */
public class Item {
    //Items can be picked up and carried to different locations
    //Items can be used, or may automatically trigger an event
    
    public String name;
    public String description;
    public int value;
    public boolean visable;
    public String searchTrigger;
    public String pointlessUse;
    public Map<Location, Event> uses = new HashMap();
    public Map<Location, String[]> drops = new HashMap();
    
    public Item (String itemName, String itemDescription, int itemValue, boolean canSee, String searchWord, String defaultUse){
        name = itemName;
        description = itemDescription;
        value = itemValue;
        visable = canSee;
        searchTrigger = searchWord;
        pointlessUse = defaultUse;
    }
    
    public void makeVisable(){
        this.visable = true;
    }
    
    public void hide(String where){
        this.visable = false;
        this.searchTrigger = where;
    }
    
    public void defaultUse(Inventory inventory) {
        inventory.display(pointlessUse);
    }
    
    public void use(Inventory inventory){
        boolean usefull = false;
        for(Map.Entry<Location, Event> entry : uses.entrySet()){
            if(inventory.gps.presentLoc == entry.getKey()){
                entry.getValue().activate(inventory);
                usefull = true;
                break;
            }
        }
        if(!usefull){
            this.defaultUse(inventory);
        }
    }
    
    public void addUse(Location location, Event effect, boolean drop, String dropWhere, boolean destroy){
      uses.put(location, effect);
      String[] dropArray = new String[2];
      if(drop){
          dropArray[0] = "drop";
          dropArray[1] = dropWhere;
      }
      if(destroy) {
          dropArray[0] = "destroy";
          dropArray[1] = "destroy";
      }
      if(!drop && !destroy){
          dropArray[0] = "no";
          dropArray[1] = "no";
      }
      drops.put(location, dropArray);
    }
    
    
   
    
}
