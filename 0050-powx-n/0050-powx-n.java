class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return dfs(x,N); 
    }
    double dfs(double x, long n){
        if (n == 0) return 1.0;
        if (n < 0) return 1.0 / dfs(x, -n);
        if (n % 2 == 0) {
            return dfs(x * x, n / 2);
        } else {
            return x * dfs(x * x, n / 2);
        }
    }
}