
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int vertices = 5;

        Graph graph = new Graph(vertices);

        // Read edges from text file
        try {
            File file = new File("edges.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextInt()) {
                int source = input.nextInt();
                int target = input.nextInt();

                graph.addEdge(source, target);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // DFS using Adjacency List
        System.out.println("DFS using Adjacency List:");
        graph.DFSList(0);

        // DFS using Adjacency Matrix
        System.out.println("\nDFS using Adjacency Matrix:");
        graph.DFSMatrix(0);
    }
}
