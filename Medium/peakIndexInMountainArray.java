class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in decreasing part of array
                //this may be answer but look at left
                end=mid;
            }
            else{
                //you are in ascending part of array
                start=mid+1;// because we know that mid+1 ele is greater than mid
            }
        }
        // in the end, start==end and pointing to the largest element because of two chwecks
        // start and end are always trying to find max eleement in the above two checks
        //hence they are pointing to just one element, that is the max one because that is what checks say
        //at every point of time for start and end they have the best possible ans till that time
        // and if we are saying only one item is remaining, hence cause of above line then that is the best possible ans
        return start; // or end as both are equal
    }
}
