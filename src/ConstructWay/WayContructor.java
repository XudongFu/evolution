package ConstructWay;

import Util.KeyValuePair;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 路径构建，暂时不考虑节点新增节点的情况，因为太复杂了
 */
public class WayContructor {

    ArrayList<IDistance> nodeList = new ArrayList<>();

    TreeMap<IDistance, NodeRelation> NodeInfo = new TreeMap<>();

    /**
     * 最短路径集合
     */
    TreeMap<IDistance, KeyValuePair<Integer,Way>> map=new TreeMap<>();
/**
 * @param nodes
 */
    public WayContructor(ArrayList<IDistance> nodes) {
        this.nodeList = nodes;
        BuildNodeInfo();
    }

    /**
     * 获取从起始点到终点的最短距离
     * @param startPoint 起点
     * @param endPoint   终点
     * @return 路径，不存在最短距离的话就会返回null
     */
    public Way GetShortestWay(IDistance startPoint, IDistance endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new RuntimeException("参数中包含null");
        }
        if (!nodeList.contains(startPoint) || !nodeList.contains(endPoint)) {
            throw new RuntimeException("参数不包含在构建最短路径的节点集合中");
        }
        map.clear();
        map.put(startPoint,new KeyValuePair<>(0,new Way(startPoint)));
        ArrayList<IDistance> NodeHasFind=new ArrayList<>(nodeList.size());
        FindTheShoetestWay(startPoint,NodeHasFind,map);
        if(map.containsKey(endPoint)) {
            return map.get(endPoint).Value;
        }
        return null;
    }

    private void FindTheShoetestWay( IDistance point ,ArrayList<IDistance> NodeHasFind ,TreeMap<IDistance, KeyValuePair<Integer,Way>> map ) {
        if (NodeHasFind.contains(point))
            return;
        NodeHasFind.add(point);
        ArrayList<WayNode> temp =NodeInfo.get(point).Relation;
        for (WayNode node : temp) {
            if(!map.containsKey(node.node)) {
                Way way= map.get(point).Value;
                Way newWay=way.Clone();
                newWay.AppendNode(node);
                map.put(node.node, new KeyValuePair<>(node.Distance,newWay) );
            }
            int nowDis=map.get(point).Key;
            if( node.Distance + nowDis < map.get(node.node).Key) {
                Way way= map.get(point).Value;
                Way newWay=way.Clone();
                newWay.AppendNode(node);
                map.put(node.node,new KeyValuePair<>(node.Distance + nowDis,newWay));
            }
        }
        for (WayNode node : temp) {
            FindTheShoetestWay(node.node,NodeHasFind,map);
        }
    }



    /**
     *  将 nodeList的参数转换成字典写到NodeInfo里面中去。
     */
    private void BuildNodeInfo() {
       for ( IDistance node : nodeList) {
           ArrayList<WayNode> relation =new ArrayList<>();
           for ( IDistance temp : nodeList) {
                int distance=node.GetDistanct(temp);
                if(distance!=WayNode.infinityDistance) {
                    relation.add(new WayNode(temp,distance));
                }
           }
           NodeInfo.put(node, new NodeRelation(node,relation));
      }
    }

    /**
     * 获取从起始点到终点的最长距离
     *
     * @param startPoint
     * @param endPoint
     * @return 距离
     */
    public Way GetLongestDistacne(IDistance startPoint, IDistance endPoint) {
        return null;
    }


    private static class NodeRelation {

        public IDistance point;
        public ArrayList<WayNode> Relation=new ArrayList<>();
        public TreeMap<IDistance,Integer> map=new TreeMap<>();


        public NodeRelation(IDistance p, ArrayList<WayNode> r) {
            this.point = p;
            this.Relation=r;
            for (WayNode node : r) {
                map.put(node.node,node.Distance);
            }
        }

        public int GetDistance(IDistance node) {
            if(!map.containsKey(node)) {
                return WayNode.infinityDistance;
            }
            return map.get(node);
        }


    }



}
