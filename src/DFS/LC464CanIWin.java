package DFS;

public class LC464CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        int status = (1 << maxChoosableInteger) - 1;

        return dfs(0, desiredTotal, maxChoosableInteger, status, new Boolean[status + 1]);
    }

    private boolean dfs(int curSum, int target, int maxChoosableInteger, int status, Boolean[] mem) {
        if (mem[status] != null) return mem[status];
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = (1 << (i - 1));
            if ((status & mask) != 0) { //means available to choose i
                if (curSum + i >= target) {
                    mem[status] = true;
                    return true;
                }
                //int newStatus = status - mask;
                if (!dfs(curSum + i, target, maxChoosableInteger, status - mask, mem)) {
                    mem[status] = true;
                    return true;
                }
            }
        }
        mem[status] = false;
        return false;
    }

}
