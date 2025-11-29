package com.catodev.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record LatestRateResponse(
   String result,
   String baseCode,
   @SerializedName("conversion_rates") Map<String, Double> conversionRates
) {}
