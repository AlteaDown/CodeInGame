package Medium.StockExchangeLoses;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.codingame.com/training/medium/stock-exchange-losses
 *
 * The Goal
 * A finance company is carrying out a study on the worst stock investments and would like to acquire a program to do so.
 * The program must be able to analyze a chronological series of stock values in order to show the largest loss that it
 * is possible to make by buying a share at a given time t0 and by selling it at a later date t1. The loss will be
 * expressed as the difference in value between t0 and t1. If there is no loss, the loss will be worth 0.
 * <p>
 * Input
 * Line 1: the number n of stock values available.
 * <p>
 * Line 2: the stock values arranged in order, from the date of their introduction on the stock market v1 until the last known value vn. The values are integers.
 * <p>
 * Output
 * The maximal loss p, expressed negatively if there is a loss, otherwise 0.
 * <p>
 * Constraints
 * 0 < n < 100000
 * 0 < v < 231
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int stockCount = in.nextInt();

        ArrayList<Long> stocksList = new ArrayList<>();
        for (int i = 0; i < stockCount; i++) {
            Long stock = in.nextLong();
            stocksList.add(stock);
        }

        Long largestNegativeDifference = 0L;
        Long lowestRunningStock = Long.MAX_VALUE;

        int lastStockIndex = stocksList.size() - 1;
        for (int i = lastStockIndex; i >= 0; i--) {
            if (i < lastStockIndex && stocksList.get(i + 1) < lowestRunningStock) {
                lowestRunningStock = stocksList.get(i + 1);
            } else if (i == lastStockIndex) {
                lowestRunningStock = stocksList.get(i);
            }

            Long drop = -(stocksList.get(i) - lowestRunningStock);
            if (drop < largestNegativeDifference) {
                largestNegativeDifference = drop;
            }
        }

        System.out.println(largestNegativeDifference);
    }
}