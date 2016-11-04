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
public class Compass extends Item{
    
    
    public Compass(String itemName, String itemDescription, int itemValue, boolean canSee, String searchWord, String defaultUse){
        super(itemName, itemDescription, itemValue, canSee, searchWord, defaultUse);
    }
    
    /**
     *
     * @param inventory
     */
    @Override
    public void defaultUse (Inventory inventory){
        inventory.display("You are facing " + inventory.gps.facing + ".");
    }
    
}
