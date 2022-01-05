package cn.edu.whut.sept.zuul;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class do_transcendTest {

	/**
	 * 
	* @Title: testGetcurrentroom 
	* @Description: 测试传送功能的传参函数
	* void
	* @throws (没有异常抛出)
	 */
	@Test
	public void testGetcurrentroom() {
		Command command = new Command("transcend","outside");
		ArrayList<Room> room = new ArrayList<>();
		ArrayList<object> Obj = null;
		Room outside,theater,pub,lab,office,tran_room;
        // create the rooms
		 //初始化房间，添加进ArrayList容器
         outside = new Room("outside","outside the main entrance of the university",Obj);
         theater = new Room("theater","in a lecture theater",Obj);
         pub = new Room("pub","in the campus pub",Obj);
         lab = new Room("lab","in a computing lab",Obj);
         office = new Room("office","in the computing admin office",Obj);
		room.add(office);
        room.add(theater);
        room.add(outside);
        room.add( pub);
        room.add(lab);
		 
		 
		do_transcend T = new do_transcend(command,room);
		
		T.dosomething();
		Room actual = T.getcurrentroom();
		Room expected = outside;
		
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

}
