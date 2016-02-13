public class Room {
	public Furnishing furnishing;
	public String description;
	public Room south_room;
	public Room north_room;
	public DoorDescription north_room_door_description;
	public DoorDescription south_room_door_description;
	public Item item;
	private boolean isTest = false;
	
	public String getFurnishing() {
		if (furnishing != null)
			return furnishing.getName();
		return null;
	}
	
	public boolean setTestStatus(boolean status) {
		
		this.isTest = status;
		return true;
	}
	
	public boolean getTestStatus() {
		return this.isTest;
	}
	
	public boolean setFurnishing(String furnishing) {
		if (furnishing == null) return false;
		this.furnishing = new Furnishing(furnishing);
		return true;
	}

	public String getDescription() {
		return description;
	}
	public boolean setDescription(String description) {
		if (description == null) return false;
		this.description = description;
		return true;
	}
	public Room getSouth_room() {
		return south_room;
	}
	public boolean setSouth_room(Room south_room, String south_room_description) {
		
		if (south_room == null || south_room_description == null) return false;
		
		this.south_room = south_room;
		DoorDescription newDescription = new DoorDescription(south_room_description);
		this.south_room_door_description = newDescription;
		
		return true;
	}
	
	public Room getNorth_room() {
		return north_room;
	}
	public boolean setNorth_room(Room north_room, String north_room_description) {
		
		if (north_room == null || north_room_description == null) return false;
		
		this.north_room = north_room;
		DoorDescription newDescription = new DoorDescription(north_room_description);
		this.north_room_door_description = newDescription;
		return true;
	}
	public DoorDescription getNorth_room_door_description() {
		return north_room_door_description;
	}
	public DoorDescription getSouth_room_door_description() {
		return south_room_door_description;
	}

	public Item getItem() {
		return item;
	}
	public boolean setItem(String item) {
		if (item == null) return false;
		Item newItem = new Item(item);
		this.item = newItem;
		return true;
	}
	
	public void printRoomInfo(Room currentRoom) {
		
		System.out.println("You see a " + currentRoom.description + " room.");
		System.out.println("It has a " + currentRoom.getFurnishing() + ".");
			
		if (currentRoom.getNorth_room() != null) 
			System.out.println("A "+ currentRoom.getNorth_room_door_description().description + " door leads North.");
		if (currentRoom.getSouth_room() != null) 
			System.out.println("A "+ currentRoom.getSouth_room_door_description().description + " door leads South.");
	}
	
	public boolean drink(boolean [] haveItems) {
		
		printInventory(haveItems);
		
		boolean hasCream = haveItems[0];
		boolean hasCoffee = haveItems[1];
		boolean hasSugar = haveItems[2];
		
		if (hasCream && hasCoffee && hasSugar) {
		    System.out.println("You drink the beverage and are ready to study!");
			System.out.println("You win!");
			return true;
		}
		else if (hasCream && hasSugar) {
		    System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.");
		    System.out.println("You lose!");
		}
		else if (hasCoffee && hasSugar) {
		    System.out.println("Without cream, you get an ulcer and cannot study.");
			System.out.println("You lose!");
		}
		else if (hasCream && hasCoffee) {
		    System.out.println("Without sugar, the coffee is too bitter. You cannot study.");
			System.out.println("You lose!");
		}
		else if (hasCream) {
		    System.out.println("You drink the cream, but without caffeine, you cannot study.");
			System.out.println("You lose!");
		}
		else if (hasCoffee) {
		    System.out.println("Without cream, you get an ulcer and cannot study.");
			System.out.println("You lose!");
		}
		else if (hasSugar) {
		    System.out.println("You eat the sugar, but without caffeine, you cannot study!");
			System.out.println("You lose!");
		}
		else {
		    System.out.println("You drink the air, as you have no coffee, sugar, or cream.");
		    System.out.println("The air is invigorating, but not invigorating enough. You cannot study.");
		    System.out.println("You lose!");
		}
		   
		return false;
		
	}
	
	public void printInventory(boolean [] haveItems) {
		
		boolean hasCream = haveItems[0];
		boolean hasCoffee = haveItems[1];
		boolean hasSugar = haveItems[2];
		
		
		if (hasCoffee) 
			System.out.println("You have a cup of delicious coffee.");
		else 
			System.out.println("YOU HAVE NO COFFEE!");
	
		if (hasCream) 
			System.out.println("You have some fresh cream.");
		else 
			System.out.println("YOU HAVE NO CREAM!");
		    	
		if (hasSugar) 
			System.out.println("You have some tasty sugar.");
		else 
			System.out.println("YOU HAVE NO SUGAR!");
			
		System.out.println();
	}
	
	
}
