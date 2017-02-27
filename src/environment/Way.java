package environment;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @date 2016/10/7
 * @author 付旭东
 *用于记录世界的运行，是针对于整个世界来说的。
 *
 */
public class Way 
{
	/**
	 * 世界的初始状态
	 */
	Map<Address, Condition> startCondition=new HashMap<Address, Condition>();
	
	/**
	 * 记录整个世界中函数的执行状况
	 */
	Map<Address, Object> recorder=new TreeMap<>();
	
	public Way() 
	{
		
	}
	
	/**
	 * 记录单次的活动
	 */
	public synchronized void  record() 
	{
		
	}
	
	

}
