class Solution {
    public int minMoves(int[] nums) {
        int maxVal = nums[0];
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        
        int moves = 0;
        for (int x : nums) {
            moves += maxVal - x;
        }
        return moves;
    }
}