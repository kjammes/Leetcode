class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        
        if(n == Integer.MIN_VALUE) {
          x = x * x;
          n = n/2;
        }
        
        if(n < 0) {
          x = 1/x;
          n = -n;
        }
        
        double temp = myPow(x, n/2);

        return n%2 == 0 ? temp * temp : temp * temp * x;
    }
}