package cn.edu.whut.sept.zuul;

public class do_go implements Command_do,Command_getroom{

	private Command command;
	private Room currentRoom;
	public do_go(Command command,Room nextRoom)
	{
		this.command=command;
		this.currentRoom=nextRoom;
	}
	
	/**
	 * 去下一个方向的方法实现
	 */
	@Override
	public boolean dosomething() {
		// TODO Auto-generated method stub
		 if(!command.hasSecondWord()) {
	            // if there is no second word, we don't know where to go...
	            System.out.println("Go where?");
	            return false;
	        }

	        String direction = command.getSecondWord();

	        // Try to leave current room.
	        Room nextRoom = currentRoom.getExit(direction);

	        if (nextRoom == null) {
	            System.out.println("There is no door!");
	        }
	        else {
	            currentRoom = nextRoom;
	            System.out.println(currentRoom.getLongDescription());
	        }
		return false;
	}
	
	/**
	 * 返回当前房间
	 */
	public Room getcurrentroom()
	{
		return currentRoom;
	}

}
