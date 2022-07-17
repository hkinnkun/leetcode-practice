class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j =0; i < nums.length && j < nums.length; ){
            if(nums[i] == 0){
                while(j < nums.length) {
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    } else {
                        j++;
                    }
                }
            } else {
                j++;
                i++;
            }
        }
        
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 ) {
                nums[lastNonZero++] = nums[i];
            }
        } //swap all non zero to front
        for(int i = lastNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }//put back the zero at later part
    }
}

