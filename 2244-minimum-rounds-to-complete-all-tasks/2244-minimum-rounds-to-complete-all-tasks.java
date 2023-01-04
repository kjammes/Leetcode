class Solution {
    public int minimumRounds(int[] tasks) {
        if(tasks.length <= 1)
            return -1;
        
        Map<Integer, Long> map = Arrays.stream(tasks)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        
        int result = 0;
        for(Map.Entry<Integer, Long> entry : map.entrySet()) {
            long val = entry.getValue();
            if (val == 1) return -1;
            
            result += val / 3;
            System.out.println(val / 3);
            
            System.out.println(val % 3);
            if (val % 3 != 0) result++;
        }
        
        System.out.println(map);
        
        return result;
    }
}