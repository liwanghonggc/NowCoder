package lwh.graph;

public class GraphTest {

	public static Graph graph = null;
	
	public static void init(){
		Integer[][] matrix = {{1,2,3},{1,4,2},{2,3,4},{2,5,5},{4,3,1},{4,5,6}};
		graph = GraphGenerator.createGraph(matrix);
	}
	
	public static void main(String[] args) {
		init();
		
		Node node = graph.nodes.get(1);
		BFS.bfs(node);
	}
}
