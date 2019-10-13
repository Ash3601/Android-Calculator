package com.example.calculator;

import java.math.BigInteger;

public final class FunctionsEvaluator {
    public static String factorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        return fact.toString();
    }
}
