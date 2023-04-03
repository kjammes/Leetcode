class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0)
            return 0;

        Arrays.sort(people);
        
        int left = 0, right = people.length - 1;
        int boats = 0;
        
        while (left <= right) {
            int sum = people[left] + people[right];

            if (sum <= limit) {
                boats++;
                left++;
                right--;
            } else {
                boats++;
                right--;
            }
        }

        return boats;
    }
}