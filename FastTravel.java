/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.Scanner;

/**
 *
 * @author Christopher
 */
public class FastTravel extends Event {
    
    public String accept;
    public String decline;
    public Location target;
    
   
    public FastTravel(String eventName, double eventOdds, String eventMessage, 
            String eventTrigger, String acceptMessage, String declineMessage, 
            Location targ) {
        super(eventName, eventOdds, eventMessage, eventTrigger);
        accept = acceptMessage;
        decline = declineMessage;
        target = targ;
    }
    
    /**
     *
     * @param inventory
     */
    @Override
    public void activate (Inventory inventory) {
        current = inventory.gps.presentLoc;
        System.out.println(message);
        
        Scanner user_input = new Scanner (System.in);
        System.out.print("yes or no: ");
        String user_command = user_input.nextLine();
        switch (user_command.toLowerCase()){
            case "yes":
            case "y":
            case "yup":
            case "sure":
                current.move(target, accept);
                break;
            case "no":
            case "n":
            case "nope":
                System.out.println(decline);
                
                break;
            default:
                System.out.println("I don't understand");
                this.activate(inventory);
                break;
        }
    }
}
