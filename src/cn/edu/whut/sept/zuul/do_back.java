package cn.edu.whut.sept.zuul;

import java.util.Stack;

public class do_back implements Command_do,Command_getroom{

	Command command;
	private Room currentRoom;
	private Stack<Room> stack = new Stack<Room>(); //初始化存储经过房间的栈
	public do_back(Command command,Room currentRoom,Stack<Room> stack)
	{
		this.command  = command;
		this.currentRoom = currentRoom;
		this.stack=stack;
	}
	
	/**
	 * 返回上一个房间的方法
	 */
	@Override
	public boolean dosomething() {
		
		if(command.hasSecondWord()) {
            System.out.println("cant't back there.");  
            return false;
        }
        else 
        {
        	if(stack.isEmpty())
        	{
        		System.out.println("这是初始点，不能返回");  
        	}
        	else
        	{
        		currentRoom=stack.pop();
        		System.out.println(currentRoom.getLongDescription());
        	}
        	 
        	return false;  // signal that we want to quit
        }   
		
		// TODO Auto-generated method stub
		 
	}
	
	/**
	 *更新当前房间
	 */
	public Room getcurrentroom()
	{
		return currentRoom;
	}

}
