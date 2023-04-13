class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        int popP = 0, pushP = 0;;
        
        for (int el: pushed) {
            pushed[pushP++] = el;
            while ( 
                pushP > 0 && 
                pushed[pushP - 1] == popped[popP]
            ) {
                pushP--;
                popP++;
            }
        }
        
        return pushP == 0;
    }
}