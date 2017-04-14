package environment;

import java.util.ArrayList;

public  class BaseFunction implements IAddressable
{
	Thing belonged;
	World world;

	/**
	 * 函数也是需要名称的，代表执行动作的名称，为以后构建新的编程语言做准备
	 */
	String functionName;

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

    /**
     * 函数体
     */
	public  Functional functionBody;

    /**
     *
     * @param funName  函数的名称，也代表所进行动作的名称
     */
    public	BaseFunction(String funName) {
        functionName=funName;
    }

    public void setFunction(Functional hanshu)
    {
    	this.functionBody =hanshu;
    }

    /**
     *用于远对象过程调用使用
     * 2017/3/16   这个需要重新考虑，这个函数会被抛弃
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
   
    public  Address getAddress() {
        if(belonged.isIntance) {
            Address address=new Address(belonged.getName(),functionName,belonged.getId(),Type.FUNCTION);
            return  address;
        }
        throw new RuntimeException("非实例事物，无法返回地址");
	}


    /**
     * 获取函数的具体描述，事物自己可以提供这个函数也可以不提供这个函数，
     * 不提供的话，系统就需要自己构建，
     * @return
     */
	Tentacle getTentacle()
    {
        return  null;
    }

    public String getFunctionName()
    {
        return  functionName;
    }

}
