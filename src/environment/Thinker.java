package environment;

import java.util.*;

/**
 * Created by 付旭东 on 2017/4/14.
 * tinker依附于世界，算法是一样的，存在一个就好了
 */
public class Thinker {


    /**
     * 所依附的世界
     */
    World belonged;

    /**
     * 压缩版的事物的名称和事物的映射
     */
    TreeMap<String,Thing> counter=new TreeMap<>();

    ArrayList<PositiveFun> positiveFuns;

    ArrayList<Negetivefun> negetivefuns;

    public Thinker() {
        readyBaseParamters();
        positiveFuns=getAllPositiveFun();
        negetivefuns=getAllNegetiveFun();
    }


    public Way fightOutWay(BaseExcepton excepton) {
        return null;
    }



    public Way fightOutWay(Condition desire) {
        return null;
    }

    public Way fightOutWay(Condition desire, Address attri) {
        return null;
    }

    /**
     *
     * 这个函数可能存在问题，不管了，错了没有关系，现有一个总比没有强
     * @param desitId
     * @param attri
     * @param desire
     * @return
     *
     */
    @Deprecated
    public Way fightOutWay(String desitId, Address attri, Condition desire) {

        return null;
    }

    /**
     * 简单路径构建，也就是路径构建中没有分叉,这个函数写的就不对。
     *
     * @param startId 起点事物Id
     * @param endId 终点事物Id
     * @param attri   自己关注的终点属性
     * @param desire  自己想要的目标终点状态
     * @return 返回构建的路径
     */
    public Way fightOutWay(String startId, String endId, Address attri, Condition desire) {
        Way result=new Way();
        Thing thing=belonged.findIntacneThingById(endId);
        Condition current=thing.getCondition();
        PositiveFun temp=null;

        while (temp == null)
        {
            temp=getPFunToAttri(current,desire,attri);
            if(temp!=null)
            {
                result.putAction(current,temp,desire);
                return result;
            }
            else
            {
                Negetivefun s=getNFunToAttri(current,desire,attri);
                result.putAction(current,s,desire);
                Tentacle tentacle= s.getTentacle();
                ArrayList<Condition> cons=  tentacle.reach(desire);

                if(cons!=null && cons.size()!=0)
                {
                    current=cons.get(0).thing.getCondition();
                    desire=cons.get(0);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param currnt
     * @param desire
     * @param attri
     * @return
     */
    private PositiveFun getPFunToAttri(Condition currnt,Condition desire,Address attri) {
        for (PositiveFun fun:positiveFuns) {
            if(fun.desti.contains(attri)) {
                Tentacle tentacle =fun.getTentacle();
                if (tentacle.check(currnt,desire))
                    return fun;
            }
        }
        return  null;
    }

    /**
     *
     * @param currnt
     * @param desire
     * @param attri
     * @return
     */
    private Negetivefun getNFunToAttri(Condition currnt,Condition desire,Address attri) {
        for (Negetivefun fun:negetivefuns) {
            if(fun.desti.contains(attri)) {
                Tentacle tentacle =fun.getTentacle();
                if (tentacle.check(currnt,desire))
                    return fun;
            }
        }
        return  null;
    }


    /**
     * 准备基础数据
     */
    public void refresh() {
        readyBaseParamters();
    }

    private void readyBaseParamters() {
        Iterator<Map.Entry<String, Thing>> search= belonged.intanceThings.entrySet().iterator();

        while (search.hasNext())
        {
            Thing thing= search.next().getValue();
            String key=thing.getName();
            if(!counter.containsKey(key))
            {
                counter.put(key,thing);
            }
        }
    }

    /**
     *  返回所有实例事物的所有的被动函数集合
     * @return
     */
   private   ArrayList<Negetivefun> getAllNegetiveFun() {
        ArrayList<Negetivefun> result=new ArrayList<>();
        Iterator<String> iterFun=counter.keySet().iterator();
        while (iterFun.hasNext())
        {
            Thing temp=counter.get(iterFun.next());
            for(Negetivefun fun: temp.negetiveFunMap)
            {
                result.add(fun);
            }
        }
        return  result;
    }

    /**
     * 获取所有的主动该函数集合
     * @return
     */
    private ArrayList<PositiveFun> getAllPositiveFun() {
        ArrayList<PositiveFun> result=new ArrayList<>();
        Iterator<String> iterFun=counter.keySet().iterator();
        while (iterFun.hasNext())
        {
            Thing temp=counter.get(iterFun.next());
            temp.positiveFunMap.forEach((key,value)->result.add(value) );
        }
        return  result;
    }


}
