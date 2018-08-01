package AM;

import java.util.HashMap;

public class LC166FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder left = new StringBuilder();
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        if ((numerator ^ denominator) < 0) {
            left.append("-");
        }
        left.append(num / den);
        long remain = num % den;
        if (remain == 0) return left.toString();
        left.append(".");
        StringBuilder decimalPart = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();

        while (remain != 0) {
            if (!map.containsKey(remain)) {
                map.put(remain, decimalPart.length());
                long decimalVal = remain * 10 / den;
                decimalPart.append(decimalVal);
                remain = (remain * 10) % den;
            } else {
                //insert "(" and ")"
                decimalPart.insert(map.get(remain), "(");
                decimalPart.append(")");
                break;
            }
        }
        return left.toString() + decimalPart.toString();
    }
}
