package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.HashMap;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 比赛
 */
public class Solution31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings1 = in.nextLine().split(",");
        int m = Integer.valueOf(strings1[0]);
        int n = Integer.valueOf(strings1[1]);
        if (m < 3 || m > 10 || n < 3 || n > 100) {
            System.out.println("-1");
            return;
        }
        int[][] scores = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] temp = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                scores[i][j] = temp[j];
                if (scores[i][j] > 10 || scores[i][j] < 1) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        HashMap<Integer, Integer[]> players = new HashMap<>();
        for (int j = 0; j < n; j++) {
            Integer[] playerScores = new Integer[m];
            for (int i = 0; i < m; i++) {
                playerScores[i] = scores[i][j];
            }
            Arrays.sort(playerScores, (a, b) -> b - a);
            players.put(j, playerScores);
        }
        StringJoiner sj = new StringJoiner(",");
        players.entrySet().stream()
                .sorted(
                        (a, b) -> {
                            Integer[] playerA = a.getValue();
                            Integer[] playerB = b.getValue();
                            int sumA = Stream.of(playerA).mapToInt(Integer::intValue).sum();
                            int sumB = Stream.of(playerB).mapToInt(Integer::intValue).sum();
                            if (sumA != sumB) {
                                return sumB - sumA;
                            }
                            for (int i = 0; i < m; i++) {
                                if (playerA[i] == playerB[i]) continue;
                                return playerB[i] - playerA[i];
                            }
                            return 0;
                        })
                .limit(3)
                .forEach(p -> sj.add(p.getKey() + 1 + ""));
        System.out.println(sj.toString());
        return;
    }

}


