package lwh.graph;

import java.util.ArrayList;

public class Node {

	public int value;//节点序号
	public int in;   //入度
	public int out;  //出度
	public ArrayList<Node> nexts;   //从该节点出发下一个能到的节点
	public ArrayList<Edge> edges;   //从该节点出发的边集
	
	public Node(int value){
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
