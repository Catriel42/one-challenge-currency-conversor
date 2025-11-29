package com.catodev.dto;

import com.google.gson.annotations.SerializedName;

public record PairConversionWithAmountResponse(
        String result,
        String baseCode,
        String targetCode,
        double conversionRate,
        @SerializedName("conversion_result") double conversionResult
) {}
