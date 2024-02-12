package Easy.Reduplication;

import java.util.Scanner;

// https://open.kattis.com/problems/reduplikation

class Program {
    public static void main(String[] args) {
        StringBuilder strb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int times = sc.nextInt();

        int i = 0;
        while (i < times) {
            strb.append(word);
            i++;
        }
        
        System.out.println(strb.toString());
        sc.close();
    }
}
