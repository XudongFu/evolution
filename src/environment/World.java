package environment;
import java.util.ArrayList;

/**
 * @date  2016/08/28
 * @version evolution 2.0
 * @author 付旭东  
 */
public final class World {
	/**
	 * 世界的名字
	 */
	private String name;

	/**
	 * 存在的实例事物
	 */
    ArrayList<Thing> intanceThings = new ArrayList<>();

	/**
	 * 世界可以使用的模型事物
	 */
	ArrayList<Thing> modleThings = new ArrayList<>();

	/**
	 * 世界的主动函数，可以某种程度上破坏事物本身的规则进行运作
	 */
	ArrayList<PositiveFun> zhudonghanshu = new ArrayList<>();

	/**
	 * 关于是否需要进行对世界的运行进行记录的变量
	 */
	boolean isRecord;

	/**
	 * 
	 * @return 返回是否需要对世界的运行进行记录
	 */
	public boolean isRecord() {
		return isRecord;
	}

	/**
	 * 改变世界是否需要进行记录
	 * 
	 * @param isRecord
	 */
	public void setRecord(boolean isRecord) {
		this.isRecord = isRecord;
	}

	/**
	 * 记录世界的变化过程，支持并发操作
	 */
	Way routin;

	/**
	 * 世界的目标
	 */
	Condition ambition;

	public String getName() {
		return name;
	}

	public World(String name) {
		this.name = name;
	}
	
	
	public void addIntanceThingFromModel(String name,String id) {
		for(Thing shiwu:modleThings)
		{
			if(shiwu.getName().equals(name))
			{
				Thing temp=shiwu.clone(id);
				intanceThings.add(temp);
				temp.isIntance=true;	
				break;
			}
		}
	}

	/**
	 * 启动世界的运行
	 */
	public void start() 
	{
		boolean happen = false;
		do {
			happen=false;
			for (Thing shiwu : intanceThings) {
				for (Negetivefun fun : shiwu.functions) {
					if (fun.check.check(fun)) {
						happen = true;
						fun.doIt();
					}
				}
			}
		} while (happen);
	}

	/**
	 * 重新启动世界的运行，一般在主动函数参与后造成不可预知的影响
	 */
	public void reStart() {

	}

	Thing getThingFromAddress(Address address) 
	{
		
		return null;
	}

	/**
	 * 暂停世界的运行
	 */
	public void pause() {

	}

	/**
	 * 结束世界的运行，所有的数据将会被删除
	 */
	public void end() {

	}
	
	/**
	 * 标识世界运行时间的机制。
	 */
    @SuppressWarnings("unused")
	private int time=0;
	
	
	
	public void addModleThing(Thing shiwu) 
	{
		shiwu.world=this;
		modleThings.add(shiwu);
	}
	
	/**
	 * 	为事物的提供ID所属性，每添加一个事物的实例，id值就加1，
	 */
	int idStartPoint=1;
	
	public String getFreeId()
	{
		return String.valueOf(idStartPoint++);
	}
	

	/**
	 * @param name 要获取的事物的名称
	 * @param id   事物将要被设置的id，
	 * @return   返回制定name和id事物的实例
	 */
	public Thing getIntanceThingOfName(String name, String id) 
	{
		for (Thing shiwu : modleThings) {
			if (shiwu.getName().equals(name)) {
				Thing tempThing =shiwu.clone(id);
				tempThing.setId(id);
				tempThing.isIntance = true;
				intanceThings.add(tempThing);
				registerAllThing();
				return tempThing;
			}
		}
		throw new ThingNotFoundException("name为" + name + "的事物没有被找到");
	}
	
	
	/**
	 * 连接属性指向函数的连线
	 */
	private void registerAllThing() 
	{
		for(Thing shiwu:intanceThings)
		{
			shiwu.registerFunToAttri();
		}
	}
	
	
	
	
	

}
