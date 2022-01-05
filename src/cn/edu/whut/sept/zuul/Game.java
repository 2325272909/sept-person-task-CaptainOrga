/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

 
public class Game
{
    private IParser parser;
    private Room currentRoom;
    ArrayList<Room> room =new ArrayList<>(); // 初始化存储房间的数组 
    private Stack<Room> stack = new Stack<Room>(); //初始化存储经过房间的栈
    /**
     * ]
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game()
    {
        createRooms();
        parser = new Parsers();
       // rooms = new HashMap<>();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms()
    { 
    	//创建物品,并将物品添加到相应房间
    	object tree=new object("there is a big tree","tree",200);
    	object bottle=new object("Movie glasses","bottle",50); 
    	object glass=new object("Movie glasses","glass",2);
		object coke=new object(" drinks","coke",3);
		object popcorn=new object("Popcorn left behind by guests","popcorn",23);
		object flask=new object("An instrument for doing experiments","flask",6);
		object cokthermometere=new object(" Measure the water temperature","cokthermometere",7);
		object pencil =new object("this is a pencil","pencil",10);
		
		
		 ArrayList<object> outsideObj=new  ArrayList<object>();
	     outsideObj.add(tree);
	         
	     ArrayList<object> theaterObj=new  ArrayList<object>();
	     theaterObj.add(coke);
	     theaterObj.add(glass);
	     theaterObj.add(popcorn);
	     
	     ArrayList<object> pubObj=new  ArrayList<object>();
	     pubObj.add(bottle);
	        
	     ArrayList<object> labObj=new  ArrayList<object>();
	     labObj.add(flask);
	     labObj.add(cokthermometere);
	        
	     ArrayList<object> officeObj=new  ArrayList<object>();
	     officeObj.add(pencil);
   
		Room outside,theater,pub,lab,office,tran_room;
        // create the rooms
         outside = new Room("outside","outside the main entrance of the university",outsideObj);
         theater = new Room("theater","in a lecture theater",theaterObj);
         pub = new Room("pub","in the campus pub",pubObj);
         lab = new Room("lab","in a computing lab",labObj);
         office = new Room("office","in the computing admin office",officeObj);
        // tran_room = new Room("in a room can transcend to a place");

         
         room.add(office);
         room.add(theater);
         room.add(outside);
         room.add( pub);
         room.add(lab);
         
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
     
        theater.setExit("west", outside);
         
         
        pub.setExit("east", outside);
        

        lab.setExit("north", outside);
        lab.setExit("east", office);
        
        

        office.setExit("west", lab);
        
        
        
        //transcend.setExit("any",office);

        currentRoom = theater;  // start game outside
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    private boolean processCommand(Command command)
    {
    	 
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        /**
                 * 实现功能的switch-case语句
         */
        switch(commandWord)
        {
        case "help":     //帮助
        	Command_do Help = new do_help();
        	return Help.dosomething();
        	 
        case "go":               //前进功能
        	  stack.push(currentRoom);   //在go之前存储当前房间信息
             do_go Go = new do_go(command,currentRoom);
             boolean want =Go.dosomething();
             currentRoom=Go.getcurrentroom();
            return want;
            
        case "quit":
        	Command_do Quit = new do_quit(command);
        	return Quit.dosomething();
        case "look":                                //查看物品功能，全部和单个
        	Command_do Look =new do_look(currentRoom,command);
	        return Look.dosomething();
        case "transcend":
        	stack.push(currentRoom); //在传送之前存储当前房间信息
        	do_transcend Transcend = new do_transcend(command,room);   //实例化传送方法的对象
        	boolean want1 =Transcend.dosomething();
        	currentRoom= Transcend.getcurrentroom();
        	return want1;
        case "back":
        	do_back Back=new do_back(command,currentRoom,stack);   //返回功能,多次返回
        	wantToQuit=Back.dosomething();
        	return wantToQuit;
        default:
        	 System.out.println("该功能未实现");
        }
        
        
		return wantToQuit;
         
        // else command not recognised.
         
    }

     
}

    