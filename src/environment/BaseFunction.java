package environment;

import java.util.ArrayList;

public  class BaseFunction 
{
	Thing belonged;
	World world;
	
	/**
	 * 函数要作用的目标{@code Address}的集合，
	 * 也是要去更改的对象。
	 * 每个函数都是为了改变才存在的
	 */
	public ArrayList<Address> desti=new ArrayList<>();

	/**
	 * 关联的被动函数，被动函数的启动也可以启动被动函数，被启动的被动函数需要  可以截断此被动函数的执行，并且可以检测传递的参数
	 * 合法性，更改参数等等所有内容。
	 */
	public ArrayList<BaseFunction> linkedFunction =new ArrayList<>();

	public  Functional hanshu;
	
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
     *用于远对象过程调用使用
     * @return 返回需要的参数列表
     */
    public ArrayList<String> getParams()
    {
        return  null;
    }


    /**
     * @param change 需要发生的改变，也就是函数的逆函数，用于构建路径使用，
	 *               这也是学习的核心函数，使用神经网络来构建
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
   
    public Address getAddress()
	{
		return null;
	}
	
}
