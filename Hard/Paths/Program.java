// package Hard.Paths;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Scanner;

// // https://open.kattis.com/problems/paths

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         Graph graph = new Graph();
//         int N, M;
//         N = sc.nextInt();
//         M = sc.nextInt();
//         sc.nextInt(); // no need to capture K

//         // Initialize vertices
//         for (int i = 0; i < N; i++) {
//             int color = sc.nextInt();
//             Vertice vert = new Vertice(i + 1, color);
//             graph.put(vert);
//             // System.out.println("Created: { " + vert.id + ", " + vert.color + " }" ); //
//             // // debugging
//         }

//         // Read edges
//         for (int i = 0; i < M; i++) {
//             int from = sc.nextInt();
//             int to = sc.nextInt();
//             graph.putEdge(graph.getFromId(from), graph.getFromId(to));
//             // System.out.println("Created edge: "+ graph.getFromId(from) + " -> " +
//             // graph.getFromId(to)); // debugging
//         }

//         // Output
//         // graph.printGraph();
//         System.out.println(graph.findPaths()[0]);
//         sc.close();
//     }
// }

// class Graph {
//     private Map<Vertice, List<Vertice>> adjList;

//     public Graph() {
//         adjList = new HashMap<>();
//     }

//     public List<Vertice> getAdjList(Vertice v) {
//         return adjList.get(v);
//     }

//     public Vertice getFromId(int i) {
//         for (Vertice vert : adjList.keySet()) {
//             if (vert.id == i) {
//                 return vert;
//             }
//         }
//         return null;
//     }

//     public void put(Vertice v) {
//         if (adjList.get(v) == null) {
//             adjList.put(v, new ArrayList<Vertice>());
//         }
//     }

//     public boolean putEdge(Vertice from, Vertice to) {
//         if (from.color == to.color) {
//             return false;
//         }

//         adjList.get(from).add(to);
//         adjList.get(to).add(from);

//         return true;
//     }

//     public int[] findPaths() {
//         // List<List<Vertice>> paths = new ArrayList<>();
//         int[] paths = {0};

//         for (Vertice startVert : adjList.keySet()) {
//             List<Vertice> currentPath = new ArrayList<>(); 
//             dfs(startVert, currentPath, paths);
//         }

//         // // for debugging
//         // for (List<Vertice> list : paths) {
//         // System.out.println(list);
//         // }

//         return paths;
//     }

//     public void dfs(Vertice vert, List<Vertice> currentPath, int[] paths) {
//         currentPath.add(vert);

//         if (currentPath.size() >= 2) {
//             // paths.add(new ArrayList<>(currentPath)); // Found a valid path
//             paths[0]++;
//         }

//         for (Vertice neighbor : adjList.get(vert)) {
//             if (!currentPath.contains(neighbor) && isValid(neighbor, currentPath)) {
//                 if (neighbor.color == vert.color) {
//                     continue;
//                 }
//                 dfs(neighbor, currentPath, paths);
//             }
//         }

//         currentPath.remove(currentPath.size() - 1); // Backtrack
//     }

//     private boolean isValid(Vertice vert, List<Vertice> currentPath) {
//         if (currentPath.contains(vert)) { // Exit early
//             return false;
//         }

//         // No color more than once per path
//         for (Vertice v : currentPath) {
//             if (v.color == vert.color) {
//                 return false;
//             }
//         }

//         return true;
//     }

//     public void printGraph() {
//         for (Map.Entry<Vertice, List<Vertice>> entry : adjList.entrySet()) {
//             Vertice vert = entry.getKey();
//             List<Vertice> neighbours = entry.getValue();

//             System.out.println("Vertex: " + vert + ": ");
//             System.out.println("Edges: ");
//             for (Vertice v : neighbours) {
//                 System.out.println(v + " ");
//             }
//             System.out.println();
//         }
//     }
// }

// class Vertice {
//     int id;
//     int color;

//     public Vertice(int _id, int _color) {
//         id = _id;
//         color = _color;
//     }

//     public String toString() {
//         return " {Id: " + this.id + "; Color: " + color + "} ";
//     }
// }
