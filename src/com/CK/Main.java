package com.CK;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        int number = 2047483647;
        int number = 1000010;
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(number));
    }
}

class Solution {
    private Map<Integer, String> dict;
    private StringBuilder res;

    public String numberToWords(int num) {
        res = new StringBuilder();
        if (num < 0) return res.toString();
        if (num == 0) return res.append("Zero").toString();
        this.dict = new HashMap<>();
        dict.put(1, "One");
        dict.put(2, "Two");
        dict.put(3, "Three");
        dict.put(4, "Four");
        dict.put(5, "Five");
        dict.put(6, "Six");
        dict.put(7, "Seven");
        dict.put(8, "Eight");
        dict.put(9, "Nine");
        dict.put(10, "Ten");
        dict.put(11, "Eleven");
        dict.put(12, "Twelve");
        dict.put(13, "Thirteen");
        dict.put(14, "Fourteen");
        dict.put(15, "Fifteen");
        dict.put(16, "Sixteen");
        dict.put(17, "Seventeen");
        dict.put(18, "Eighteen");
        dict.put(19, "Nineteen");
        dict.put(20, "Twenty");
        dict.put(30, "Thirty");
        dict.put(40, "Forty");
        dict.put(50, "Fifty");
        dict.put(60, "Sixty");
        dict.put(70, "Seventy");
        dict.put(80, "Eighty");
        dict.put(90, "Ninety");
        dict.put(100, "Hundred");
//        dict.put(1000, "Thousand");
//        dict.put(1000000, "Million");
//        dict.put(1000000000, "Billion");
        int billion = num / 1000000000;
        if (billion != 0) res.append(dict.get(billion)).append(" ").append("Billion ");
        int billionRes = num - billion * 1000000000;
        int million = billionRes / 1000000;
        if (million != 0) res.append(numberInOneThousandToEnglishWords(million)).append("Million ");
        int millionRes = billionRes - million * 1000000;
        int thousand = millionRes / 1000;
        if (thousand != 0) res.append(numberInOneThousandToEnglishWords(thousand)).append("Thousand ");
        int thousandRes = millionRes - thousand * 1000;
        res.append(numberInOneThousandToEnglishWords(thousandRes));
        return res.toString().trim();

    }

    private StringBuilder numberInOneThousandToEnglishWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return sb;
        int hundred = num / 100;
        int hundredRes = num % 100;
        if (hundred != 0) sb.append(dict.get(hundred)).append(" ").append(dict.get(100)).append(" ");
        if (hundredRes == 0) return sb;
        int tensDigit = hundredRes / 10;
        int digit = hundredRes % 10;
        if (digit == 0) {
            sb.append(dict.get(tensDigit * 10)).append(" ");
            return sb;
        }
        if (tensDigit != 0) {
            if (tensDigit == 1) {
                sb.append(dict.get(tensDigit * 10 + digit)).append(" ");
                return sb;
            } else {
                sb.append(dict.get(tensDigit * 10)).append(" ");
            }
        }
        sb.append(dict.get(digit)).append(" ");
        return sb;
    }

}