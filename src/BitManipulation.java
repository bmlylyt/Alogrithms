public class BitManipulation {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        if (n == 0 || n == -1) return n;
        int mask = 1;
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            int temp = ((n >> i) & mask);
            res |= (temp <<(31 - i));
        }
        return res;
    }

    public static void main(String[] args) {
        int test = 1;
        test = ~test;
        System.out.println(Integer.MAX_VALUE);
    }
}
