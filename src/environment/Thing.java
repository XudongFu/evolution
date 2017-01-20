package environment;
import java.util.ArrayList;


/**
 * �����Ǳ�������{@code Negetivefun}������{@code Attri}�ļ���
 * @author ����
 *
 */
public class Thing implements Cloneable {

	World world;

	ArrayList<Attri> attris = new ArrayList<>();

	ArrayList<Negetivefun> functions = new ArrayList<>();

	/**
	 * ��������֣�����һ������
	 */
	private String name;

	/**
	 * �����id������һ������
	 */
	private String id;

	/**
	 * ָʾ�����ﴦ��ʵ�����ﻹ��ģ������״̬
	 */
	boolean isIntance = false;

	/**
	 * ���ض����Ƿ���ʵ��״̬
	 * 
	 * @return
	 */
	public boolean isIntance() {
		return isIntance;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * ���ö�����ʵ��״̬����ģ��״̬
	 * 
	 * @param isIntance
	 */
	void setIntance(boolean isIntance) {
		this.isIntance = isIntance;
	}

	/**
	 * ����ĳ�����Ե�ֵ��������������ʹ��
	 * @param type
	 * @param value
	 */
	public void setTypeValue(String type, Object value)
	{
		
	}
	
	/**
	 * ��������ӱ�������
	 */
	public void attachNegtiveFun(Negetivefun fun)
	{
		
	}
	
	
	public void attachAttri(Attri attri) {
		
	}
	

	public Thing(World world, String name) {
		this.world = world;
		world.modleThings.add(this);
		this.name = name;
		this.isIntance=false;
	}
	

	protected Thing(String name){
		this.name=name;
	}
	
	
	/**
	 * 
	 * @return �������ʱ�̵�״̬
	 */
	Condition getCondition() {
		return new Condition(this);
	}
	
	
	
	

	/**
	 * 
	 * @param id  �µ������id��û�м�������id��Ψһ�ԣ�Ϊ�˵õ�ȫ��Ψһid��Ч������world��ȡ����ֹ��ͻ
	 * @return
	 */
	public Thing clone(String id) 
	{
		Thing temp=new Thing( this.name);
		temp.world=this.world;
		temp.id=id;
		for(Attri shuxing:this.attris)
		{
			shuxing.clone(temp,shuxing.getType());
		}
		for(Negetivefun fun:functions)
		{
			fun.clone(temp);
		}
		return temp;
	}

	/**
	 * ����������еĺ�������ע��
	 */
	void registerFunToAttri()
	{
		for(Negetivefun fun:functions)
		{
			fun.registerSelf();
		}
	}
	
	
	
}
