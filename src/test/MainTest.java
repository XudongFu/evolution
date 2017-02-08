package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import environment.*;

public class MainTest {

	public static void main(String[] args) 
	{
			World shijie=new World("first");
			Thing huo=new Thing(shijie, "huo");
			Negetivefun hanshu=new Negetivefun(huo);
			Address mudi=new Address("shui","wendu","");
			hanshu.desti.add(mudi);
			
			Checkable jiancha=new Checkable() {
				@Override
				public boolean check(Negetivefun fun) {
					ArrayList<Attri> shu=fun.getAttris(mudi);
					for(Attri a:shu)
					{
						if((int)a.getValue()<100)
							return true;
					}
					return false;
				}
			};
			hanshu.setCheck(jiancha);
			Functional han=new Functional() {
				@Override
				public Map<Attri, Object> function(Negetivefun fun,ArrayList<Attri> desit) 
				{
					Map<Attri, Object> bianhua=new HashMap<>();
					for(Attri a:desit)
					{
						if((int)a.getValue()<95)
						{
							bianhua.put(a,5);
							System.out.println(a.getAddress().name+",id为： "+a.getAddress().id+"的温度增加了5度,变为了"+((int)a.getValue()+5));
						}
						else
						{
							bianhua.put(a, 100-(int)a.getValue());
							System.out.println(a.getAddress().name+"的温度达到了100度");
						}
					}
					System.out.println("遍历一次");
					return bianhua;
				}
				@Override
				public String getFunName() {
					return "heat";
				}
			};
			hanshu.setFunction(han);
			Thing shuiThing=new Thing(shijie, "shui");
			Attriable att=new Attriable() 
			{
				@Override
				public void inite(Attri attri) {
					attri.integerMap.put("wendu", 0);
				}
				@Override
				public void setValue(Attri attri, Object change) {
					
					if(attri.integerMap.get("wendu")<95)
					attri.integerMap.put("wendu",attri.integerMap.get("wendu")+5 );
					else {
						attri.integerMap.put("wendu",100 );
					}
				}
				@Override
				public Object getValue(Attri attri) {
					return attri.integerMap.get("wendu");
				}
			};
			new Attri(shuiThing,"wendu",att);
			
			shijie.addIntanceThingFromModel("shui",shijie.getFreeId());			
			shijie.addIntanceThingFromModel("shui",shijie.getFreeId());	
			shijie.addIntanceThingFromModel("huo",shijie.getFreeId());
			
			shijie.start();

	}

}
