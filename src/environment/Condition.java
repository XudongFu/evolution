package environment;

import java.util.Map;
import java.util.TreeMap;
/***
 * 对于单个事物属性状态的描述，
 */
public class Condition 
{
	Thing thing;
	//保存状态的一个副本
	Map<String, Object> attri=new TreeMap<String, Object>();

	private  Condition() {
    }

    public  String getBelongedId()
    {
        return thing.getId();
    }


    /**
     * 关键属性
     */
   public Address KeyAttri;

    /**
     * 当且仅当状态是目的状态时，属性值才有意义
     * 是否只关注关键属性，忽略其他的属性
     */
	public Boolean IgnoreOtherAttri;

    /**
     * 当且仅当状态是目的状态时，属性值才有意义
     * 是不是不要更改其他的属性
     */
    //状态中所有的属性都需要匹配
    public 	Boolean AllFit;

    public Condition(Thing thing) {
       if(!thing.isIntance)
        throw new RuntimeException("对事物建立状态失败，状态仅仅针对于实例事物才有意义");
        this.thing=thing;
        for(Attri shuxing:thing.attris) {
            attri.put(shuxing.getName(), shuxing.shuxing.getValue(shuxing));
        }
        IgnoreOtherAttri =true;
        AllFit =false;
    }


	public Condition(Thing thing,Address keyAttri) {
        if(!thing.isIntance)
            throw new RuntimeException("对事物建立状态失败，状态仅仅针对于实例事物才有意义");
	    this.KeyAttri=keyAttri;
	    this.thing=thing;
		for(Attri shuxing:thing.attris) {
			attri.put(shuxing.getName(), shuxing.shuxing.getValue(shuxing));
		}
		IgnoreOtherAttri =true;
		AllFit =false;
	}

    /**
     * 用于生成目标状态的简单函数
     * @return 返回当前状态的一个副本，改变其中一个属性的值，
     */
	public Condition getDesitCondition(String keyAttri,Object value)
    {
        Condition condition=new Condition();
        condition.thing=this.thing;
        condition.attri=new TreeMap<>();
        this.attri.forEach((x,y)-> {
            if(!x.equals(keyAttri))
            condition.attri.put(x,y);
                    else
                condition.attri.put(x,value);
                }
        );
        condition.KeyAttri=this.thing.getAttriAddress(keyAttri);
        condition.AllFit=false;
        condition.IgnoreOtherAttri=true;
        return  condition;
    }

    private  int i=0;




    @Override
    public boolean equals(Object obj) {
       Condition condition=(Condition) obj;
	    if(condition.AllFit) {
            if(condition.attri.size()==this.attri.size()) {
                this.attri.forEach((x,y)->{
                    if(!y.equals(condition.attri.get(x)));
                    i++;
                });
                if(i>0) {
                    i=0;
                    return false;
                }}
            else
                return  false;
        }
        else {
            if(condition.IgnoreOtherAttri) {
                return this.attri.get(condition.KeyAttri.attriName)==condition.attri.get(condition.KeyAttri.attriName);
            }
        }
        throw  new RuntimeException("状态比较发生未知错误");











    }



}