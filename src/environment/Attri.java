package environment;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public  class Attri 
{
	private Thing belonged;
    World world;
	private String type;
	Attriable shuxing;
	ArrayList<Negetivefun> linkedFun=new ArrayList<>();
	
	public Map<String, Integer> integerMap=new TreeMap<String, Integer>();
	public Map<String, String> stringMap=new TreeMap<>();
	
   public Attri(Thing thing,String type,Attriable shu)
   {
	 this.belonged=thing;
	 world=thing.world;
	 belonged.attris.add(this);
	 this.type=type;
	 this.shuxing=shu;
	 shu.inite(this);
   }
   
   public Object getValue()
   {
	   if(shuxing!=null)
		   return shuxing.getValue(this);
		   throw new RuntimeException("�����Բ�������");
   }
   
   public void setValue(Object change) {
	   if(shuxing!=null)
		   shuxing.setValue(this,change);
		   throw new RuntimeException("�����Բ�������");
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
   
   public String getType() 
   {
	return type;
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
    		Address dizhi=new Address(type,belonged.getId(),belonged.getName());
        	return dizhi;
    	}
    	throw new RuntimeException("��ʵ������޷����ص�ַ");
	}
    
    
   
}
