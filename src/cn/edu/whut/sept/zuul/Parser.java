/**
 * @ClassName Parser
 * @Description 该类是“World-of-Zuul”应用程序的解析命令类
 *              关联 类 CommandWords
 *              该类可以解析用户输入的命令，获取我们需要的命令信息
 * 
 */
package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    /**
     * 
     *@Title: Parser
     *@Description: 初始化内部数据
     */
    public Parser()
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

    /**
     * 
     * @Title:showCommands
     * @Description:显示命令
     */
    public void showCommands()
    {
        commands.showAll();
    }
}