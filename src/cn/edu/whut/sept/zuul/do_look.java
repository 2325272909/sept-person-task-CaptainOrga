package cn.edu.whut.sept.zuul;

/**
 * 执行命令接口
 * @author liumengying
 *
 */
public class do_look implements Command_do {

	private Command command;
	private Room currentRoom;
	
	/**
	  * 构造函数
	 * @param nextroom
	 * @param command
	 */
	do_look(Room nextroom,Command command)
	{
			this.currentRoom = nextroom;
			this.command = command;
	}
	
	 /**
	    * 产看物品的方法
	  * @return
	  * @see cn.edu.whut.sept.zuul.Command_do#dosomething()
	  */
	@Override
	public boolean dosomething() {
		 
		 
		 if(!command.hasSecondWord()) {
	            // if there is no second word, we want to look all objects 
			    currentRoom.showallobjects();
	            return false;
	        }
		 else
		 {
			 //查看具体物品
			 currentRoom.lookobject(command.getSecondWord());
			 return false;
		 }
	        
	}
	 
}
