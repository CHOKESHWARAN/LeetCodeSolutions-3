
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            calc(landStartTime, landDuration, waterStartTime, waterDuration),
            calc(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    int calc(int[] s1, int[] d1, int[] s2, int[] d2) {
        int end = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;

        for (int i = 0; i < s1.length; i++)
            end = Math.min(end, s1[i] + d1[i]);

        for (int i = 0; i < s2.length; i++)
            ans = Math.min(ans, Math.max(end, s2[i]) + d2[i]);

        return ans;
    }
}
