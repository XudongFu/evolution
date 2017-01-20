package environment;

import java.util.ArrayList;
import java.util.Map;

public interface Functional 
{
	  /**
     * 
     * @param desit 需要更改的目标函数，
     * @return 针对每个目标函数，需要进行的更改
     */
     Map<Attri, Object> function(Negetivefun fun,ArrayList<Attri> desit);
     
     /**
 	 * 获取函数的名称
 	 * @return
 	 */
 	 String getFunName();
 	
}
