class Solution {
    //https://www.electronics-tutorials.ws/combination/comb_7.html
    /**
    C-in	B	A	Sum	C-out
        0	0	0	0	0
        0	0	1	1	0
        0	1	0	1	0
        0	1	1	0	1
        1	0	0	1	0
        1	0	1	0	1
        1	1	0	0	1
        1	1	1	1	1
        **/
    class BinaryAdditionHandler{
        boolean carryIn;
        boolean a;
        boolean b;
        boolean sum;
        boolean carryOut;
        
        BinaryHandler(boolean carryIn, boolean a, boolean b){
            this.carryIn = carryIn;
            this.a = a;
            this.b = b;
            calculate();
        }
        private void calculate(){
            if(!carryIn && !a && !b) {
                this.sum = false;
                this.carryOut = false;
            }
            if(!carryIn && a && !b) {
                this.sum = true;
                this.carryOut = false;
            }
            if(!carryIn && !a && b) {
                this.sum = true;
                this.carryOut = false;
            }
            if(!carryIn && a && b) {
                this.sum = false;
                this.carryOut = true;
            }
            if(carryIn && !a && !b) {
                this.sum = true;
                this.carryOut = false;
            }
            if(carryIn && a && !b) {
                this.sum = false;
                this.carryOut = true;
            }
            if(carryIn && !a && b) {
                this.sum = false;
                this.carryOut = true;
            }
            if(carryIn && a && b) {
                this.sum = true;
                this.carryOut = true;
            }
        }
    }
    
    public String addBinary(String a, String b) {
        int length = -1;
        if(a.length() >= b.length()){
            length = a.length();
        } else {
            length = b.length();
        }
        boolean[] a_bits = new boolean[length];
        boolean[] b_bits = new boolean[length];
        //set up the a and b bit arrays
        int j = length - 1;
        for(int i = a.length() - 1; i >= 0 ; i--){
            a_bits[j] = charToBoolean(a.charAt(i));
            j--;
        }
        j = length - 1;
        for(int i = b.length() - 1; i >= 0 ; i--){
            b_bits[j] = charToBoolean(b.charAt(i));
            j--;
        }
        
        //add
        boolean carryIn = false;
        //boolean carryOut = false;
        List<Boolean> result_reversed = new ArrayList<>();
        for (int i = length - 1; i >= 0 ; i--) {
            BinaryAdditionHandler bh = new BinaryAdditionHandler(carryIn, a_bits[i], b_bits[i]);
            carryIn = bh.carryOut;
            result_reversed.add(bh.sum);
        }
        //See if any carryIn
        if(carryIn) {
            BinaryAdditionHandler bh = new BinaryAdditionHandler(carryIn, false, false);
            result_reversed.add(bh.sum);
        }
        StringBuilder resultBuilder = new StringBuilder();
        for(int i = result_reversed.size() - 1; i>=0; i--){
            resultBuilder.append(result_reversed.get(i) ? "1" : "0");
        }
        return resultBuilder.toString();
    }
    
    private void print(boolean[] b){
        System.out.print("boolean array:");
        for (int i = 0 ; i < b.length; i++){
            System.out.print(i + ":" + b[i] + ",");
        }
        System.out.println("");
    }
    
    private boolean charToBoolean(char c){
        if(c == '1') return true;
        return false;
    }
}