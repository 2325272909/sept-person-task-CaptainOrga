package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

/**
 * 
* @ClassName: do_transcend 
* @Description: 传输功能类
* @author liumengying
* @date 2022年1月5日 下午10:48:35 
*
 */
public class do_transcend implements Command_do,Command_getroom {

	 
	private Command command;
	private Room currentRoom;
	ArrayList<Room> rooms =new ArrayList<>(); // 初始化
	public do_transcend(Command command,ArrayList<Room> room)
	{
		this.command=command;
		this.rooms=room;
	}
	 

	/**
	  * 传送功能
	 * @return
	 * @see cn.edu.whut.sept.zuul.Command_do#dosomething()
	 */
	@Override
	public boolean dosomething() {
		// TODO Auto-generated method stub
				 if(!command.hasSecondWord()) {
			            // if there is no second word, we don't know where to go...
			            System.out.println("transcend where?");
			            return false;
			        }

				    String room_name= command.getSecondWord();
			        // Try to leave current room.
			         
				    Room nextRoom= lookroom(room_name);
			        if (nextRoom == null) {
			            System.out.println("There is no room!");
			        }
			        else {
			            currentRoom = nextRoom;
			            System.out.println(currentRoom.getLongDescription());
			        }
		return false;
	}	 
	
	/**
	 * 寻找room
	 */
	public Room lookroom(String room)
	{
		int j = rooms.size();
        for (int i = 0; i < j; i++) {
        	if(rooms.get(i).getname().equals(room))
        		return rooms.get(i);
        	 
        }
        return null;
	}
	
    /**
         * 返回当前房间
     * @return
     * @see cn.edu.whut.sept.zuul.Command_getroom#getcurrentroom()
     */
	public Room getcurrentroom()
	{
		 
		return currentRoom;
		
	}
 
}
