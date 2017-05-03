package environment;

import java.util.ArrayList;

/**
 *这里是主动函数，
 * 需要设定一个类似于主函数一样的东西。
 *
 * 主动函数还存在一些问题，
 */
public  class PositiveFun extends BaseFunction
{
	public PositiveFun(String name)
	{
		super(name);
	}
    public ArrayList<Address> src=new ArrayList<>();

	public Runnable run;

    /**
     *  启动被动函数的执行
     */
    public  void doIt()
    {
        if(run!=null)
        {
            run.run();
        }
    }
    @Override
    public Object clone()
    {
        return null;
    }






}
