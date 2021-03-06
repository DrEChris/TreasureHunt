/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;


import java.util.Scanner;
import java.lang.Class;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Christopher
 */
public class Location {
        //Basic location class
        
        public String name;
        public int locNumber;
        public String description; 
        public Location north = this;
        public String northWords = "can't";
        public Location south = this;
        public String southWords = "can't";
        public Location east = this;
        public String eastWords = "can't";
        public Location west = this;
        public String westWords = "can't";
        public Location up = this;
        public String upWords = "can't";
        public Location down = this;
        public String downWords = "can't";
        public Event[] eventArray;
        public Item[] itemArray;
        public Item empty = new Item("empty", "empty", 0, true, "empty", "none");
        public Inventory inventory;
        public String[] directions = {"north", "south", "east", "west", "up", "down"};
        public ArrayList<String> exceptions = new ArrayList();
        public ArrayList<String> conversions = new ArrayList();
        public Map<String, Location> climbList = new HashMap();
        public Map<String, Double> climbOdds = new HashMap();
        public Map<String, String> itemDesc = new HashMap();
        
        
        
        //Location Constructor
        public Location(String n, int num, String des, int eventNum, int capacity) {
            name = n;
            locNumber = num;
            description = des;
            eventArray = new Event[eventNum];
            itemArray = new Item[capacity];
            for(int i = 0; i < capacity; i++){
                itemArray[i] = empty;
            }
            
        }
        
        public void makeNorth (Location locate, String message) {
            this.north = locate;
            this.northWords = message;
        }     
        public void makeSouth (Location locate, String message) {
            this.south = locate;
            this.southWords = message;
        }     
        public void makeEast (Location locate, String message) {
            this.east = locate;
            this.eastWords = message;
        }     
        public void makeWest (Location locate, String message) {
            this.west = locate;
            this.westWords = message;
        }     
        public void makeUp (Location locate, String message) {
            this.up = locate;
            this.upWords = message;
        }     
        public void makeDown (Location locate, String message) {
            this.down = locate;
            this.downWords = message;
        }
        public void makeException (String exception, String direction){
            exceptions.add(exception);
            conversions.add(direction);
        }
        public void makeClimb (String trigger, Location newLoc, Double odds){
            climbList.put(trigger, newLoc);
            climbOdds.put(trigger, odds);
        }
       

        public void move (Location place, String text) {
            if (text.equals("can't")) {
                inventory.display("You can't go that way.");   
            }
            else if(text.length() > 5){
                if(text.substring(0, 5).equals("climb")){
                    this.climb(text.substring(6));
                }
                else {
                    inventory.display(text);
                    inventory.gps.navigate(place);
                    place.activate(inventory);
                }
            }
            else {
                inventory.display(text);
                inventory.gps.navigate(place);
                place.activate(inventory);
            }
        }
        
        
        /**
         *
         */
        public void activate (Inventory oldInventory) {
            inventory = oldInventory;
            
            //location description
            //System.out.println("You are " + name);
            inventory.display("\n");
            inventory.display(description);
            
            //event checker
            for(Event x : eventArray){
                if (x.trigger.equals("arrival")){
                    if(x.odds >= Math.random()){
                        x.activate(inventory);
                    }
                }
            }

            //Item checker
            for(Item x : itemArray){
                boolean spec = false;
                for(Map.Entry<String, String> y : itemDesc.entrySet()){
                    if(x.name.equals(y.getKey())){
                        spec = true;
                        inventory.display(y.getValue());
                    }
                }
                if (x.visable && !x.name.equals("empty") && !spec) {
                    inventory.display("There is a" + x.description + " here.");
                }
            }
            
            //Encounter checker
            
            
            //command
            while (inventory.gps.presentLoc == this) {
                //Scanner user_input = new Scanner (System.in);
                inventory.display("What do you do?: ");
                //String user_command = user_input.nextLine();
                String user_command = inventory.gui.getCommand();
                inventory.display(user_command);
                if(!user_command.equals("")){
                    translate (user_command.toLowerCase());
                }
                
            }
        }
        
        
        public void translate (String userInput){
            //find and seperate the first 'action' word
            boolean first = true;
            int count = 0;
            while (first){
                if(Character.isWhitespace(userInput.charAt(count))){
                    first = false;
                }
                else {
                    count++;
                }
                if (count == userInput.length()){
                    first = false;
                }
            }    
            String firstWord = userInput.substring(0, count);
            String secondWord = "empty";
            if(userInput.length() > count + 1){
                secondWord = userInput.substring(count + 1);
            }
            
            //check if firstWord equals a valid command
            switch (firstWord) {
                case "go":
                case "move":
                case "walk":
                case "head":
                case "leave":
                case "enter":
                    this.go(secondWord);
                    break;
                case "north":
                case "n":
                    this.go("north");
                    break;
                case "south":
                case "s":
                    this.go("south");
                    break;
                case "east":
                case "e":
                    this.go("east");
                    break;
                case "west":
                case "w":
                    this.go("west");
                    break;
                case "up":
                case "u":
                    this.go("up");
                    break;
                case "down":
                case "d":
                    this.go("down");
                case "get":
                case "pick":
                case "take":
                case "grab":
                    this.pickUp(secondWord);
                    break;
                case "drop":
                //case "leave":
                case "discard":
                    this.drop(secondWord);
                    break;
                case "climb":
                    this.climb(secondWord);
                    break;
                case "use":
                    this.use(secondWord);
                    break;
                case "look":
                case "search":
                case "check":
                case "open":
                    this.search(secondWord);
                    break;
                case "stop":
                    inventory.display("You have stopped the code.");
                    this.move(inventory.up, inventory.upWords);
                    break;
                case "teleport":
                    boolean none = true;
                    for(Event x : eventArray){
                        if(x.trigger.startsWith("teleport") && secondWord.endsWith(x.trigger.substring(9))){
                            none = false;
                            x.activate(inventory);
                        }
                    }
                    if(none){inventory.display("I don't understand.  Please try again.");}
                    break;
                default:
                    inventory.display("I don't understand.  Please try again.");
                    break;
            }
        }
        
        public void go(String secondWord){
            String to = "none";
            for(String x : directions){
                if(secondWord.endsWith(x)){
                    to = x;
                    break;
                }
            }
            for(String x : exceptions){
                if(secondWord.endsWith(x)){
                    to = conversions.get(exceptions.indexOf(x));
                    break;
                }
            }
            if(secondWord.equals("forward") || secondWord.equals("forwards")){
                to = inventory.gps.facing;
            }
            if(secondWord.equals("back") || secondWord.equals("backwards")){
                to = "back";
            }
            Location place;
            String text;
            switch(to){
                case "north":
                    place = this.north;
                    text = this.northWords;
                    inventory.gps.facing = "north";
                    this.move(place, text);
                    break;
                case "south":
                    place = this.south;
                    text = this.southWords;
                    inventory.gps.facing = "south";
                    this.move(place, text);
                    break;
                case "east":
                    place = this.east;
                    text = this.eastWords;
                    inventory.gps.facing = "east";
                    this.move(place, text);
                    break;
                case "west":
                    place = this.west;
                    text = this.westWords;
                    inventory.gps.facing = "west";
                    this.move(place, text);
                    break;
                case "up":
                    place = this.up;
                    text = this.upWords;
                    inventory.gps.facing = "up";
                    this.move(place, text);
                    break;
                case "down":
                    place = this.down;
                    text = this.downWords;
                    inventory.gps.facing = "down";
                    this.move(place, text);
                    break;
                case "back":
                    this.move(inventory.gps.previousLoc, "You head back the way you came.");
                    break;
                default:
                    boolean none = true;
                    for(Event x : eventArray){
                        if(x.trigger.length() > 2){
                            if(x.trigger.substring(0, 2).equals("go") && secondWord.endsWith(x.trigger.substring(3))){
                                none = false;
                                x.activate(inventory);
                            }
                            else{
                                for(String aka : x.aliasSet){
                                    if(aka.substring(0, 2).equals("go") && secondWord.endsWith(aka.substring(3))){
                                        none = false;
                                        x.activate(inventory);
                                    }
                                }
                            }
                        }
                    }
                    if(none){
                        inventory.display("I don't understand where you want to go. \n"
                            + "Please try picking a direction.");
                        
                    }
                    
                    break;
            }
            
        }
        
        
        public void climb(String secondWord) {
            double odds = 0.0;
            Location place = null;
            boolean climbFound = false;
            for(Map.Entry<String, Location> entry : climbList.entrySet()) {
                if(secondWord.endsWith(entry.getKey())){
                    place = entry.getValue();
                    for(Map.Entry<String, Double> x : climbOdds.entrySet()){
                        if(x.getKey().equals(entry.getKey())){
                            odds = x.getValue();
                            break;
                        }
                    }
                    climbFound = true;
                    break;
                }
            }
            if(climbFound){
                if(odds == 1) {
                    this.move(place, "What an easy climb.");
                }
                else{
                    inventory.display("You investigate the climb.");
                    if (odds > 0.8){
                        inventory.display("This climb looks fairly safe.  You should be able to do it.");
                    }
                    else if (odds > 0.5){
                        inventory.display("This climb looks tough, but you can probably make it.");
                    }
                    else if (odds > 0.3){
                        inventory.display("This climb looks dangerous, I wouldn't do it.");
                    }
                    else {
                        inventory.display("There is no way you'll make this climb... don't do it!");
                    }
                    inventory.display("Do you still wish to make the climb?");

                    //Scanner user_input = new Scanner (System.in);
                    inventory.display("yes or no: ");
                    String user_command = inventory.gui.getCommand();
                    inventory.display(user_command);
                    switch (user_command.toLowerCase()){
                        case "yes":
                        case "y":
                        case "yup":
                        case "sure":
                            inventory.display("You start to climb.");
                            if(odds >= Math.random()){
                                String text;
                                if (odds > 0.8){
                                    text = "You easily make the climb.";
                                }
                                else if (odds > 0.5){
                                    text = "With a little effort you make the climb, despite a few dangerous spots.";
                                }
                                else if (odds > 0.3){
                                    text = "You almost fell a few times, but you made it.";
                                }
                                else {
                                    text = "Someone must be looking out for you.\n"
                                        + "There is no reason you should have made that climb, but somehow you did.";
                                }

                                this.move(place, text);
                            }
                            else {
                                inventory.display("You fall and break your neck. \n \n");
                                this.move(inventory.up, inventory.upWords);
                            }
                            break;
                        case "no":
                        case "n":
                        case "nope":
                            inventory.display("You decide not to make the climb.");

                            break;
                        default:
                            inventory.display("I don't understand");

                            break;
                    }
                }
            }
            else {
                inventory.display("You can't climb " + secondWord + " here.");
                
            }
        }
        
        public boolean itemCheck(String itemName){
            boolean i = false;
            for(Item x : itemArray){
                if (x.visable == true && itemName.endsWith(x.name)) {
                    i = true;
                    break;
                }
            }
            return i;
        }
        
        public void pickUp(String secondWord){
            if (secondWord.equals("empty")){
                //Scanner user_input = new Scanner (System.in);
                inventory.display("What do you want to get?: ");
                String user_command = inventory.gui.getCommand();
                inventory.display(user_command);
                secondWord = user_command.toLowerCase();
            }
            int itemSpot = -1;
            int inventorySpot = -1;
            int count = 0;
            for(Item x : itemArray){
                int lengX = x.name.length();
                int lengW = secondWord.length();
                if(lengW >= lengX){
                    if(secondWord.endsWith(x.name)){
                        itemSpot = count;
                        break;
                    }
                }
                count ++;       
            }
            count = 0;
            for(Item x : inventory.itemArray){
                if(x.name.equals("empty")){
                    inventorySpot = count;
                    break;
                }
                count ++;
            }
            if(itemSpot == -1){
                inventory.display(secondWord + " is not here.");
                
            }
            else if(inventorySpot == -1){
                inventory.display("Your inventory is full. \n"
                        + "You will have to drop an item before you pick anything else up.");
                
            }
            
            else {
                inventory.itemArray[inventorySpot] = this.itemArray[itemSpot];
                this.itemArray[itemSpot] = empty;
                inventory.display("You pick up the " + inventory.itemArray[inventorySpot].name);
                inventory.itemArray[inventorySpot].makeVisable();
            }
            boolean noEvent = true;
            for(Event x : this.eventArray){
                if(x.trigger.length() > 3){
                    
                    if(x.trigger.substring(0, 3).equals("get") && secondWord.endsWith(x.trigger.substring(4))){
                        inventory.display(x.trigger);
                        noEvent = false;
                        x.activate(inventory);
                    }
                }
            }
            
            
        }
        
        public void drop(String secondWord){
            int itemSpot = -1;
            int locSpot = -1;
            int count = 0;
            for(Item x : inventory.itemArray){
                int lengX = x.name.length();
                int lengW = secondWord.length();
                if(lengW >= lengX){
                    if(secondWord.endsWith(x.name)){
                        itemSpot = count;
                        break;
                    }
                }
                count ++;       
            }
            count = 0;
            for(Item x : itemArray){
                if(x.name.equals("empty")){
                    locSpot = count;
                    break;
                }
                count ++;
            }
            if(itemSpot == -1){
                inventory.display("You don't have " + secondWord);
            }
            else if(locSpot == -1){
                inventory.display("You can't leave the " + inventory.itemArray[itemSpot].name + " here. \n"
                        + "There is not enough room for it.");
            }
            
            else {
                this.itemArray[locSpot] = inventory.itemArray[itemSpot];
                inventory.itemArray[itemSpot] = empty;
                inventory.display("You drop the " + this.itemArray[locSpot].name);
            }
        }
        
        public void search(String secondWord){
            if(secondWord.equals("empty") || secondWord.endsWith("around")){
                inventory.display(description);
                for(Item x : itemArray){
                    boolean spec = false;
                    for(Map.Entry<String, String> y : itemDesc.entrySet()){
                        if(x.name.equals(y.getKey())){
                            spec = true;
                            inventory.display(y.getValue());
                        }
                    }
                    if (x.visable && !x.name.equals("empty") && !spec) {
                        inventory.display("There is a" + x.description + " here.");
                    }
                }
            }
            else if (secondWord.endsWith("inventory")){
                inventory.checkInventory();
            }
            else if (this.itemCheck(secondWord)){
                for(Item x : itemArray){
                    if(secondWord.endsWith(x.name)){
                        inventory.display("It is a" + x.description);
                        break;
                    }
                }
            }
            else if (inventory.itemCheck(secondWord)){
                for(Item x : inventory.itemArray){
                    if(secondWord.endsWith(x.name)){
                        inventory.display("You have a" + x.description);
                        break;
                    }
                }
            }
            else {
                boolean notFound = true;
                for (Item x : itemArray){
                    if(x.visable == false && secondWord.endsWith(x.searchTrigger)){
                        x.makeVisable();
                        notFound = false;
                        inventory.display("You find a " + x.description + " hidden in the " + x.searchTrigger);
                    }
                }
                
                for(Event x : eventArray){
                    if(x.trigger.length() > 6){
                        if(x.trigger.substring(0, 6).equals("search") && secondWord.endsWith(x.trigger.substring(7))){
                            notFound = false;
                            x.activate(inventory);
                        }
                        else{
                                for(String aka : x.aliasSet){
                                    if(aka.substring(0, 5).equals("search") && secondWord.endsWith(aka.substring(6))){
                                        notFound = false;
                                        x.activate(inventory);
                                    }
                                }
                            }
                    }
                }
                if (notFound){
                    inventory.display("You couldn't find anything");
                }
                
            }
        }

        public void use(String secondWord){
            boolean noUse = true;
            for(Event x : this.eventArray){
                if(x instanceof Use && secondWord.endsWith(x.trigger)){
                    noUse = false;
                    
                    if(x.odds >= Math.random()){
                        x.activate(inventory);
                    }
                    break;
                }
                else if(x.trigger.substring(0, 3).equals("use") && secondWord.endsWith(x.trigger.substring(4))){
                    noUse = false;
                    if(x.odds >= Math.random()){
                        x.activate(inventory);
                    }
                    break;
                }
                else{
                    for(String aka : x.aliasSet){
                        if(aka.substring(0, 3).equals("use") && secondWord.endsWith(aka.substring(4))){
                            noUse = false;
                            if(x.odds >= Math.random()){
                                x.activate(inventory);
                            }
                        }
                    }
                }
            }
            for(Event x : inventory.eventArray){
                if(x instanceof Use && secondWord.endsWith(x.trigger)){
                    noUse = false;
                    x.activate(inventory);
                    break;
                }
            }
            if (noUse){
                if (inventory.itemCheck(secondWord)){
                    for(Item x : inventory.itemArray){
                        if(secondWord.endsWith(x.name)){
                            x.defaultUse(inventory);
                        }
                    }
                }
                else {
                    inventory.display("You don't have the " + secondWord);
                }
            }
        }
        
        public void altDesc(String item, String description){
            itemDesc.put(item, description);
        }
        
        

                
    }
