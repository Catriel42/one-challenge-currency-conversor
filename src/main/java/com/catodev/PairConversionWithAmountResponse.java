package com.catodev;

public record PairConversionWithAmountResponse(
        String result,
        String baseCode,
        String targetCode,
        double conversionRate,
        double conversionResult
) {}
