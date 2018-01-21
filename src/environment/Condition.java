package environment;

import java.util.HashMap;
import java.util.Map;
/***
 * 对于单个事物属性状态的描述，
 */
public class Condition {
	Thing thing;
	//保存状态的一个副本
	Map<String, Object> attri=new HashMap<String, Object>();

    String ThingName;
	String id;

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


    private  Condition()
    {}

    /**
     *  建立事物状态，默认 AllFit=false,IgnoreOtherAttri=true;
     * @param thingName 事物的名称
     * @param id 事物的id
     */
	public   Condition(String thingName,String id) {
        this.id = id;
        this.ThingName = thingName;
        AllFit=false;
        IgnoreOtherAttri=true;
    }

    public Condition(Thing thing) {
        if(!thing.isIntance)
            throw new RuntimeException("对事物建立状态失败，状态仅仅针对于实例事物才有意义");
        this.thing=thing;
        ThingName=thing.getName();
        id=thing.getId();
        for(Attri shuxing:thing.attris) {
            attri.put(shuxing.getName(), shuxing.shuxing.getValue(shuxing));
        }
        IgnoreOtherAttri =true;
        AllFit =false;
    }

    /**
     *  状态不需要一定针对于实例事物创建
     * @param thing
     * @param keyAttri
     */

    public Condition(Thing thing,Address keyAttri) {
      if(!thing.isIntance)
            throw new RuntimeException("对事物建立状态失败，状态仅仅针对于实例事物才有意义");
        this.KeyAttri=keyAttri;
        this.thing=thing;
        this.thing=thing;
        ThingName=thing.getName();
        id=thing.getId();

        for(Attri shuxing:thing.attris) {
            attri.put(shuxing.getName(), shuxing.shuxing.getValue(shuxing));
        }
        IgnoreOtherAttri =true;
        AllFit =false;
    }

    /**
     * 记录某个属性的值
     * @param attriName 属性名称
     * @param value 属性值
     */
    public void putAttriValue(String attriName,Object value)
    {
        attri.put(attriName,value);
    }


    public  String getBelongedId()
    {
        return id;
    }



    /**
     * 用于生成目标状态的简单函数
     * @return 返回当前状态的一个副本，改变其中一个属性的值，
     */
	public Condition getDesitCondition(String keyAttri,Object value)
    {
        Condition condition=new Condition();
        condition.thing=this.thing;
        condition.ThingName=this.ThingName;
        condition.id=this.id;
        condition.attri=new HashMap<>();
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
        if(condition.ThingName.equals(this.ThingName)) {
            if (condition.AllFit && this.AllFit) {
                if (condition.attri.size() == this.attri.size()) {
                    this.attri.forEach((x, y) -> {
                        if (!y.equals(condition.attri.get(x))) ;
                        i++;
                    });
                    if (i > 0) {
                        i = 0;
                        return false;
                    }
                } else
                    return false;
            } else {
                //两个关键属性还可能存在不相同的情况
                Address keySelf = this.KeyAttri;
                Address other = condition.KeyAttri;
                Boolean keyselfTrue = true;
                Boolean otherTrue = true;
                if (keySelf != null)
                    keyselfTrue = this.attri.get(keySelf.attriName).equals(condition.attri.get(keySelf.attriName));
                if (other != null)
                    otherTrue = this.attri.get(other.attriName).equals(condition.attri.get(other.attriName));
                return keyselfTrue && otherTrue;
            }
        }
        else
        return false;
        throw  new RuntimeException("状态比较发生未知错误");

    }



}