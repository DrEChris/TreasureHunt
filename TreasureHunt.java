/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class TreasureHunt {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Locations
        //Create test location
        EndGame deadCell = new EndGame("deadCell", 0, "Dead Cell", 0, 20);
        Location blankSpace = new Location("blank Space", -2, "A white room with no doors or windows", 0, 0);
        
        //Create player's Inventory
        Inventory inventory = new Inventory("in you're backpack", -1, "The backpack where you keep your things", 1, 7);
        inventory.makeUp(deadCell, "");
        //Location 1 "road"
        Location road = new Location("You are on the road", 1, "You are on a dirt road that runs north and south. \n"
                + "The road is bordered on the east side by thick woods that run off in either direction as far as you can see. \n"
                + "On the west side of the road a clearing leads off towards a hill. \n"
                + "In that clearing stands a well made of stone and wood.", 1, 5);
        
        
        //Loactaion 2 "Wishing Well"
        Location well = new Location("You are at the wishing well", 2, "You are at a well in the middle of a clearing. \n"
                + "The north and south sides of the clearing are surronded by a deep woods. \n"
                + "To the west is a steep hill. \n"
                + "On the east side of the clearing a road runs through the woods to the north and south.", 2, 5);
        
        //Location 3 "Hill"
        Location hill = new Location("You are on the hill", 3, "You are on top of a steep hill. \n"
                + "To the north and west of you cliffs overlook the ocean. \n"
                + "The hill slopes down to the south where it meets the woods \n"
                + "and to the east where it meets a clearing by a road with a well in it.", 0, 7);
        
        //Location 4 "Sea Cliffs
        Location seaCliff = new Location("You are overlooking the sea cliffs", 4, "You are at the edge of a cliff overlooking the ocean. \n"
                + "Far down below you at the base of the cliff you can see a sandy beach. \n"
                + "You can follow the cliffs to the south or to the north where a lighthouse stands \n"
                + "Opposite the cliffs towards the east is a lonely hill top.", 2, 5);
        
        //Location 5 woodsEdge
        Location woodsEdge = new Location("You are at the edge of woods", 5, "You are at the edge of a deep dark woods. \n"
                + "To the west is a road.  In all other directions the woods get deeper and darker.", 0, 5);
        
        //Location 6 deepWoods
        Location deepWoods = new Location("You are deep in the woods", 6, "You are deep in the woods now and it is very dark. \n"
                + "To the west is some light that must be the edge of the woods. \n"
                + "If you go any deeper into the woods you will surely get lost.", 0, 5);
        
        //Location 7 woodsLost
        Location woodsLost = new Location("You're lost, deep in the woods", 7, "You are deep in the dark woods and completely lost. \n"
                + "You are no longer sure which way is which.", 5, 5);
        
        //Location 8 TreeTops
        Location treeTops = new Location("You have climbed to the tree tops", 8, "You have climbed to the top of the trees.\n"
                + "What an amazing view.", 1, 0);
        
        //Location 9 brokenBridge
        Location brokenBridge = new Location("You are at the broken bridge", 9, "You are on the north side of a mighty river that runs from east to west. \n"
                + "A dirt road leads up to the river from the north to what used to be a bridge. \n"
                + "It appears that the bridge was destroyed in a storm leaving the bridge uncrossable.", 1, 5);
        
        //Location 10 Town
        Location town = new Location("You're in town", 10, "You have arrived at a small town of cute wooden buildings paved in cobblestones.", 0, 0);
        
        //Location 11 Waterfall - top
        Location waterfallTop = new Location("You are at the top of the waterfall", 11, "You are at a large and powerful waterfall. \n"
                + "A mighty river flows in from the east and pours over the cliffs that extend "
                + "off to the north.", 1, 5);
        
        //Location 12 Mine Entrance
        Location mineEntrance = new Location("You are at the entrance to a mine", 12, "You are at an excavated gully along the side of the river. \n"
                + "In the middle of the excavation is the entrance to an old abandoned mine.", 1, 5);
        
        //Location 13 Beach
        Location beach = new Location("You are on a sandy beach", 13, "You are are on a big sandy beach at the base of a towering cliff. \n"
                + "The only things on the beach are a couple of palm trees, sand and soft sound of crashing waves. \n"
                + "The beach extends to the north and south and endless ocean stretches off to the west.", 0, 7);
        
        //Location 14 Shipwreck
        Location shipWreck = new Location("You stand in front of a ship wreck", 14, "A ship has run a ground on some rocks here! \n"
                + "The ship blocks you from going north along the beach, but you could probably \n"
                + "climb onto the deck and explore the wreck. \n"
                + "You can also head south along the beach.", 0, 5);
        
        //Location 15 Tide pools
        Location tidePools = new Location("You are at the tide pools", 15, "You come to a rocky part of the beach that is full of tidal pools. \n"
                + "To the north the beach gets sandy and to the south you can here the roar of a waterfall. \n"
                + "There are steep cliffs boardering the tide pools on the east and "
                + "to the west waves crash against the rocks.", 0, 5);
        
        //Location 16 Lagoon
        Location lagoon = new Location("You are at the lagoon", 16, "You stand on the north side of a large lagoon that is fed by a powerful waterfall. \n"
                + "There is a steep drop into the lagoon covered in \n"
                + "slippery jagged rocks that prevents you from going south. \n"
                + "To the north is the beach and to the east \n"
                + "a small footpath leads around the lagoon towards the waterfall.", 0, 5);
        
        //Location 17 Under the Waterfall
        Location waterfallBottom = new Location("You are under the waterfalls", 17, "You are in a little carved out alcove under the waterfall. "
                + "There is a small cave that appears to be chiseled out of the side of the cliff. \n"
                + "It looks like smugglers have been using this cave as a hideout! A tunnel extends east into the cliffside, "
                + "and a small path leads north out of the waterfall.", 0, 2);
        
        //Location 18 Smugglers Tunnel
        Location smugglersTunnel = new Location("You are in the smugglers tunnel", 18, "You are in a cramped tunnel that runs east and west. \n"
                + "The tunnel appears to have been carved by smugglers. \n "
                + "Dim light and the roaring of falling water come from the west. \n"
                + "To the east is the flickering light of torches.", 0, 3);
        
        //Location 19 Smugglers Cave
        Location smugglersCave = new Location("You are in the smugglers cave", 19, "You enter a large open cave lit with torches. \n"
                + "There are four ways out, tunnels lead to the south and west and smaller caverns lead out of the north and east. \n"
                + "The center of the cave has the remains of a smuggler encampment, a fire pit and some bed rolls", 0, 10);
        
        //Location 20 Underground Spring
        Location undergroundSpring = new Location("You are in an underground spring", 20, "You come to a small underground spring. \n"
                + "Water bubbles up into a natural pool and then flows down a passage to the north.  "
                + "There is a dim sun light coming from that direction. \nThere is also a torch lit passage leading to the South.", 0, 5);
        
        //Location 21 Underground Pools
        Location undergroundPool = new Location("You are at the underground pool", 21, "You are in a small cave with a broad shallow pool taking up most of the floor. \n"
                + "A small trickle of water feeds the pool from a passage that leads south.  \n"
                + "Light streams in through a shaft in the ceiling.", 0, 4);
        
        //Location 22 Smugglers Treasure room
        Location smugglersTrove = new Location("You are in the smugglers treasure trove", 22, "You come around a bend in the small cavern "
                + "and find yourself in a teasure room. \nThere are two treasure chests on the floor. \n"
                + "A small passage leads out to the west.", 3, 6);
        
        //Location 23 LightHouse
        Location lightHouse = new Location("You are outside the light house", 23, "You are outside an abandoned light house. \n"
                + "The light house stands on a point of the cliffs. You can follow the cliffs to the south off the point. \n"
                + "The door to the light house stands open, it's hinges rusted.", 1, 5);
        
        //Location 24 LightHouseRoom
        Location lightHouseRoom = new Location("You are inside the light house", 24, "You are in the store room of the light house. \n"
                + "There is a large metal supply cabinet against one wall. A staircase rises up to the light house tower.", 1, 5);
        
        //Location 25 LightHouseTower
        Location lightHouseTower = new Location("You are in the tower of the light house", 25, "You are in the tower of the light house. \n"
                + "In all directions are large glass windows showing a great view of the ocean. \n"
                + "In the center of the room is a shattered lightbulb, broken glass is all over the floor. \n"
                + "A staircase leads back downstairs.", 0, 3);
        
        //Location 26 Ship Wreck Deck
        Location shipDeck = new Location("The deck of a wrecked ship", 26, "You are on the deck of a ship that has crashed on the beach.\n"
                + "The ships cracked mast rises up above you to the crows nest, a rope ladder hangs down from it.\n"
                + "West of you is the aft of the ship, and the beach lies down the side of the ship", 0, 5);
        
        //Location 27 Ship Deck Aft
        Location aftDeck = new Location("The aft part of the deck", 27, "You are on the aft deck of a ship that has run aground.\n"
                + "A set of stairs leads up to raised helm and another leads down to the shadowy hold below. \n"
                + "Between them is a door. The main deck lies to the east.", 0, 5);
        
        //Location 28 Crows Nest
        Location crowsNest = new Location("The crows nest", 28, "You are in the crows nest, high above the wrecked ship.\n"
                + "The small surface is tilted slightly and creaks and moves precariously in the breaze.\n"
                + "You have a great view for miles around.  The only way down is to climb.", 0, 5);
        
        //Location 29 Helm
        Location helm = new Location("The helm", 29, "You are on the raised helm of the ship.\n"
                + "To the east stairs run down on to the main deck. Waves crash against the side of the ship all around you.\n"
                + "There is a large wheel mounted in the center, to steer the ship.", 0, 5);
        
        //Location 30 Flooded Hold
        Location floodedHold = new Location("The flooded hold", 30, "You are in the large hold of the ship.\n"
                + "The hold has flooded and most of it is underwater. There are stairs leading back up to the deck.", 0, 10);
        
        //Location 31 Captains Quarters
        Location captainsQuarters = new Location("The captains quarters", 31, "You are in the captains quarters./n"
                + "The room is in some disarray, with papers strewn all over the floor.\n"
                + "Bookshelves line one wall and a sleeping cot is built into the other.\n"
                + "There is a writing desk, lit by windows on the west end of the room and a door on the east.", 5, 3);
        
        
        
        //Traveling Directions
        //Road
        road.makeNorth(town, "You head north along the dirt road.");
        road.makeSouth(brokenBridge, "You head South along the dirt road.");
        road.makeWest(well, "You head into the clearing towards the well");
        road.makeEast(woodsEdge, "You leave the trail and head into the woods");
        road.makeException("woods", "east");
        road.makeException("well", "west");
        FastTravel teleportBeach = new FastTravel("teleport to beach", 1, "Do you wish to teleport"
                + " to the beach?", "teleport beach", "zzzzp", "", beach);
        road.eventArray[0] = teleportBeach;
        //Wishing Well
        well.makeNorth(woodsEdge, "You head north into the woods.");
        well.makeSouth(woodsEdge, "You head south into the woods.");
        well.makeWest(hill, "You climb the hill to the west.");
        well.makeEast(road, "You head east onto the dirt road.");
        well.makeUp(hill, "You climb the hill to the west.");
        well.makeDown(well, "climb well");
        well.makeException("road", "east");
        well.makeException("hill", "west");
        well.makeException("woods", "north");
        well.makeClimb("well", undergroundPool, 0.2);
        //Hill
        hill.makeNorth(lightHouse, "You head north towards the cliffs and come apon a light house.");
        hill.makeSouth(deepWoods, "You head down the hill and into the woods.");
        hill.makeWest(seaCliff, "You head out to the edge of the cliffs.");
        hill.makeEast(well, "You head down the hill into the clearing with the well.");
        hill.makeDown(well, "You head down the hill into the clearing with the well.");
        hill.makeException("cliff", "west");
        hill.makeException("well", "east");
        hill.makeException("woods", "south");
        //Sea Cliff
        seaCliff.makeNorth(lightHouse, "You follow the cliffs north toward the light house");
        seaCliff.makeSouth(waterfallTop, "You follow the cliffs south. You hear a roaring which gets loader and loader.");
        seaCliff.makeWest(seaCliff, "A long fall onto some jagged rocks block the way west.");
        seaCliff.makeEast(hill, "You head towards the hill top to the east.");
        seaCliff.makeDown(seaCliff, "climb cliffs");
        seaCliff.makeException("hill", "east");
        seaCliff.makeClimb("cliffs", beach, 0.25);
        seaCliff.makeException("cliff", "down");
        seaCliff.makeException("house", "north");
        //Woods Edge
        woodsEdge.makeNorth(deepWoods, "You head deeper into the woods.");
        woodsEdge.makeSouth(deepWoods, "You head deeper into the woods.");
        woodsEdge.makeWest(road, "You head out of the woods, towards the road.");
        woodsEdge.makeEast(deepWoods, "You head deeper into the woods.");
        woodsEdge.makeException("road", "west");
        woodsEdge.makeException("woods", "east");
        //Deep Woods
        deepWoods.makeNorth(woodsLost, "You head deeper into the woods.");
        deepWoods.makeSouth(woodsLost, "You head deeper into the woods");
        deepWoods.makeWest(woodsEdge, "You head towards the light and the edge of the woods.");
        deepWoods.makeEast(woodsLost, "You head deeper into the woods.");
        deepWoods.makeException("woods", "east");
        //Woods Lost
        woodsLost.makeNorth(woodsLost, "You head in the direction you think is North.");
        woodsLost.makeSouth(woodsLost, "You head in the direction you think is South.");
        woodsLost.makeWest(woodsLost, "You head in the direction you think is West.");
        woodsLost.makeEast(woodsLost, "You head in the direction you think is East.");
        woodsLost.makeUp(treeTops, "climb tree");
        woodsLost.makeClimb("tree", treeTops, 1.0);
        woodsLost.makeException("tree", "up");
        //Tree Tops
        treeTops.makeDown(woodsLost, "You climb back down into the woods.");
        treeTops.makeException("woods", "down");
        treeTops.makeClimb("tree", woodsLost, 1.0);
        //Broken Bridge
        brokenBridge.makeNorth(road, "You head north up the dirt road.");
        brokenBridge.makeSouth(brokenBridge, "The bridge has collapsed making it impossible to get to the other side.");
        brokenBridge.makeWest(waterfallTop, "You follow the river west. Soon you approach a cliff and can hear the roar of a waterfall.");
        brokenBridge.makeEast(mineEntrance, "You follow the river upstream. Gradually the terrain becomes less wooded and more rocky.");
        brokenBridge.makeException("road", "north");
        
        //Town
        town.makeNorth(town, "The town blocks North, East and West.  You can follow the road South.");
        town.makeSouth(road, "You head south along the road.");
        town.makeWest(town, "The town blocks North, East and West.  You can follow the road South.");
        town.makeEast(town, "The town blocks North, East and West.  You can follow the road South.");
        town.makeException("road", "south");
        //Top of the Waterfall
        waterfallTop.makeNorth(seaCliff, "You follow the cliffs to the north, leaving the roar of the waterfall behind.");
        waterfallTop.makeSouth(waterfallTop, "There is no way to get across the river here, you would be "
                + "swept over the falls and killed.");
        waterfallTop.makeWest(waterfallTop, "The falls block the way west");
        waterfallTop.makeEast(brokenBridge, "You follow the river east, away from the falls.");
        waterfallTop.makeDown(waterfallTop, "There is no way you could get down those falls alive...");
        waterfallTop.makeException("cliffs", "north");
        //Mine Entrance
        mineEntrance.makeSouth(mineEntrance, "The river blocks your way south and it is quite uncrossable.");
        mineEntrance.makeWest(brokenBridge, "You head west along the river.");
        mineEntrance.makeEast(mineEntrance, "You head down into the mine. \n"
                + "There is a sign that say 'Mine under construction, please come back'");
        mineEntrance.makeDown(mineEntrance, "You head down into the mine. \n"
                + "There is a sign that say 'Mine under construction, please come back'");
        mineEntrance.makeException("mine", "down");
        mineEntrance.makeException("river", "west");
        //Beach
        beach.makeNorth(shipWreck, "You walk north along the beach. \n"
                + "As you come around a point you suddenly come apon a massive shipwreck.");
        beach.makeSouth(tidePools, "You head south along the beach");
        beach.makeUp(beach, "climb cliffs");
        beach.makeException("ship", "north"); 
        beach.makeException("pools", "south");
        beach.makeClimb("cliffs", seaCliff, 0.25);
        beach.makeException("cliffs", "up");
        //Tide Pools
        tidePools.makeNorth(beach, "You walk north along the beach.");
        tidePools.makeSouth(lagoon, "You head south past the tide pools.");
        //Lagoon
        lagoon.makeNorth(tidePools, "You head north along the beach away from the lagoon.");
        lagoon.makeEast(waterfallBottom, "You head along the small footpath. \n"
                + "It twists around the lagoon and then leads you right in under the falls.");
        lagoon.makeSouth(lagoon, "A slippery fall through some jagged rocks and into the lagoon block the way South.");
        lagoon.makeDown(lagoon, "The slippery slope and jagged rocks make a descent into the lagoon impossible.");
        //Under the Waterfall
        waterfallBottom.makeEast(smugglersTunnel, "You head down into the tunnel.");
        waterfallBottom.makeDown(smugglersTunnel, "You head down into the tunnel.");
        waterfallBottom.makeNorth(lagoon, "You follow the path out from behind the waterfall.");
        waterfallBottom.makeWest(lagoon, "You follow the path out from behind the waterfall.");
        waterfallBottom.makeException("path", "west");
        waterfallBottom.makeException("cave", "east");
        waterfallBottom.makeException("tunnel", "east");
        //Smuggler's Tunnel
        smugglersTunnel.makeEast(smugglersCave, "You head east along the tunnel.");
        smugglersTunnel.makeWest(waterfallBottom, "You head west towards the growing roar of a waterfall. \n"
                + "Abruptly the tunnel ends.");
        //Smugglers Cave
        smugglersCave.makeNorth(undergroundSpring,"You go through the opening to the north and into a small cavern.");
        smugglersCave.makeWest(smugglersTunnel, "You duck into the small tunnel to the West.");
        smugglersCave.makeSouth(smugglersCave, "You can't go that way yet... it is still under construction.");
        smugglersCave.makeEast(smugglersTrove, "You squeeze though a small passage that twists and turns to the east.");
        //Underground Spring
        undergroundSpring.makeNorth(undergroundPool, "You follow the water through the opening to the north.");
        undergroundSpring.makeSouth(smugglersCave, "You head through the opening to the south.");
        //Underground Pool
        undergroundPool.makeSouth(undergroundSpring, "You head into the cavern to the south.");
        undergroundPool.makeUp(well, "climb well");
        undergroundPool.makeClimb("well", well, 0.2);
        undergroundPool.makeException("well", "up");
        //Smugglers Treasure room
        smugglersTrove.makeWest(smugglersCave, "You squeeze through a small passage that twists and turns west");
        //Light House
        lightHouse.makeSouth(seaCliff, "You head south along the sea cliffs.");
        FastTravel enterLightHouse = new FastTravel("Enter Lighthouse", 1, "Do you want to enter the "
                + "abandoned structure?", "go house", "You enter the light house", "That light house"
                        + "looks dangerous, better not go in.", lightHouseRoom);
        lightHouse.eventArray[0] = enterLightHouse;
        enterLightHouse.aka("go door");
        enterLightHouse.aka("go in");
        enterLightHouse.aka("go inside");
        //Light House Room
        lightHouseRoom.makeUp(lightHouseTower, "You climb the stairs up to the top of the tower.");
        lightHouseRoom.makeException("stairs", "up");
        lightHouseRoom.makeException("tower", "up");
        lightHouseRoom.makeClimb("stairs", lightHouseTower, 1.0);
        FastTravel exitLightHouse = new FastTravel("Leave LightHouse", 1, "Are you done exploring"
                + " the lighthouse?", "go outside", "You leave the lighthouse", "You stay in the lighthouse", lightHouse);
        lightHouseRoom.eventArray[0] = exitLightHouse;
        exitLightHouse.aka("go out");
        exitLightHouse.aka("go house");
        exitLightHouse.aka("go door");
        //Light House Tower
        lightHouseTower.makeDown(lightHouseRoom, "You climb down the stairs");
        lightHouseTower.makeClimb("stairs", lightHouseRoom, 1.0);
        lightHouseTower.makeException("stairs", "down");
        //Ship Wreck
        shipWreck.makeSouth(beach, "You head south towards the beach");
        shipWreck.makeClimb("ship", shipDeck, 0.85);
        shipWreck.makeUp(shipDeck, "climb ship");
        shipWreck.makeException("ship", "up");
        //Ship Deck
        shipDeck.makeClimb("ship", shipWreck, 0.85);
        shipDeck.makeDown(shipWreck, "climb ship");
        shipDeck.makeWest(aftDeck, "You head west towards the aft end of the ship.");
        shipDeck.makeClimb("nest", crowsNest, 0.75);
        shipDeck.makeClimb("mast", crowsNest, 0.75);
        shipDeck.makeClimb("ladder", crowsNest, 0.75);
        shipDeck.makeUp(crowsNest, "climb nest");
        //Aft Desk
        aftDeck.makeEast(shipDeck, "You head east towards the front of the ship.");
        aftDeck.makeWest(captainsQuarters, "You open the door and enter the Captains Quarters.");
        aftDeck.makeUp(helm, "You climb up to the helm.");
        aftDeck.makeDown(floodedHold, "You climb down the stairs into the dark hold.");
        aftDeck.makeException("upstairs", "up");
        aftDeck.makeException("up the stairs", "up");
        aftDeck.makeException("helm", "up");
        aftDeck.makeException("downstairs", "down");
        aftDeck.makeException("down the stairs", "down");
        aftDeck.makeException("hold", "down");
        aftDeck.makeException("door", "west");
        //Crows Nest
        crowsNest.makeClimb("deck", shipDeck, 0.75);
        crowsNest.makeClimb("mast", shipDeck, 0.75);
        crowsNest.makeClimb("ladder", shipDeck, 0.75);
        crowsNest.makeDown(shipDeck, "climb deck");
        //Helm
        helm.makeEast(aftDeck, "You climb down the stairs to the main deck.");
        helm.makeDown(aftDeck, "You climb down the stairs to the main deck.");
        helm.makeException("deck", "east");
        helm.makeException("downstairs", "down");
        helm.makeException("down the stairs", "down");
        //Flooded Hold
        floodedHold.makeUp(aftDeck, "You climb up out of the hold.");
        floodedHold.makeException("upstairs", "up");
        floodedHold.makeException("up the stairs", "up");
        floodedHold.makeException("deck", "up");
        //Captains Quarters
        captainsQuarters.makeEast(aftDeck, "You head through the door to the deck.");
        captainsQuarters.makeException("door", "east");
        captainsQuarters.makeException("deck", "east");
        
        
         //Items
        //Item arrays hold the items in each location.
        //Different locations can hold different amounts of items.
        Item rope = new Item("rope", " large coil of rope", 2, false, "cabinet", "You play jump rope. \n"
                + " 1.. 2.. 3.. damn. \n I guess you're not very good at jump rope.");
        lightHouseRoom.itemArray[0] = rope;
        
        Item battery = new Item("battery", " large heavy battery", 50, false, "cabinet", "You probably shouldn't play with that... \n"
                + "Electric shocks hurt.");
        lightHouseRoom.itemArray[1] = battery;
        
        Item lantern = new Item("lantern", " small gas lantern", 5, true, "none", "The lantern shines a bright yellow light.");
        brokenBridge.itemArray[0] = lantern;
        
        Item pirateKeys = new Item("keys", " small, old looking set of keys.", 5, false, "pools", "You jingle the keys, "
                + "some rust falls off ... ");
        tidePools.itemArray[0] = pirateKeys;
        
        Item emerald = new Item("emerald", " large shimmering emerald", 100, true, "none", "You admire the beutiful emerald");
        
        Item ruby = new Item("ruby", " beautiful ruby", 100, true, "none", "You stare deep into the depths of the ruby.");
        
        Item sapphire = new Item("sapphire", "n amazingly pure sapphire", 100, true, "none", "You polish the sapphire.");
        
        Item goldScepter = new Item("gold scepter", " bejewled golden "
                + "scepter", 150, true, "none", "You wave the golden scepter and make proclamations.");
        
        Item mushrooms = new Item("mushrooms", " bunch of toadstool mushrooms", 1, true, "none", "You taste a peice of mushroom. \n"
                + "Yuck!");
        
        Item wildFlowers = new Item("wild flowers", " bunch of pretty flowers", 1, true, "none", "You"
                + " stop to smell the flowers. \nHow nice.");
        
        Item pinecones = new Item("pinecone", " nice large pinecone", 1, true, "none", "You try to count the "
                + "nubs on the pinecone and get your hands sticky.");
        
        Item compass = new Compass("compass", " shiney golden compass", 75, true, "none", "none");
        captainsQuarters.itemArray[0] = compass;
        captainsQuarters.altDesc("compass", "There is a shiney golden compass sitting on the desk.");
        
        Item barrel = new Item("barrel", " plain wooden barrel", 10, true, "none", "");
        floodedHold.itemArray[0] = barrel;
        floodedHold.altDesc("barrel", "An empty barrel is floating in the water.");
        brokenBridge.itemArray[1] = barrel;
        
        
        //Events
        //Event Arrays holds an array of events for each location.
        
        //Wishing Well events
        
        
        ChangeLocation wellTOn = new ChangeLocation("tie rope to well", 1, "Now you can use the rope "
                + "to climb down into the well and search for treasure.", "none", well, "climb", "odds");
        ChangeLocation wellBOn = new ChangeLocation("tie rope to well", 1, "", "none", undergroundPool, "climb", "odds");
        wellTOn.setNumber(0.9);
        wellTOn.setString("well");
        wellBOn.setNumber(0.9);
        wellBOn.setString("well");
        
        Split wellOn = new Split("tie rope to well", 1, "", "none", wellTOn, wellBOn);
        
        Use ropeOnWell = new Use("tie rope to well", 1, "You tie the rope to the well, it "
                + "drops down and out of sight.", "rope", rope, wellOn, true, "well");
        well.eventArray[0] = ropeOnWell;
        
        ChangeLocation wellTOff = new ChangeLocation("take rope from well", 1, "", "none", well, "climb", "odds");
        ChangeLocation wellBOff = new ChangeLocation("take rope from well", 1, "", "none", undergroundPool, "climb", "odds");
        wellTOff.setNumber(0.2);
        wellTOff.setString("well");
        wellBOff.setNumber(0.2);
        wellBOff.setString("well");
        
        Split ropeOffWell = new Split("take rope from well", 1, "Taking the rope will "
                + "make climbing the well almost impossible.", "get rope", wellTOff, wellBOff);
        well.eventArray[1] = ropeOffWell;
        
        //Lost in the woods events
        ClearItems freshWoods = new ClearItems("Refresh the woods", 1, "None", "arrival");
        woodsLost.eventArray[0] = freshWoods;
        LoadItem mushroomsHere = new LoadItem("Mushrooms in woods", 0.2, "There are mushrooms growing here.", "arrival", 0);
        woodsLost.eventArray[1] = mushroomsHere;
        mushroomsHere.fillStash(mushrooms);
        mushroomsHere.makeReloading();
        LoadItem wildFlowersHere = new LoadItem("Wild Flowers in woods", 0.2, "There are wild flowers growing here.", "arrival", 0);
        woodsLost.eventArray[2] = wildFlowersHere;
        wildFlowersHere.fillStash(wildFlowers);
        wildFlowersHere.makeReloading();
        LoadItem pineconesHere = new LoadItem("Pinecones in woods", 0.2, "There are pinecones laying on the ground here.", "arrival", 0);
        woodsLost.eventArray[3] = pineconesHere;
        pineconesHere.fillStash(pinecones);
        pineconesHere.makeReloading();
        FastTravel peddler = new FastTravel("Traveling Peddler", 0.2, "A Travelling peddler happens by. \n"
                + "He knows a way through the woods to town and offers you a ride. \n"
                + "Would you like to go with him?", "arrival", "You go with the peddler, who takes a winding \n"
                        + "and completely confusing route through the woods and drops you off in front of a little town.",
                "You thank the peddler, but choose to remain in the woods", town);
        woodsLost.eventArray[4] = peddler;
        
        
        
        //Tree top events
        FastTravel seeTown = new FastTravel("See Town", 1, "From up here you can see a town off in the distance. \n"
                + "Would you like to travel directly to that town?", "arrival", 
                "Now that you know where the town is you head straight there.", 
                "You choose to stay here in the woods.", town);
        treeTops.eventArray[0] = seeTown;
        
        //Sea cliff events
       
        ChangeLocation cliffTOn = new ChangeLocation("tie rope to the cliff top", 1, "Now the rope will let you"
                + " climb down the cliff.", "none", seaCliff, "climb", "odds");
        ChangeLocation cliffBOn = new ChangeLocation("tie rope to the cliff top", 1, "", "none", beach, "climb", "odds");
        cliffTOn.setNumber(0.9);
        cliffTOn.setString("cliffs");
        cliffBOn.setNumber(0.9);
        cliffBOn.setString("cliffs");
        
        Split cliffOn = new Split("tie rope to the cliff", 1, "", "none", cliffTOn, cliffBOn);
        
        Use ropeOnCliff = new Use("tie rope to the cliff", 1, "You tie the rope to the top of the cliff. \n" 
                + "It hangs down almost to the bottom.", "rope", rope, cliffOn, true, "cliff");
        seaCliff.eventArray[0] = ropeOnCliff;
        
        ChangeLocation cliffTOff = new ChangeLocation("take rope from the cliff", 1, "", "none", seaCliff, "climb", "odds");
        ChangeLocation cliffBOff = new ChangeLocation("take rope from the cliff", 1, "", "none", beach, "climb", "odds");
        cliffTOff.setNumber(0.25);
        cliffTOff.setString("cliff");
        cliffBOff.setNumber(0.25);
        cliffBOff.setString("cliff");
        
        Split ropeOffCliff = new Split("take rope from the cliff", 1, "Taking the rope will "
                + "make climbing the cliff almost impossible.", "get rope", cliffTOff, cliffBOff);
        seaCliff.eventArray[1] = ropeOffCliff;
        
        //Waterfall Top events
        FastTravel barrelRide = new FastTravel("Over the falls", 1, "Do you want "
                + "to use the barrel to cross the river?", "use barrel", 
                "You hop in the barrel and start paddling across.\n"
                        + "But the river's current is too strong, \n "
                        + "and it quickly pulls you down river and over the edge of a waterfall.\n"
                        + "When you wake up you are lying on some rocks at the edge of a lagoon. \n"
                        + "You pull yourself up and look around.", 
                "Might be dangerous, better stay on dry land.", lagoon);
        Use crossWithBarrel = new Use("cross river in barrel", 1, "The barrel floats and you fit in it.\n"
                + "Maybe you can use it to cross the river.", 
            "barrel", barrel, barrelRide, true, "dante");
        brokenBridge.eventArray[0] = crossWithBarrel;
        waterfallTop.eventArray[0] = crossWithBarrel;
        mineEntrance.eventArray[0] = crossWithBarrel;
        
        
        //smugglers trove events
        LoadItem smugglersChest = new LoadItem("Smugglers Treasure Chest", 1, "You open the treasure chest and"
                + " look inside.", "open chest", 200);
        smugglersTrove.eventArray[0] = smugglersChest;
        smugglersChest.fillStash(ruby);
        smugglersChest.fillStash(emerald);
        smugglersChest.fillStash(sapphire);
        
        Use usePirateKeys = new Use("use pirate keys", 1, "You use the keys to unlock the chests. \n"
                + "The first one is already unlocked and empty, but the second is still full.", 
            "keys", pirateKeys, smugglersChest, false, "none");
        smugglersTrove.eventArray[1] = usePirateKeys;
        Event lockedChest = new Event("locked Chest", 1, "The chest is locked. "
                + "The key hole is old and rusted.", "search chest");
        smugglersTrove.eventArray[2] = lockedChest;
        
        //Captains Quarters events
        Event dirtyBook = new Event("dirty book", 1, "You notice that one of the books has dirty finger"
                + "prints on it.", "search bookcase");
        captainsQuarters.eventArray[0] = dirtyBook;
        dirtyBook.aka("search books");
        dirtyBook.aka("search shelves");
        
        LoadItem pirateChest = new LoadItem("Pirate Treasure Chest", 1, "You open "
                + "the treasure chest and look inside.", "open chest", 500);
        pirateChest.fillStash(goldScepter);
        captainsQuarters.eventArray[3] = pirateChest;
        
        Use usePirateKeys2 = new Use("use pirate keys", 0, "You use the keys to "
                + "unlock the chest.", "keys", pirateKeys, pirateChest, false, "none");
        captainsQuarters.eventArray[2] = usePirateKeys2;
        
        ChangeEvent secretTreasure = new ChangeEvent("secret treasure", 1, "You grab the book, but when you pull on it a part of the bookshelve swings open.\n"
                + "Behind it is a secret chamber with a treasure chest in it.", "get book", usePirateKeys2, true, 1, false, "use keys");
        captainsQuarters.eventArray[1] = secretTreasure;
        captainsQuarters.eventArray[4] = lockedChest;
        
        
        //Encounters
        
       
        //Gameplay
       
        inventory.gps.navigate(road);
        road.activate(inventory);
        
    
        
    }
    
}
