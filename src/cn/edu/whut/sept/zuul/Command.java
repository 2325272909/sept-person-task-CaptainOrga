 /**
 * @Title Command
 * @Description 用来接受用户输入的指令
 */
package cn.edu.whut.sept.zuul;

public class  Command
{
    private String commandWord;  //基础指令
    private String secondWord;   //具体指令

    /**
     * @Title:Command
     * @Description:接收指令
     * @param firstWord
     * @param secondWord
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * @Title getCommandWord
     * @Description 返回基础指令
     * @return commandWord
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @Title getSecondWord
     * @Description 返回具体指令
     * @return secondWord
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @Title isUnknown
     * @Description 判断是否有基础指令
     * @return 第一个单词为空，返回true，否则返回false
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @Title hasSecondWord
     * @Description 判断是否有具体指令
     * @return 第二个单词不为空，返回true,否则返回false
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}