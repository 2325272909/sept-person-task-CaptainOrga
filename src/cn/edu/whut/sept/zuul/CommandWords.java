 /**
 * @Title CommandWords
 * @Description 规定基础指令和相关方法
 */
package cn.edu.whut.sept.zuul;

public class CommandWords
{
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    /**
     * @Title CommandWords
     * 
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * @Title isCommand
     * @Description 判断第一个单词是否是基础指令
     * @param aString
     * @return 如果第一个单词是基础指令，返回true,否则返回false
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
    
    /**
     * @Title showAll
     * @Description help功能显示可用基础指令
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
 
 