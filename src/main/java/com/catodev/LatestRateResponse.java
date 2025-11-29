package com.catodev;

import java.util.Map;

public record LatestRateResponse(
   String result,
   String baseCode,
   Map<String, Double> conversionRates
) {}
