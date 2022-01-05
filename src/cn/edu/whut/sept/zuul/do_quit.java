package cn.edu.whut.sept.zuul;

public class do_quit implements Command_do {

	private Command command;
	public do_quit(Command command)
	{
		this.command=command;
	}
	@Override
	public boolean dosomething() {
		
		if(command.hasSecondWord()) {
            System.out.println("Quit what?");  
            return false;
        }
        else 
        {
        	System.out.println("Quit !");
        	return true;  // signal that we want to quit
        }   
	}
}
