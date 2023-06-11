package array;

public class Fibonacci {
    //1 1 2 3 5 8
    public static void main(String[] args) {
        int fi = fi2(5);
        System.out.println(fi);
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int fi(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fi(n-1) + fi(n-2);
    }

    public static int fi2(int n){
        int[] res = new int[n];
        res[0]=1;
        res[1]=1;
        for (int i = 2; i <n ; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n-1];
    }
}
