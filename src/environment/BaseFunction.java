package environment;

import java.util.ArrayList;

public  class BaseFunction 
{
	Thing belonged;
	World world;
	
	/**
	 * 函数要作用的目标{@code Address}的集合
	 */
	public ArrayList<Address> desti=new ArrayList<>();
	
	Functional hanshu;
	
    public	BaseFunction(Thing thing)
	{
    	 this.belonged=thing;
    	 world=thing.world;
	}
    
    public void setFunction(Functional hanshu)
    {
    	this.hanshu=hanshu;
    }
    
    
    
    /**
     * @param change需要发生的改变，也就是函数的逆函数
     * @return
     */
    Object predict(Address address,Object change)
    {	
    	return null;
    }
    
	
    public	BaseFunction(World world)
   	{
       this.world=world;
   	}
    
    /**
     * 需要记录函数对每个函数进行的改变
     */
    @SuppressWarnings("unused")
	private void registerChangeToWorld()
    {
    	
    }
    /**
     * 需要一种描述达到什么状态执行的的方法。
     */
   
    
	
}
