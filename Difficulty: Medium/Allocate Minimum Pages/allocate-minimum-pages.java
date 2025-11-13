import java.util.*;
class Solution {
    public int countstudents(int arr[],int pages){
        int students=1;
        int n=arr.length;
        int pagestudents=0;
        
        for(int i=0;i<n;i++){
           if(pagestudents+arr[i]<=pages){
               pagestudents+=arr[i];
           }else{
               students++;
               pagestudents=arr[i];//new student allocate
           }
        }
        return students;
    } 
    public int findPages(int[] arr, int k) {
        int n=arr.length;
        if(k>n){
            return -1;
        }
        int l = Arrays.stream(arr).max().getAsInt();  
        int h = Arrays.stream(arr).sum(); 
        while(l<=h){
            int m=(l+h)/2;
            int students=countstudents(arr,m);
            if(students>k){
                l=m+1;//increse the book pages 
            }else{
                h=m-1;//decrse the pages
            }
        }
        return l;
        // code here
        
    }
}