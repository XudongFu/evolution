package environment;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @date 2016/10/7
 * @author ����
 *���ڼ�¼��������У������������������˵�ġ�
 *
 */
public class Way 
{
	/**
	 * ����ĳ�ʼ״̬
	 */
	Map<Address, Condition> startCondition=new HashMap<Address, Condition>();
	
	/**
	 * ��¼���������к�����ִ��״��
	 */
	Map<Address, Object> recorder=new TreeMap<>();
	
	public Way() 
	{
		
	}
	
	/**
	 * ��¼���εĻ
	 */
	public synchronized void  record() 
	{
		
	}
	
	

}
