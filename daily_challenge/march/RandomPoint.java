class Solution {
    Random random;
    double xmin,ymin, xmax,ymax;
    double r;
    double x,y;
    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        // yrandom = new Random();
        
        xmin = x_center-radius;
        xmax = x_center+radius;
        
        ymin = y_center-radius;
        ymax = y_center+radius;
        r = r;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        
        double[] ans = new double[2];
        
        ans[0] = xmin + (xmax - xmin) * random.nextDouble();
        ans[1] = ymin + (ymax - ymin) * random.nextDouble();
        
        while((ans[0] - x) * (ans[0] - x) + (ans[1] - y) * (ans[1] - y) > r * r){
            ans[0] = xmin + (xmax - xmin) * random.nextDouble();
            ans[1] = xmin + (xmax - xmin) * random.nextDouble();
        }
        
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
