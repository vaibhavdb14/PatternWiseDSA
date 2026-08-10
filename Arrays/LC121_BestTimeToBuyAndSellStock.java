class LC121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int len = prices.length;
        int minimumPrice = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++){
            if(prices[i] < minimumPrice){
                minimumPrice = prices[i];
            }

            int currentProfit = prices[i] - minimumPrice; 

            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }
        }
        

        if(maxProfit > 0)
            return maxProfit;
        else
            return 0;
      
    }

    public static void main(String[] args) {
        LC121_BestTimeToBuyAndSellStock obj = new LC121_BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = obj.maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

