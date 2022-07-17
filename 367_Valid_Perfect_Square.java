class Solution {
    public boolean isPerfectSquare(int num) {
        long closestRoot = (long) Math.sqrt(num);    
        return num == closestRoot * closestRoot;
    }
}


class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
    //https://www.quora.com/What-is-the-relationship-between-odd-numbers-and-perfect-squares
    //n^2 = sum of first n odd number
}



class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long l = 0 ;
        long h = num;
        while (l < h) {
            long m = l + (h - l)/ 2;
            if(m == l || m == h) return false;
            long s = m * m;
            //System.out.println("l is " + l + " h is " + h + " m is " + m + " square is " +  s);
            if (s == num) return true;
            if (s < (long)num) l = m;
            if (s > (long)num) h = m;
        }
        return false;
    }
    //https://codereview.stackexchange.com/questions/204974/fastest-way-to-determine-if-a-number-is-perfect-square
}


class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long l = 1;
        long h = num;
        while (l <= h) {
            long m = l + (h - l)/ 2;
            long s = m * m;
            //System.out.println("l is " + l + " h is " + h + " m is " + m + " square is " +  s);
            if (s == num) return true;
            if (s < (long)num) l = m + 1;
            if (s > (long)num) h = m - 1;
        }
        return false;
    }
    //https://codereview.stackexchange.com/questions/204974/fastest-way-to-determine-if-a-number-is-perfect-square
}


class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long r = num / 2;
        long sq = r * r;
        while( sq > num ) {
            //System.out.println("r before is " +r);
            r = (r + (num / r)) / 2;
            //System.out.println("r is " +r);
            sq = r * r;
        }
        return sq == num;
    }
    //next = 0.5 * (X + (N / X))
    //newton's method
    //https://medium.com/edureka/java-sqrt-method-59354a700571
}
