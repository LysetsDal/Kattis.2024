package Medium.rankproblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int teams = sc.nextInt();
        int games = sc.nextInt();
        sc.nextLine();

        int[] rank = new int[teams];

        // initialize 
        for (int i = 0; i < teams; i++) {
            rank[i] = i + 1;
        }


        // Ranking logic
        for (int i = 0; i < games; i++) {
            String in = sc.nextLine();
            Tuple match = read(in);

            if (match.first < match.second) {
                continue;
            }
            else {

                for (int j = 0; j < match.getFirst() - 1; j++) {
                    int tmp = rank[j];
                    rank[j] = tmp + 1;
                }

                rank[match.getFirst() - 1] = match.getSecond();


            }
            System.out.println("===================");
            printRanks(rank);
            System.out.println("===================");

        }






        printRanks(rank);

        sc.close();
    }

    public static void printRanks(int[] rank) {
        for (int i : rank) {
            System.out.println(i);
        }
    }


    public static Tuple read(String line) {
        List<String> tmp = Arrays.asList(line.split(" "));
        List<Integer> nums = tmp.stream()
                                .map(x -> x.substring(1))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        return new Tuple(nums.get(0), nums.get(1));
    }

    public static class Tuple {
        private int first;
        private int second;
    
        public Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    
        public int getFirst() {
            return first;
        }
    
        public int getSecond() {
            return second;
        }

        public String toString() {
            return "{ " + this.first + ", " + this.second + " }";
        }
    }
}
