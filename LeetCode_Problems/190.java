public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result <<= 1;          // Left shift result to make room for the next bit
            result |= (n & 1);     // Add the least significant bit of n
            n >>>= 1;              // Unsigned right shift n
        }
        return result;
    }
}
