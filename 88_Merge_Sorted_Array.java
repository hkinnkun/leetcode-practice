class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums1 = new int[m];
        for(int i = 0; i < m; i++){
            tempNums1[i] = nums1[i];
        } //copy the nums1 to temp array, then use two pointer approach to select number from both array
        int pointer1 = 0;
        int pointer2 = 0;
        for(int i = 0; i < m+n; i++) {
            if(pointer1 < m && pointer2 < n) {
                if(tempNums1[pointer1] > nums2[pointer2]) {
                    nums1[i] = nums2[pointer2++];
                } else {
                    nums1[i] = tempNums1[pointer1++];
                }
            } else if (pointer1 >= m && pointer2 < n) {
                nums1[i] = nums2[pointer2++];
            } else {
                nums1[i] = tempNums1[pointer1++];
            }
        }
    }
}
