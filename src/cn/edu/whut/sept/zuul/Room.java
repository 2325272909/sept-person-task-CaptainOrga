 /**
 * 
 * @ClassName Room
 * @Description 所有房间的基类
 */
package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

 
public class Room
{
    private String description;
    private HashMap<String, Room> exits;

    /**
     * @Title:Room
     * @param description 
     * @Description:初始化 
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * @Title：setExit
     * @Description:设置方向和在该方向的地址
     * @param direction
     * @param neighbor
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @Title:getShortDescription
     * @return
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * @Title:getLongDescription
     * @return
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    
    /**
     * @Title:getExitString
     * @return
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * @Title:getExit
     * @param direction
     * @return
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}
