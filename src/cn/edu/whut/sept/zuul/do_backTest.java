package cn.edu.whut.sept.zuul;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class do_backTest {

	@Test
	public void testGetcurrentroom() {
		Command command = new Command("back",null);
		Stack<Room> stack = new Stack<Room>(); 
		ArrayList<object> Obj = null;
		
		Room theaterroom =new Room("theater","in a lecture theater",Obj);
		stack.add(theaterroom);
		
		Room Pub = new Room("pub","in the campus pub",Obj);
		do_back Do = new do_back(command,Pub,stack);
		
		Do.dosomething();
		Room actual = Do.getcurrentroom();
		Room expected = theaterroom;
		
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

}
