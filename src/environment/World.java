package environment;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
     * 建立Id 和事物之间的键值对
     */
    private Map<String,Thing> intanceThings =new TreeMap<>();
    /**
     * 存在的模型事物
     * 建立name和thing之间的键值对
     */
	private Map<String,Thing> modleThings =new TreeMap<>();
    /**
     * 已经建立链接的其他世界，这个仍然在考虑之中，以后或许不用这个了
     */
    private ArrayList<World> linkedWorld = new ArrayList<>();
	/**
	 * 世界的主动函数，可以某种程度上破坏事物本身的规则进行运作
	 */
    private ArrayList<PositiveFun> zhudonghanshu = new ArrayList<>();
	/**
	 * 关于是否需要进行对世界的运行进行记录的变量
	 */
    boolean isRecord;
    /**
     * 记录世界的变化过程，支持并发操作
     */
    private Way routin;
    /**
     *当前要达到的目标
     */
    private Condition ambition;
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

	public String getName() {
		return name;
	}

    public World(String name) {
        this.name = name;
    }

    /**
     *  使用模型事物生成实例事物
     * @param name
     * @param id
     */
    //这里应该建立一个字典才对的。
	public void addIntanceThingFromModel(String name,String id) {
	    Thing temp= modleThings.get(name).clone(id);
        temp.isIntance=true;
        intanceThings.put(id,temp);
	}
	/**
	 * 启动世界的运行
	 */
	public void start() {
		boolean happen = false;
		do {
		    happen=false;
		    Set<String> res=intanceThings.keySet();
		    for (String s:res)
            {
                Thing shiwu=intanceThings.get(s);
                for (Negetivefun fun : shiwu.functions) {
                    if (fun.check.check(fun)) {
                        happen = true;
                        fun.doIt();
                    }}
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


    /**
     * 向世界中添加模型事物
     * @param modleThing
     */
	public void attachModleThing(Thing modleThing)
	{
		modleThing.world=this;
	    modleThings.put(modleThing.getName(),modleThing);
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
     *
     *
	 */
	public Thing getIntanceThingOfName(String name, String id) {
	    Thing temp=modleThings.get(name).clone(id);
	   temp.isIntance=true;
	    intanceThings.put(id,temp);
	    registerAllThing();
	    return temp;
	}


	public ArrayList<Attri> getAttris(Address dizhi) {
        ArrayList<Attri> res=new ArrayList<>();
	    if(dizhi.id.equals("")==false) {
            Thing thing= intanceThings.get(dizhi.id);
            for (Attri s:thing.attris) {
                if(s.getName().equals(dizhi.attriName))
                    res.add(s);
            }
        }
        else {
	        Set<String> key=intanceThings.keySet();
	        for(String k:key) {
                if(intanceThings.get(k).getName().equals(dizhi.name)) {
                    for (Attri s:intanceThings.get(k).attris) {
                        if(s.getName().equals(dizhi.attriName))
                            res.add(s);
                    }
                }}
        }
        return res;
    }

	/**
	 * 连接属性指向函数的连线
	 */
	private void registerAllThing() {
        Set<String> res = intanceThings.keySet();
        for (String s : res) {
            intanceThings.get(s).registerFunToAttri();
        }
    }
}
