package com.tdxk.dp;

import com.tdxk.dp.factory.StrategyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lin.
 */
@SpringBootTest
public class DpApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(StrategyFactory.getPriceStrategyByUserType(1).calculatePrice(100));
    }
}