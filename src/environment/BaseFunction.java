package environment;

import java.util.ArrayList;

public  class BaseFunction 
{
	Thing belonged;
	World world;
	
	/**
	 * ����Ҫ���õ�Ŀ��{@code Address}�ļ���
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
     * @param change��Ҫ�����ĸı䣬Ҳ���Ǻ������溯��
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
     * ��Ҫ��¼������ÿ���������еĸı�
     */
    @SuppressWarnings("unused")
	private void registerChangeToWorld()
    {
    	
    }
    /**
     * ��Ҫһ�������ﵽʲô״ִ̬�еĵķ�����
     */
   
    
	
}
