package leetcode;

public class P_1423_Maximum_Points_You_Can_Obtain_from_Cards {

    public int maxScore(int[] cardPoints, int k) {

        Integer maxSum = 0;

        int accSum[] = new int[cardPoints.length];
        accSum[0] = cardPoints[0];

        for (int i = 1; i < accSum.length; i++) {
            accSum[i] = accSum[i - 1] + cardPoints[i];
        }

        if (k >= cardPoints.length) {
            return accSum[accSum.length - 1];
        }

        int diff;
        maxSum = accSum[k - 1];
        for (int i = accSum.length - k; i < accSum.length; i++) {
            diff = accSum[accSum.length - 1] - accSum[i - 1];
            int distance = accSum.length - i;
            if (k - distance > 0)
                diff += accSum[k - distance - 1];
            maxSum = Math.max(maxSum, diff);
        }

        return maxSum;
    }

    // New trick to calculate accumlation sum without any array and keep the
    // operation O(N) for slinding window
    // ---------------------------------100 sum
    // ------------------------97,98,99,100 miniSum (sum of -- ie.1-95)
    // Subtract miniSum from sum to get sum of window of size 4 here
    // for next window
    // to calculate sum for next window add first elemet 96 to minisum and subtract
    // last element of new window
    // 1-------------------------,98,99,100
    // Calculate and repeat
    // src: Youtube [https://www.youtube.com/c/AlgorithmsMadeEasy/videos]
    public int smartSolution(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        int miniSum = 0;
        for (int i = 0; i < cardPoints.length - k; i++) {
            miniSum += cardPoints[i];
        }
        int maxSum = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            maxSum = Math.max(maxSum, sum - miniSum);
            miniSum += cardPoints[i];
            miniSum -= cardPoints[i - (cardPoints.length - k)];
        }
        maxSum = Math.max(maxSum, sum - miniSum);

        return maxSum;
    }

    public static void main(String[] args) {
        int[] ar = new int[] { 1, 79, 80, 1, 1, 1, 200, 1 };
        // ar = new int[] { 1, 2, 3, 4, 5, 6, 1 };
        ar = new int[] { 100, 4, 17, 9, 73, 75 };
        ar = new int[] { 96, 90, 41, 82, 39, 74, 64, 50, 30 };

        P_1423_Maximum_Points_You_Can_Obtain_from_Cards handler = new P_1423_Maximum_Points_You_Can_Obtain_from_Cards();
        int maxSum = handler.maxScore(ar, 8);
        System.out.println(maxSum);
        System.out.println(handler.smartSolution(ar, 8));

    }
}
