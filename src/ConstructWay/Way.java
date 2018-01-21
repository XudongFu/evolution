package ConstructWay;

import java.util.ArrayList;

public class Way {

    int Distance=0;

    public void setNodeSequence(ArrayList<WayNode> nodeSequence) {
        NodeSequence = nodeSequence;
    }

    ArrayList<WayNode> NodeSequence=new ArrayList<WayNode>();

    IDistance StartPoint;

    /**
     * 第一个节点是起点
     * @param startPoint
     */
    public Way(IDistance startPoint) {
        this.StartPoint=startPoint;
    }

    public ArrayList<WayNode> GetWayNodeSqquence() {
        return NodeSequence;
    }

    public Way Clone() {
        Way way=new Way(StartPoint );
       for(WayNode node :NodeSequence ) {
           way.AppendNode(node);
       }
       return way;
    }

    /**
     *
     * @param node
     * @param distance
     */
    public void AppendNode(IDistance node,int distance) {
        if(node ==null) {
            throw  new RuntimeException("ArgueMentException");
        }
        if(Distance<Integer.MAX_VALUE - distance) {
            WayNode tempNode =new WayNode(node,distance);
            Distance += distance;
            NodeSequence.add(tempNode);
        }
        else
            throw  new RuntimeException("Ways distance is too big to hold it");
    }

    public void AppendNode(WayNode node) {
        if(node ==null) {
            throw  new RuntimeException("ArgueMentException");
        }
        if(Distance<Integer.MAX_VALUE - node.Distance) {
            Distance += node.Distance;
            NodeSequence.add(node);
        }
        else
            throw  new RuntimeException("Ways distance is too big to hold it");
    }

}
