package cn.edu.whut.sept.zuul;

public class do_help implements Command_do {

	private IParser parser;
	//private String command;
	do_help()
	{
		parser=new Parsers();
		//this.command=command;
	}
	
	/**
	 * 实现help的方法
	 */
	public boolean dosomething() {
		// TODO Auto-generated method stub
		System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
		return false;
	}
	public Room getcurrentroom()
	{
		return null;
	}

}
