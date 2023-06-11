package hw_od.code2023;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * 华为od统一考试B卷【比赛的冠亚季军]
 *
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        List<Player> allPlayers = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            Player p = new Player(i,nums[i]);
            allPlayers.add(p);
        }
        List<Player> winPlayer = new ArrayList<>();
        List<Player> losePlayer = new ArrayList<>();

        battle(allPlayers,winPlayer,losePlayer);
        Collections.sort(winPlayer);
        Collections.sort(losePlayer);
        System.out.println(winPlayer.get(0).id + " " + winPlayer.get(1).id + " " + losePlayer.get(0).id);
        return;
    }
    public static void battle(List<Player> allPlayers,List<Player> winPlayer,List<Player> losePlayer){
        List<Player> res = new ArrayList<>();
        int length = allPlayers.size();
        for (int i = 0; i < length; i+=2) {
            Player first = allPlayers.get(i);
            if(i == length-1){
                res.add(first);
                if(length ==3){
                    winPlayer.add(first);
                }
                break;
            }
            Player second = allPlayers.get(i+1);
            if(first.score >=second.score){
                res.add(first);
                if(length <=4){
                    winPlayer.add(first);
                    losePlayer.add(second);
                }
            }else{
                res.add(second);
                if(length <=4){
                    winPlayer.add(second);
                    losePlayer.add(first);
                }
            }
        }
        if(res.size() >=3){
            battle(res,winPlayer,losePlayer);
        }
    }





    public static class Player implements Comparable<Player>{
        private int id;
        private int score;

        public Player(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Player p) {
            if(this.score == p.score){
                return this.id - p.id;
            }
            return p.score - this.score;
        }
    }
}
