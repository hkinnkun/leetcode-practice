class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++ ) {
            if(n == 0) return true;
            if(i == 0 && i+1 >= flowerbed.length) { //for array size = 1
                if(flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    continue;
                }
            }
            if(i == 0 && i+1 < flowerbed.length) { //for index = 0, array size > 1
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    continue;
                }
            }
            
            if(i > 0 && i+1 <= flowerbed.length-1) { //for non edege case
                if(flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    continue;
                }
            }
            
            if(i > 0 && i == flowerbed.length - 1) { //for index at last element
                if(flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    continue;
                }
            }

        }
        if(n == 0) return true;
        return false;
    }
}