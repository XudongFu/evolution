package environment;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author 付旭东
 *被动函数
 */
public  class Negetivefun  extends BaseFunction 
{


	/**
	 * 自己要监听的属性变化或者是函数调用，
	 * 只有监听的函数被调用，或者属性被更改，这个函数就会被启动。
	 */
	ArrayList<Address> src=new ArrayList<>();
	
	/**
	 * 检查函数是否启动
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
	 * 对函数变动可能会引发自己启动的属性注册自己
	 * 只能监听自身的属性变化，不能监听其他事物的属性变化，进行响应，
	 * 那函数调用的监听范围又是什么
	 */
	void registerSelf() {
		for (Address dizhi : src) {

			if(dizhi.type==Type.ATTRIBLE) {
				for (Attri shuxing : belonged.attris) {
					if (dizhi.equals(shuxing.getAddress())) {
						shuxing.linkedFun.add(this);
					}
				}
			}
			if(dizhi.type==Type.FUNCTION)
			{
				for(BaseFunction function : belonged.functions) {
					if(function.getAddress().equals(dizhi))
					{
						function.linkedFunction.add(this);
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

	
	public void doIt() 
	{
		for(Address dest:desti)
		{
			//目的属性集合，如果是属性，计算出对属性应该应该做出的改变。
			if(dest.type==Type.ATTRIBLE) {
				Map<Attri, Object> t = hanshu.function(this, getAttris(dest));
				if (world.isRecord) {
					/**
					 * 记录下所执行的变化
					 */
				}
				reallyChange(t);
			}
			//如果是函数的话就直接调用函数，这里有问题，需要再次考虑
			else
			{


			}
		}


	}

	private void reallyChange(Map<Attri, Object> canshu) {
		for (Attri shuxing : canshu.keySet()) {
			shuxing.liandong(canshu.get(shuxing));
		}
	}
	
	void linkedStart()
	{
	}

	/**
	 * 获取匹配address的属性
	 * @param dizhi
	 * @return
	 */
	public ArrayList<Attri> getAttris(Address dizhi) {
		ArrayList<Attri> shuxingji = new ArrayList<>();
		for (Thing intance : world.intanceThings) {
			if (dizhi.id.equals("")) {
				if (intance.getName().equals(dizhi.name)) {
					for (Attri shuxing : intance.attris) {
						if (shuxing.getName().equals(dizhi.attriName))
							shuxingji.add(shuxing);
					}
				}
			} 
			else 
			{
				if (intance.getName().equals(dizhi.name)
						&& intance.getId().equals(dizhi.id)) {
					for (Attri shuxing : intance.attris) {
						if (shuxing.getName().equals(dizhi.attriName))
							shuxingji.add(shuxing);
					}
				}
			}
		}
		return shuxingji;
	}
	
	
	
}
