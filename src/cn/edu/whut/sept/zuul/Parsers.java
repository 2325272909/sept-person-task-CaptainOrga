package cn.edu.whut.sept.zuul;

import java.util.Scanner;

/**
 * 
* @ClassName: Parsers 
* @Description: 解析类，继承接口IParser  
* @author liumengying
* @date 2022年1月5日 下午3:04:41 
*
 */
public class Parsers implements IParser {

	 private CommandWords commands;
	 private Scanner reader;
	 
	 /**
     * 
     *@Title: Parser
     *@Description: 初始化内部数据
     */
    public Parsers()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 
     * @Title:getCommand
     * @Description:获取用户从终端输入的命令
     * @return 解析后的指令
     */
    public Command getCommand()
    {
        String inputLine;  //输入命令
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

      //获取输入的前两个单词
        Scanner tokenizer = new Scanner(inputLine);  
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();    //获取第一个单词
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();   //获取第二个单词
                
            }
        }
        //note:仅选择用户输入的前两个单词

        if(commands.isCommand(word1)) {
            return new Command(word1, word2);   
        }
        else {
            return new Command(null, word2);  //如果第一个单词不是命令，置为空
        }
    }
    
    public void showCommands() {
		// TODO Auto-generated method stub
    	 commands.showAll();
	}

}
