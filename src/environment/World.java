package environment;
import java.util.ArrayList;

/**
 * @date  2016/08/28
 * @version evolution 2.0
 * @author ����  
 */
public final class World {
	/**
	 * ���������
	 */
	private String name;

	/**
	 * ���ڵ�ʵ������
	 */
    ArrayList<Thing> intanceThings = new ArrayList<>();

	/**
	 * �������ʹ�õ�ģ������
	 */
	ArrayList<Thing> modleThings = new ArrayList<>();

	/**
	 * �������������������ĳ�̶ֳ����ƻ����ﱾ��Ĺ����������
	 */
	ArrayList<PositiveFun> zhudonghanshu = new ArrayList<>();

	/**
	 * �����Ƿ���Ҫ���ж���������н��м�¼�ı���
	 */
	boolean isRecord;

	/**
	 * 
	 * @return �����Ƿ���Ҫ����������н��м�¼
	 */
	public boolean isRecord() {
		return isRecord;
	}

	/**
	 * �ı������Ƿ���Ҫ���м�¼
	 * 
	 * @param isRecord
	 */
	public void setRecord(boolean isRecord) {
		this.isRecord = isRecord;
	}

	/**
	 * ��¼����ı仯���̣�֧�ֲ�������
	 */
	Way routin;

	/**
	 * �����Ŀ��
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
	 * �������������
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
	 * ����������������У�һ�������������������ɲ���Ԥ֪��Ӱ��
	 */
	public void reStart() {

	}

	Thing getThingFromAddress(Address address) 
	{
		
		return null;
	}

	/**
	 * ��ͣ���������
	 */
	public void pause() {

	}

	/**
	 * ������������У����е����ݽ��ᱻɾ��
	 */
	public void end() {

	}
	
	/**
	 * ��ʶ��������ʱ��Ļ��ơ�
	 */
    @SuppressWarnings("unused")
	private int time=0;
	
	
	
	public void addModleThing(Thing shiwu) 
	{
		shiwu.world=this;
		modleThings.add(shiwu);
	}
	
	/**
	 * 	Ϊ������ṩID�����ԣ�ÿ���һ�������ʵ����idֵ�ͼ�1��
	 */
	int idStartPoint=1;
	
	public String getFreeId()
	{
		return String.valueOf(idStartPoint++);
	}
	

	/**
	 * @param name Ҫ��ȡ�����������
	 * @param id   ���ｫҪ�����õ�id��
	 * @return   �����ƶ�name��id�����ʵ��
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
		throw new ThingNotFoundException("nameΪ" + name + "������û�б��ҵ�");
	}
	
	
	/**
	 * ��������ָ����������
	 */
	private void registerAllThing() 
	{
		for(Thing shiwu:intanceThings)
		{
			shiwu.registerFunToAttri();
		}
	}
	
	
	
	
	

}
