class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            totalTank += gain;
            currTank += gain;

            // If currTank is negative, reset startIndex to i+1
            if (currTank < 0) {
                currTank = 0;
                startIndex = i + 1;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}
