package Medium.frogger;

import java.util.Scanner;

// https://open.kattis.com/problems/1dfroggereasy

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num_squares = sc.nextInt();
        int idx_start = sc.nextInt() - 1;
        int magic_num = sc.nextInt();

        int[] board = new int[num_squares];
        int idx_curr = idx_start;
        int idx_next = 0;
        int current_val;
        int old_val = 0;

        // populate board
        for (int i = 0; i < board.length; i++) {
            board[i] = sc.nextInt();
        }

        boolean alive = true;
        int count = 0;

        while (alive) {
            if (count == 0) {
                current_val = board[idx_start];
                old_val = current_val;
            } else {
                
                if (Math.abs(board[idx_next]) == Math.negateExact(old_val)) {
                    if (board[idx_next] > 0) {
                        print("cycle", count);
                        break;
                    }
                    print("cycle", count);
                    break;
                }
                
                current_val = board[idx_next];
                old_val = current_val;
                idx_curr = idx_next;
            }

            if (current_val == magic_num) {
                print("magic", count);
                break;
            }

            if (current_val > 0) {
                idx_next = idx_curr + Math.abs(current_val);
                if (idx_next >= board.length) {
                    print("right", count);
                    break;
                }
                count++;
            }

            if (current_val < 0) {
                idx_next = idx_curr - Math.abs(current_val);
                if (idx_next < 0) {
                    print("left", count);
                    break;
                }
                count++;
            }
        }

        sc.close();
    }

    public static void print(String text, int count) {
        System.out.println(text);
        System.out.println(count);
    }
}
