package cn.edu.whut.sept.zuul;

  
import java.util.HashMap;
import java.util.Set;

 /**
  * 
 * @ClassName: object 
 * @Description:  物品类,有get,set的方法获取属性
 * @author liumengying
 * @date 2022年1月5日 下午3:07:04 
 *
  */
public class object {
	
	private String name;
	private String object_description;
	private double weight;
   // private HashMap<object, String> objects;
	
	/**
	 * 初始化
	 * @param decription
	 */
	public object(String decription,String name,double weight)
	{
		this.object_description=decription;
		this.setName(name);
		this.weight=weight;
	 	
	}
	
	/**
	  * 设置物品名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	  * 设置物品重量
	 * @param description
	 */
	public void setDescription(String description)
	{
		 object_description=description;
	}
	 
	 
	/**
	 * 设置物品重量
	 * @param weight
	 */
	public void setWeight(double weight)
	{
		this.weight=weight;
	}
	
	/**
	 * 获取物品重量
	 * @return
	 */
	public double getWeight()
	{
		return weight;
	}
	
	/**
	  * 返回物品名字
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	  * 返回物品描述
	 * @return
	 */
	public String getDescription()
	{
		return object_description;
	}
	
	 
	
	/**
	 * 展示物品信息
	 
	public void showobjects()
	{
		System.out.print(" "+name+":" +object_description+ "  "+weight);
        System.out.println();
	}
    */

}
