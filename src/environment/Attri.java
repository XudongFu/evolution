package environment;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public  class Attri 
{
	/**
	 * 所属的事物
	 */
	private Thing belonged;
	/**
	 * 所属的世界
	 */
    World world;
	/**
	 * 属性的类型
	 */
	private String name;

	/**
	 * 这个应该是作为接口使用还是成员变量使用呢？
	 */
	Attriable shuxing;
	/**
	 * 链接的函数，属性变动时候可能去调用的函数，这样的设定也不知道好不好
	 */
	ArrayList<Negetivefun> linkedFun=new ArrayList<>();
	
	public Map<String, Integer> integerMap=new TreeMap<String, Integer>();
	public Map<String, String> stringMap=new TreeMap<>();
	
   public Attri(Thing thing,String name,Attriable shu)
   {
	 this.belonged=thing;
	 world=thing.world;
	 belonged.attris.add(this);
	 this.name =name;
	 this.shuxing=shu;
	 shu.inite(this);
   }
   
   public Object getValue()
   {
	   if(shuxing!=null)
		   return shuxing.getValue(this);
		   throw new RuntimeException("此属性参数有误");
   }
   
   public void setValue(Object change) {
	   if(shuxing!=null)
		   shuxing.setValue(this,change);
		   throw new RuntimeException("此属性参数有误");
   }
   
   
   /**
    * 
    * @param change
    */
   void liandong(Object change)
   {
	   shuxing.setValue(this,change);
	   for(Negetivefun beidong:linkedFun)
	   {
		   if(beidong.check.check(beidong))
		   {
			   beidong.doIt();
		   }
	   }
   }
   
   public String getName()
   {
	return name;
   }
   

    protected Attri clone(Thing shiwu,String type)
    {
    	Attri shu=new Attri(shiwu, type,this.shuxing);
    	return shu;
    }
   
    
    public Address getAddress() 
    {
    	if(belonged.isIntance)
    	{
    		Address dizhi=new Address(name,belonged.getId(),belonged.getName());
        	return dizhi;
    	}
    	throw new RuntimeException("非实例事物，无法返回地址");
	}
    
    
   
}
