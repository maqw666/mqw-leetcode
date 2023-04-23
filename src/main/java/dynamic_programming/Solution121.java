package dynamic_programming;

/**121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class Solution121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit3(prices));
    }

    /**
     *  个人-未解出
     * @param prices
     * @return
     */
    /*public static int maxProfitMe(int[] prices) {
        int buy = 1;
        int sell = prices.length;
        int profile = 0;
        while (buy < sell){
            if(prices[buy]<prices[buy-1] && prices[buy]<prices[buy+1]){
                //买入
                profile = -prices[buy];
            }
            if(prices[buy]>prices[buy-1] && prices[buy]>prices[buy+1]){
                //卖出
                profile = profile + prices[buy];
            }
            buy++;
        }
        return profile;
    }*/
    /**
     *  暴力解法
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for(int i =0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit = prices[j]-prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    /**
     *  一次遍历法
     *  时间复杂度：O(n)，只需要遍历一次。
     *  空间复杂度：O(1)，只使用了常数个变量。
     * @param prices 7,1,5,3,6,4
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;;
        for(int i =0;i<prices.length;i++){
            if(minValue>prices[i]){
                minValue = prices[i];
            }
            if(prices[i] - minValue > maxProfit){
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices){
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i =0;i<prices.length;i++){
            minValue= Math.min(minValue,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minValue);
        }
        return maxProfit;
    }
}
