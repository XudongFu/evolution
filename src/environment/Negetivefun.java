package environment;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author ����
 *
 */
public  class Negetivefun  extends BaseFunction 
{
	ArrayList<Address> src=new ArrayList<>();
	
	/**
	 * ��麯���Ƿ�����
	 */
	 Checkable check;
	
	
	public Negetivefun(Thing thing) 
	{
		super(thing);
		belonged.functions.add(this);
	}
	
	public void setCheck(Checkable check)
	{
		this.check=check;
	}
	
	
	/**
	 * �Ժ����䶯���ܻ������Լ�����������ע���Լ�
	 */
	void registerSelf() {
		for (Address dizhi : src) {
			for (Thing shiwu : world.intanceThings) {
				for (Attri shuxing : shiwu.attris) {
					if (dizhi.equals(shuxing.getAddress())) {
						shuxing.linkedFun.add(this);
					}
				}
			}
		}
	}
	
	
	
	public Negetivefun clone(Thing shiwu) 
	{
		Negetivefun p=new Negetivefun(shiwu);
		p.hanshu=this.hanshu;
		this.desti.forEach((r)->p.desti.add(r));
		this.src.forEach((r)->p.src.add(r));
		p.check=this.check;
		return p;
	}
	
	
	
	private void reallyChange(Map<Attri, Object> canshu) {
		for (Attri shuxing : canshu.keySet()) {
			shuxing.liandong(canshu.get(shuxing));
		}
	}
	
	
	public void doIt() 
	{
		for(Address dest:desti)
		{
			Map<Attri, Object> t=hanshu.function(this,getAttris(dest));
			if(world.isRecord)
			{
				/**
				 * ��¼����ִ�еı仯
				 */
			}
			reallyChange(t);
		}
	}
	
	
	void linkedStart()
	{
	}
	
	
	/**
	 * ��ȡƥ��address������
	 * @param dizhi
	 * @return
	 */
	
	public ArrayList<Attri> getAttris(Address dizhi) {
		ArrayList<Attri> shuxingji = new ArrayList<>();
		for (Thing intance : world.intanceThings) {
			if (dizhi.id.equals("")) {
				if (intance.getName().equals(dizhi.name)) {
					for (Attri shuxing : intance.attris) {
						if (shuxing.getType().equals(dizhi.type))
							shuxingji.add(shuxing);
					}
				}
			} 
			else 
			{
				if (intance.getName().equals(dizhi.name)
						&& intance.getId().equals(dizhi.id)) {
					for (Attri shuxing : intance.attris) {
						if (shuxing.getType().equals(dizhi.type))
							shuxingji.add(shuxing);
					}
				}
			}
		}
		return shuxingji;
	}
	
	
	
}
