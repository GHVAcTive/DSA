class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // Parse the first complex number
        int[] complex1 = parseComplex(num1);
        int a = complex1[0];
        int b = complex1[1];
        
        // Parse the second complex number
        int[] complex2 = parseComplex(num2);
        int c = complex2[0];
        int d = complex2[1];
        
        // Perform multiplication using the formula
        int realPart = a * c - b * d;
        int imaginaryPart = a * d + b * c;
        
        // Return result in the format "real+imaginaryi"
        return realPart + "+" + imaginaryPart + "i";
    }
    
    // Helper function to parse a complex number string
    private int[] parseComplex(String num) {
        String[] parts = num.split("\\+"); // Split at '+'
        int real = Integer.parseInt(parts[0]);
        int imaginary = Integer.parseInt(parts[1].replace("i", ""));
        return new int[]{real, imaginary};
    }
}
