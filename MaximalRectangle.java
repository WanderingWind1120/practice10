package org.example;

public class MaximalRectangle {
    public int solutioni (int[][] matrix){
        int[] height = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i<= matrix.length-1; i++){
            for (int j = 0; j <= matrix[0].length-1; j++){
                if (matrix[i][j] == 0){
                    height[j] = 0;
                    continue;
                }
                height[j]++;

                for (int cur = j - 1, pre = height[j]; cur >= 0; cur --){
                    if (height[cur] == 0){
                        break;
                    }
                    pre = Math.min(pre, height[cur]);
                    ans = Math.max(ans, pre * (j-cur +1));
                }
                ans = Math.max(ans,height[j]);
            }
        }
        return ans;
    }
}
