package org.example;

public class LargestRectangleInHistogram {
    public int solution (int[] height){
        int [] lessThanLeft = new int[height.length];
        int [] lessThanRight = new int[height.length];

        int ans = 0;
        lessThanLeft[0] = 0;
        lessThanRight[height.length-1] = height.length-1;

        for (int i = 1; i <= height.length-1; i++){
            int p = i;
            for (int j = i-1; j>=0; j--){
                if (height[j] > height[i]){
                    p = lessThanLeft[p-1];
                }
                lessThanLeft[i] = p;
            }
        }
        for (int i = height.length-2; i>=0; i--){
            int p = i;
            for (int j = i+1; j <= height.length-1; j++){
                if (height[j] > height[i]){
                    p = lessThanRight[p+1];
                }
                lessThanRight[i] = p;
            }
        }
        for (int i = 0; i<= height.length-1; i++){
            ans += height[i] * (lessThanRight[i] - lessThanLeft[i] +1);
        }
        return ans;
    }
}
