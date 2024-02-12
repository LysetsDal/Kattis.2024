package Easy.Songbook;

import java.util.Arrays;
import java.util.Scanner;

class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mins = sc.nextInt();
        int numSongs = sc.nextInt();
        sc.nextLine();

        int[] songs = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int max_length = minToSec(mins);

        int count = 0;
        for (int i = 0; count < max_length && i < numSongs; i++) {
            int tmp = songs[i];

            if (count + tmp > max_length) {
                break;
            }

            count += tmp;
        }

        System.out.println(count);
        sc.close();
    }

    public static int minToSec(int min) {
        return min * 60;
    }
}
