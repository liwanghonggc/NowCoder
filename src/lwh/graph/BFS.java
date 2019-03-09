package lwh.graph;

import java.util.*;

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

	public static void myBFS(Node node){
		if(node == null){
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		Set<Node> set = new HashSet<>();

		queue.add(node);
		set.add(node);

		while (!queue.isEmpty()){
			Node cur = queue.poll();
			System.out.print(cur.value + ", ");
			for(Node next : cur.nexts){
				if(!set.contains(next)){
					queue.add(next);
					set.add(next);
				}
			}
		}
	}

	public static void dfs(Node node){
		if(node == null){
			return;
		}

		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);

		System.out.println(node.value);

		while (!stack.isEmpty()){
			Node cur = stack.pop();
			for(Node next : cur.nexts){
				if(!set.contains(next)){
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
}
