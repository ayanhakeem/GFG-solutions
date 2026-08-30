import java.util.*;

 class Solution {

     public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

         int n = val.length;

         // Store {value, weight} together
         Integer[] index = new Integer[n];

         for (int i = 0; i < n; i++) {
             index[i] = i;
         }

         // Sort by value/weight ratio in descending order
         Arrays.sort(index, (a, b) -> {
             double ratio1 = (double) val[a] / wt[a];
             double ratio2 = (double) val[b] / wt[b];

             return Double.compare(ratio2, ratio1);
         });

         double maxValue = 0.0;
         int currentWeight = 0;

         for (int i = 0; i < n; i++) {

             int idx = index[i];

             // Take complete item
             if (currentWeight + wt[idx] <= capacity) {

                 currentWeight += wt[idx];
                 maxValue += val[idx];

             } 
             else {
                 // Take fractional part
                 int remaining = capacity - currentWeight;

                 maxValue += ((double) val[idx] / wt[idx]) * remaining;

                 break;
             }
         }

         return maxValue;
     }
 }