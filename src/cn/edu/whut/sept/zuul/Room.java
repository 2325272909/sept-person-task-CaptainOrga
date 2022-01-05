
package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

 
/**
 * 
* @ClassName: Room 
* @Description:  房间类，包含get,set属性的方法和对物品的相关操作
* @author liumengying
* @date 2022年1月5日 下午3:03:44 
*
 */
public class Room
{
	 
    private String description;  //房间描述
    private HashMap<String, Room> exits;   //相邻房间
    private String name;
    ArrayList<object> objects =new ArrayList<>(); // 初始化
     
    /**
     * @Title:Room
     * @param description 
     * @Description:初始化 
     */
    public Room(String name,String description,ArrayList<object> roomObject)
    {
    	this.name=name;
    	this.objects=roomObject;
        this.description = description;
        exits = new HashMap<>(); 
        
    }
        
    /**
         * 获得房间名字 
     */
    public String getname()
    {
    	return name;
    }
    
    
    
    /**
     * 
    * @Title: showallobjects 
    * @Description: 展现所有的物品
    * void
    * @throws (没有异常抛出)
     */
     public void showallobjects()
    {
    	int j = objects.size();
    	if(j==0)
    	{
    		System.out.println("该房间没有物品");
    	}
    	else
    	{
    		for (int i = 0; i < j; i++) {
    	          System.out.println(" "+objects.get(i).getName()+" :"+objects.get(i).getWeight()+" "+objects.get(i).getDescription());
    	        	    	
    	        }
    	}
         
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
     * 
    * @Title: getShortDescription 
    * @Description: 获取房间的简短描述
    * @return
    * String
    * @throws (没有异常抛出)
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
     * 
    * @Title: getExitString 
    * @Description: 输出当前可走方向
    * @return
    * String
    * @throws (没有异常抛出)
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
     * 
    * @Title: getExit 
    * @Description:  获取该房间的特定方位的房间
    * @param direction
    * @return
    * Room
    * @throws (没有异常抛出)
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
 	 
     
    /**
     * 
    * @Title: lookobject 
    * @Description: TODO 查找并展现单个物品
    * @param obj
    * void
    * @throws (没有异常抛出)
     */
    public void lookobject(String obj)
    {
    	int j = objects.size();
    	int i;
        for (i = 0; i < j; i++) {
        	if(objects.get(i).getName().equals(obj))
        		 System.out.println(" "+objects.get(i).getName()+" :"+objects.get(i).getWeight()+" "+objects.get(i).getDescription());
        	
        }
        if(i>j)
        {
        	System.out.println("please assure your selected object");
        }
    } 
}
