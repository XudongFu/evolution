package environment;

import java.util.Map;
import java.util.TreeMap;


/***
 * 对于单个事物属性状态的描述，
 */
public class Condition 
{
	String name;
	String id;
	
	Map<String, Object> attri=new TreeMap<String, Object>();
	
	public Condition(Thing thing) 
	{
		name=thing.getName();
		id=thing.getId();
		for(Attri shuxing:thing.attris)
		{
			attri.put(shuxing.getType(), shuxing.shuxing.getValue(shuxing));
		}
	}
	
	
}
