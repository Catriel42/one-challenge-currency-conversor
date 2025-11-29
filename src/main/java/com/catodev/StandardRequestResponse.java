package com.catodev;

import java.util.Map;

public record StandardRequestResponse(
   String result,
   String baseCode,
   Map<String, Double> conversionRates
) {}
