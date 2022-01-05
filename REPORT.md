# REPORT
## 一、代码结构分析
### 1.UML类图
#### ![ALT text](/1.png)
### 2.文字说明
#### 部件组成：项目主要由五个类构成
Command:接受用户输入的命令，get方法接收指令，boolean方法判断基础指令和具体指令是否存在

CommandWords:规定基础指令，isCommand()方法判断是否有基础指令，showAll()方法显示所有基础指令

Game:游戏的主类，用户进入游戏后项目执行此类的play()方法开始执行游戏。在初始化Game类对象时执行createRooms()方法来初始化房间，同时初始化加载Parser工具类对象来执行命令解析的操作。

Room: 系统中所有房间的基类，主要包含两个属性 description(房间名称)、exits(房间出口与其它房间的关系)； 

Parser:：解析终端用户输入命令的工具类。和CommandWords类是组合关系。内部主要通过Scanner对象获取用户输入，然后对输入的命令进行解析，仅解析用户输入的前两个单词，第一个单词必须是系统内部可用指令之一，第二个单词表示具体的命令。比如说房间移动命令 go west，就表示启用 go 命令，然后向西方向移动。
#### 各类之间的关系
Game类和Parser类依赖于Command类，Game类关联Parser类和Room类，使Game类知道Parser类和Room类的属性和方法，Parser类关联基础命令类CommandWords,调用相关方法解析命令。UML图中，虚线箭头表示依赖关系，实线表示关联关系
## 二、代码改进
### 将功能方法单独创建类，从Game类里分离开
#### 创建了Command_do接口，do_help,do_quit,do_go功能类实现这个接口
##### ![ALT text](/2.png)
![ALT text](/5.png)
![ALT text](/4.png)
![ALT text](/3.png)
#### 创建了Parser接口，Parsers类实现该接口，使Game类和其他需要使用Parsers里面方法的类依赖于接口。
![ALT text](/6.png)
![ALT text](/7.png)
## 三、功能扩展
### 1.look-实现查询房间内物品功能
![ALT text](/8.png)
功能展示：
![ALT text](/9.png)
### 2.transcend-实现传送到基础房间的功能（基础房间可设定，不止一个）
![ALT text](/10.png)
功能展示：
![ALT text](/11.png)
### 3.back-实现返回上一个房间，可重复back，直到回到初始房间
![ALT text](/12.png)
功能展示：
![ALT text](/13.png)
## 四、单元测试用例
### 1.do_backTest
testGetcurrentroom:  //返回功能测试
![ALT text](/14.png)
### 2.do_transcendTest  
testGetcurrentroom:  //传输功能测试
![ALT text](/15.png)
### 3.do_quitTest 
testdosomething:  //退出游戏功能测试
![ALT text](/16.png)
### 4.测试结果
![ALT text](/17.png)