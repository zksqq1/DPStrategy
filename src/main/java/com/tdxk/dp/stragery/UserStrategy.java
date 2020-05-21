package com.tdxk.dp.stragery;

import com.tdxk.dp.annotation.UserTypeAnnotation;
import org.springframework.stereotype.Component;

/**
 * @author lin.
 */
@Component
@UserTypeAnnotation(userType = 4)
//普通用户
public class UserStrategy implements PriceStrategy {
    public double calculatePrice(double cost) {
        return cost;
    }
}
