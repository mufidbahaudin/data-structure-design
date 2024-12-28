/*Nama : Mufid Bahaudin Nugroho
 * NIM : 22106050021
 */
import java.util.*;

public class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public Graph transpose() {
        Graph transposedGraph = new Graph(numVertices);
        for (int u = 0; u < numVertices; u++) {
            for (int v : adjList.get(u)) {
                transposedGraph.addEdge(v, u);
            }
        }
        return transposedGraph;
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        System.out.println();
    }

    public void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int u : adjList.get(v)) {
            if (!visited[u]) {
                dfsUtil(u, visited);
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[numVertices];
        dfsUtil(start, visited);
        System.out.println();
    }

    public void printAdjList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int numVertices = scanner.nextInt();

        Graph graph = new Graph(numVertices);
        System.out.println("Enter number of edges:");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (format: u v):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Transpose graph");
            System.out.println("2. BFS graph");
            System.out.println("3. DFS graph");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Graph transposedGraph = graph.transpose();
                    System.out.println("Transposed Graph Adjacency List:");
                    transposedGraph.printAdjList();
                    break;
                case 2:
                    System.out.print("Enter start vertex for BFS: ");
                    int bfsStart = scanner.nextInt();
                    System.out.println("BFS traversal starting from vertex " + bfsStart + ":");
                    graph.bfs(bfsStart);
                    break;
                case 3:
                    System.out.print("Enter start vertex for DFS: ");
                    int dfsStart = scanner.nextInt();
                    System.out.println("DFS traversal starting from vertex " + dfsStart + ":");
                    graph.dfs(dfsStart);
                    break;
                case 4:
                    System.out.println("Keluar dari program");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan invalid, silakan coba lagi.");
            }
        }
    }
}
