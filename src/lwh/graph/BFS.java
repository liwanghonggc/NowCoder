package lwh.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public static void bfs(Node node){
		if(node == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		
		//set用来判断某个节点是否已经被遍历过
		HashSet<Node> set = new HashSet<>();
		
		queue.add(node);
		set.add(node);
		while(!queue.isEmpty()){
			Node cur = queue.poll();
			System.out.print(cur.value + ", ");
			for(Node next : cur.nexts){
				if(!set.contains(next)){
					set.add(next);
					queue.add(next);
				}
			}
		}
	}
}
