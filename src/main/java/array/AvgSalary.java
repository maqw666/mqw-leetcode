package array;

public class AvgSalary {
    public static void main(String[] args) {
        int[] salary = {4000,3000,1000,2000};
        double result = average(salary);
        System.out.println(result);
    }
    public static double average(int[] salary) {
       double max = Integer.MIN_VALUE;
       double min = Integer.MAX_VALUE;
       double sum=0;
        for (Integer num:salary) {
            sum += num;
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
