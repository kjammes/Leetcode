class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] paths = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[k - 1] = 0;

        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.copyOf(paths, n);

            for (int[] time : times) {
                int src = time[0] - 1; // Adjust for 0-based index
                int tgt = time[1] - 1; // Adjust for 0-based index
                int travelTime = time[2];

                if (temp[src] != Integer.MAX_VALUE && temp[src] + travelTime < temp[tgt]) {
                    temp[tgt] = temp[src] + travelTime;
                }
            }

            paths = temp;
        }

        int result = -1;

        for (int path : paths) {
            if (path == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, path);
        }

        return result;
    }
}
