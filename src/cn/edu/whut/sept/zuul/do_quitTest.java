package cn.edu.whut.sept.zuul;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
* @ClassName: do_quitTest 
* @Description: 测试quit的功能
* @author liumengying
* @date 2022年1月5日 下午5:33:51 
*
 */
public class do_quitTest {

	@Test
	public void testDosomething() {
		Command command = new Command("quit","a");
		do_quit Do =new do_quit(command);
		String expectedresult = "flase";
		assertFalse(expectedresult,Do.dosomething());
		 
		//fail("Not yet implemented");
	}

}
