package ConstructWay;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 路径构建，暂时不考虑节点新增节点的情况，因为太复杂了
 */
public class WayContructor {

    ArrayList<IDistance> nodeList = new ArrayList<>();

    TreeMap<IDistance, NodeRelation> NodeInfo = new TreeMap<>();


/**
 * @param nodes
 */
    public WayContructor(ArrayList<IDistance> nodes) {
        this.nodeList = nodes;
        BuildNodeInfo();
    }

    /**
     * 获取从起始点到终点的最短距离
     *
     * @param startPoint 起点
     * @param endPoint   终点
     * @return 距离
     */
    public Way GetShortestDistance(IDistance startPoint, IDistance endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new RuntimeException("参数中包含null");
        }
        if (!nodeList.contains(startPoint) || !nodeList.contains(endPoint)) {
            throw new RuntimeException("参数不包含在构建最短路径的节点集合中");
        }


        return null;
    }


    private void BuildNodeInfo() {



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
        IDistance point;
        ArrayList<WayNode> relation;

        public NodeRelation(IDistance p, ArrayList<WayNode> r) {
            this.point = p;
            this.relation = r;
        }
    }

}
