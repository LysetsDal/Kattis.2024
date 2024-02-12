package Hard.Paths;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// https://open.kattis.com/problems/paths
// Group 1 is accepted, but too slow for group 2 - 4 ??? 
// Might be stack overflow due to recursion...

public class Main {
    
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] colorMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextInt(); // K not used

        // Index is verticeId, colorMap[i] is color.
        colorMap = new int[N];

        // Initialize vertices
        for (int i = 0; i < N; i++) {
            int color = sc.nextInt();
            colorMap[i] = color;
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            if (colorMap[from] == colorMap[to]) {
                continue;
            }

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // Output
        System.out.println(findPaths(graph));
        sc.close();
    }

    public static int findPaths(List<List<Integer>> graph) {
        int[] paths = { 0 };
        Set<Integer> visited = new HashSet<>();
        BitSet usedColors = new BitSet();

        for (int i = 0; i < graph.size(); i++) {
            dfs(i, visited, usedColors, paths);
        }

        return paths[0];
    }

    private static void dfs(int vert, Set<Integer> visited, BitSet usedColors, int[] paths) {
        visited.add(vert);
        usedColors.set(colorMap[vert]);

        if (visited.size() >= 2) {
            paths[0]++;
        }

        for (int neighbor : graph.get(vert)) {
            if (!visited.contains(neighbor) && !usedColors.get(colorMap[neighbor])) {
                dfs(neighbor, visited, usedColors, paths);
            }
        }

        visited.remove(vert);
        usedColors.clear(colorMap[vert]);
    }
}