package hw_od.code2023;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 支持优先级的队列
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().replaceAll("\\(","").replaceAll("\\)","").split(",");

        PriorityQueue<Job> q = new PriorityQueue<>();
        for (int i = 0; i < params.length; i+=2) {
            int data = Integer.valueOf(params[i]);
            int priority = Integer.valueOf(params[i+1]);
            Job job = new Job(data,priority);
            q.add(job);
        }
        List<Integer> res = new ArrayList<Integer>();
        Job job = q.poll();
        while(job !=null){
            Job top = q.peek();
            if(!job.equals(top)){
                res.add(job.data);
            }
            job = q.poll();
        }
        System.out.println(res);
    }

    public static class Job implements Comparable<Job>{
        private int data;
        private int priority;

        public Job(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }

        @Override
        public int compareTo(Job o) {
            return o.priority - this.priority;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(obj ==null || getClass() != obj.getClass()){
                return false;
            }
            Job job = (Job) obj;
            return data == job.data && priority == job.priority;
        }
    }
}
