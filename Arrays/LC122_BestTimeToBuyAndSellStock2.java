class LC122_BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++){

            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        LC122_BestTimeToBuyAndSellStock2 obj = new LC122_BestTimeToBuyAndSellStock2();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }
}

/** 
 * Level - Medium
 * Note - This problem is a classic example of greedy algorithm. The idea is to accumulate profit whenever there is an increase in price from the previous day. We can buy on the previous day and sell on the current day to maximize profit. This way, we can capture all the upward trends in the stock prices.
 * 
 * IMP - Sometimes answer is around you, and you use extra brain to make it complex. This is one of those problems at least for me. The solution is very simple and elegant.
 */