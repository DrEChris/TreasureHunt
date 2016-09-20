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
public class LoadItem extends Event {
    
    public int coins;
    public Item[] stash;
    public Item empty = new Item("empty", "empty", 0, true, "empty", "none");
    public boolean reloading = false;
    
    
    public LoadItem(String eventName, double eventOdds, String eventMessage, String eventTrigger, int money) {
        super(eventName, eventOdds, eventMessage, eventTrigger);
        coins = money;
        stash = new Item[10];
        for(int i = 0; i < 10; i++){
            stash[i] = empty;
        }
    }
    
    public void fillStash(Item item){
        for (int i = 0; i < 10; i++){
            if(stash[i] == empty){
                stash[i] = item;
                break;
            }
        }
    }
    
    public void makeReloading(){
        reloading = true;
    }
    
    @Override
    public void activate(Inventory inventory){
        current = inventory.gps.presentLoc;
        System.out.println(message);
        boolean emptyBox = true;
        int count = 0;
        for(Item x : stash){
            if(x != empty){
                emptyBox = false;
                System.out.println("There is a " + x.name);
                for(int i = 0; i < current.itemArray.length; i++){
                    if(current.itemArray[i].name.equals("empty")){
                        current.itemArray[i] = x;
                        if(!reloading){
                            this.stash[count] = empty;
                        }
                        
                        
                        break;
                    }
                }
            }
            count++;
        }
        if(emptyBox && coins <= 0){
            System.out.println("The " + this.name + " is empty."); 
        }
        else if(emptyBox){
            System.out.println("You find " + this.coins + " gold coins.");
            inventory.addGold(coins);
            coins = 0;
        }
        else if(coins > 0){
            System.out.println("And there is " + this.coins + " gold coins.");
            inventory.addGold(coins);
            coins = 0;
        }
    }
}
