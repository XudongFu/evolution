package environment;

import java.util.ArrayList;
import java.util.Map;

public interface Functional 
{
	  /**
     * 
     * @param desit ��Ҫ���ĵ�Ŀ�꺯����
     * @return ���ÿ��Ŀ�꺯������Ҫ���еĸ���
     */
     Map<Attri, Object> function(Negetivefun fun,ArrayList<Attri> desit);
     
     /**
 	 * ��ȡ����������
 	 * @return
 	 */
 	 String getFunName();
 	
}
