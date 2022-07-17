class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length/2;
        int num = nums[index];
        if(num > target) {
            while(num > target && index > 0){
                //System.out.println(num + " > " + target + " && " + index + " > 0");
                num = nums[--index];
                //System.out.println("num is " + num + " index is " + index);

            }
            if(num < target) index++;
            
        } 
        else if (num < target) {
            while(num < target && index < nums.length - 1){
                //System.out.println(num + " > " + target + " && " + index + " < " + nums.length);
                num = nums[++index];   
                //System.out.println("num is " + num + " index is " + index);
            }
            if(num < target) index++;

        } else {
            //nums[index] == target
        }
        return index;
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m = (l + h) / 2;    
        while(l <= h) {
            m = (l + h) / 2;    
            if(target > nums[m] ) {
                l = m + 1;
            } else if (target < nums[m]) {
                h = m - 1;
            } else {
                break;
            }
            
            if (l > h) return l;
            if (h < l) return h;
        }
        return m;
    }
}
