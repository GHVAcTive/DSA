import java.util.regex.*;
import java.util.*;

class Solution {
    public String fractionAddition(String expression) {
        // Parse the expression using regex
        List<int[]> fractions = parseFractions(expression);
        
        int numerator = 0, denominator = 1;
        
        // Process each fraction
        for (int[] fraction : fractions) {
            int num = fraction[0];
            int den = fraction[1];
            
            // LCM to get common denominator
            int lcm = lcm(denominator, den);
            
            // Adjust numerators to the common denominator
            numerator = numerator * (lcm / denominator) + num * (lcm / den);
            
            // Update the denominator
            denominator = lcm;
        }
        
        // Simplify the result using GCD
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        
        return (numerator / gcd) + "/" + (denominator / gcd);
    }
    
    // Parse fractions using regex
    private List<int[]> parseFractions(String expression) {
        List<int[]> fractions = new ArrayList<>();
        
        // Regex to match fractions with signs
        Pattern pattern = Pattern.compile("([+-]?\\d+/\\d+)");
        Matcher matcher = pattern.matcher(expression);
        
        while (matcher.find()) {
            String fraction = matcher.group();
            
            // Split fraction into numerator and denominator
            String[] parts = fraction.split("/");
            int num = Integer.parseInt(parts[0]);
            int den = Integer.parseInt(parts[1]);
            
            fractions.add(new int[]{num, den});
        }
        
        return fractions;
    }
    
    // Function to calculate GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    // Function to calculate LCM
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
