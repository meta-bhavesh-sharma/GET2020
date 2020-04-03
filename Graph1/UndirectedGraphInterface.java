package Graph;

import java.util.ArrayList;
import java.util.HashMap;

interface UndirectedGraphInterface {
	boolean isConnected();
	public ArrayList<Integer> reachable(int vertex);
	HashMap<Integer,Integer> minimumSpanningTree();
	public int shortestPath(int src,int end);

}
