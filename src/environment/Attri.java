package environment;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public  class Attri 
{
    /**
     * 所属的世界和事物
     */
    World world;
	Thing belonged;

	/**
	 * 属性的类型，给属性添加的事物内属性唯一标识符
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

    /**
     * 这个是为了属性可以克隆所做的工作
     */
	public Map<String, Integer> integerMap=new TreeMap<String, Integer>();
	public Map<String, String> stringMap=new TreeMap<>();
    public Map<String,Boolean> booleanMap=new TreeMap<>();


    /**
     *
     * @param name 属性的名称或者叫做类型
     * @param shu
     */
   	public Attri(String name,Attriable shu)
	{
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
    	Attri shu=new Attri( type,this.shuxing);
    	shiwu.attachAttri(shu);
    	return shu;
    }
   
    
    public Address getAddress() 
    {
    	if(belonged.isIntance)
    	{
    		Address dizhi=new Address(name,belonged.getId(),belonged.getName(),Type.ATTRIBLE);
        	return dizhi;
    	}
    	throw new RuntimeException("非实例事物，无法返回地址");
	}

}
