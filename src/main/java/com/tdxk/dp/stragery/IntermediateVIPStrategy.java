package com.tdxk.dp.stragery;

import com.tdxk.dp.annotation.UserTypeAnnotation;
import org.springframework.stereotype.Component;

/**
 * @author lin.
 */
@Component
@UserTypeAnnotation(userType = 2)
//中级会员
public class IntermediateVIPStrategy implements PriceStrategy {
    public double calculatePrice(double cost) {
        return cost * 0.8;
    }
}
