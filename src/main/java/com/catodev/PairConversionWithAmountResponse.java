package com.catodev;

public record PairConversionWithAmountResponse(
        String result,
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result
) {}
