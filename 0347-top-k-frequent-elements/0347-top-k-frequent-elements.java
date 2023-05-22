class Solution {
    // public int[] topKFrequents(int[] nums, int k) {
    //     int[] res = new int[k];
    //     Map<Integer, Integer> freq = new HashMap<>();
    //     for (int el: nums) {
    //         freq.put(el, freq.getOrDefault(el, 0) + 1);
    //     }

    //     List<Integer> buckets[] = new ArrayList[nums.length + 1];
    //     for (int el: freq.keySet()) {
    //         int val = freq.get(el);
    //         if (buckets[val] == null)
    //             buckets[val] = new ArrayList<>();
    //         buckets[val].add(el);
    //     }

    //     int idx = 0;
    //     for (int i = buckets.length - 1; i >= 0; i--) {
    //         if (buckets[i] == null)
    //             continue;

    //         for (int el: buckets[i]) {
    //             res[idx++] = el;
    //             if (idx == k)
    //                 return res;
    //         }
    //     }

    //     return res;
    // }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int el: nums) {
            freq.put(el, freq.getOrDefault(el, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer> > queue = new PriorityQueue<>( (a, b)
                    -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
                           : Integer.compare(b.getValue(), a.getValue())
        );
        for (Map.Entry<Integer, Integer> el: freq.entrySet())
            queue.offer(el);

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }
}