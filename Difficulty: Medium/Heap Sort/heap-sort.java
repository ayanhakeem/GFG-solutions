class Solution {
    public void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        
        int maxIdx=i;
        
        if(left<size && arr[maxIdx]<arr[left]){
            maxIdx=left;
        }
        if(right<size && arr[maxIdx]<arr[right]){
            maxIdx=right;
        }
        
        //swap
        if(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            
            heapify(arr,maxIdx,size);
            
        }
    }
    
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        //build max heap
        //swap first and last idx
        //call heapify
        
        int n=arr.length;
        //build max heap for last levels
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        //swap first and last 
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
        
        
        
    }
}