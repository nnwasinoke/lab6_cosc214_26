
import java.util.ArrayList;

public class Graph {

    private int vertices_no;

    // Adjacency List
    private ArrayList<ArrayList<Integer>> adj_list;

    // Adjacency Matrix
    private int[][] adj_matrix;

    public Graph(int vertices_no) {

        this.vertices_no = vertices_no;

        adj_list = new ArrayList<>();

        adj_matrix = new int[vertices_no][vertices_no];

        for (int i = 0; i < vertices_no; i++) {
            adj_list.add(new ArrayList<>());
        }
    }

    // Add edges to both representations
    public void addEdge(int from, int to) {

        adj_list.get(from).add(to);
        adj_list.get(to).add(from);

        adj_matrix[from][to] = 1;
        adj_matrix[to][from] = 1;
    }

    // DFS using Adjacency List
    public void DFSList(int start_node) {

        boolean[] visited = new boolean[vertices_no];

        DFSListHelper(start_node, visited);

        System.out.println();
    }

    private void DFSListHelper(int vertex, boolean[] visited) {

        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (int neighbor : adj_list.get(vertex)) {

            if (!visited[neighbor]) {
                DFSListHelper(neighbor, visited);
            }
        }
    }

    // DFS using Adjacency Matrix
    public void DFSMatrix(int start_node) {

        boolean[] visited = new boolean[vertices_no];

        DFSMatrixHelper(start_node, visited);

        System.out.println();
    }

    private void DFSMatrixHelper(int vertex, boolean[] visited) {

        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (int i = 0; i < vertices_no; i++) {

            if (adj_matrix[vertex][i] == 1 && !visited[i]) {
                DFSMatrixHelper(i, visited);
            }
        }
    }
}
