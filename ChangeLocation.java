/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.Map;

/**
 *
 * @author Christopher
 */
public class ChangeLocation extends Event {
    
    public Location target;
    public String type;
    public String subType;
    public Double lNum;
    public Location lLoc;
    public String lString;
    
    public ChangeLocation(String eventName, double eventOdds, String eventMessage,
            String eventTrigger, Location targetLoc, String changeType, String sub) {
        super (eventName, eventOdds, eventMessage, eventTrigger);
        target = targetLoc;
        type = changeType;
        subType = sub;
        lNum = 0.0;
        lLoc = null;
        lString = null;
    }
    
    public void setNumber(Double number){
        lNum = number;
    }
    public void setLocation(Location location){
        lLoc = location;
    }
    public void setString(String string){
        lString = string;
    }
    
    /**
     *
     * @param inventory
     */
    @Override
    public void activate(Inventory inventory){
        current = inventory.gps.presentLoc;
        switch (type){
            case "climb":
                this.changeClimb();
                break;
            case "map":
                this.changeMap();
                break;
            default:
                inventory.display("Type fail for change location.");
        }
    }
    
    public void changeClimb(){
        switch(subType){
            case "odds":
                for(Map.Entry<String, Double> x : target.climbOdds.entrySet()){
                    if(x.getKey().equals(lString)){
                        x.setValue(lNum);
                        break;
                    }
                    
                }
                break;
            case "place":
                for(Map.Entry<String, Location> x : target.climbList.entrySet()){
                    if(x.getKey().equals(lString)){
                        x.setValue(lLoc);
                        break;
                    }
                    
                }
                break;
            default:
                target.inventory.display("SubType Fail for change climb.");
        }
        
    }
    
    public void changeMap(){
        switch(subType){
            case "north":
                target.makeNorth(lLoc, lString);
                break;
            case "south":
                target.makeSouth(lLoc, lString);
                break;
            case "west":
                target.makeWest(lLoc, lString);
                break;
            case "east":
                target.makeEast(lLoc, lString);
                break;
            case "up":
                target.makeUp(lLoc, lString);
                break;
            case "down":
                target.makeDown(lLoc, lString);
                break;
            default:
                target.inventory.display("SubType fail in change map.");
                break;
        }
    }
}
