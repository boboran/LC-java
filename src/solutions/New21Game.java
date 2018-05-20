package solutions;

/**
 * Alice plays the following game, loosely based on the card game "21".
 * 
 * Alice starts with 0 points, and draws numbers while she has less than K
 * points. During each draw, she gains an integer number of points randomly from
 * the range [1, W], where W is an integer. Each draw is independent and the
 * outcomes have equal probabilities.
 * 
 * Alice stops drawing numbers when she gets K or more points. What is the
 * probability that she has N or less points?
 * 
 * Example 1:
 * Input: N = 10, K = 1, W = 10 
 * Output: 1.00000 
 * Explanation: Alice gets a single card, then stops. 
 * 
 * Example 2:
 * Input: N = 6, K = 1, W = 10 
 * Output: 0.60000 
 * Explanation: Alice gets a single card, then stops. In 6 out of W = 10 
 * possibilities, she is at or below N = 6 points. 
 * 
 * Example 3:
 * Input: N = 21, K = 17, W = 10 
 * Output: 0.73278 
 * 
 * Note:
 * 0 <= K <= N <= 10000 
 * 1 <= W <= 10000 
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer. 
 * The judging time limit has been reduced for this question.
 * 
 * @author Ellinx
 *
 */
public class New21Game {
	// dp[i] stands for possibility Alice gets i points
	// dp[i] is sum of dp[i-W]+...+dp[i-1] divide W
	public double new21Game(int N, int K, int W) {
        if (K==0) 
            return 1.0; //Alice stops immediately with 0 point
        double[] dp = new double[N+1];
        dp[0] = 1.0; //Alice stops immediately with 0 point
        double ret = 0;
        double preWSum = 1.0;
        for (int i=1;i<=N;i++) {
            dp[i] = preWSum/W;
            if (i<K)
                preWSum += dp[i];
            else
                ret += dp[i];
            if (i-W>=0 && i-W<K)
                preWSum -= dp[i-W];
        }
        //System.out.println(Arrays.toString(dp));
        return ret;
    }
}
