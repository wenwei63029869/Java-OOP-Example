package com.wei;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by weiwen on 9/24/16.
 */
public class RoundNumber {
    public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
        if (increment.signum() == 0) {
            // 0 increment does not make much sense, but prevent division by 0
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            BigDecimal result = divided.multiply(increment);
            return result;
        }
    }
}
