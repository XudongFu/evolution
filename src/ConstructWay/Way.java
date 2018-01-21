package ConstructWay;

import java.util.ArrayList;

public class Way {

    int Distance=0;

    ArrayList<WayNode> NodeSequence=new ArrayList<WayNode>();

    public Way() {
    }

    public ArrayList<WayNode> GetWayNodeSqquence() {
        return NodeSequence;
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
            WayNode tempNode =new WayNode();
            tempNode.node=node;
            tempNode.Distance=distance;
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
