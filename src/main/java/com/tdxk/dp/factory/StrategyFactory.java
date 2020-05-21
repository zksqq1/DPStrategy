package com.tdxk.dp.factory;

import com.tdxk.dp.annotation.UserTypeAnnotation;
import com.tdxk.dp.stragery.PriceStrategy;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author lin.
 */
@Component
public class StrategyFactory implements CommandLineRunner, ApplicationContextAware {
    private volatile ApplicationContext applicationContext;
    private static HashMap<Integer, PriceStrategy> userTypeStrategyMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) {
        initUserTypeStrategyMap();
    }

    private void initUserTypeStrategyMap() {
        Collection<PriceStrategy> userTypeStrategyList = this.applicationContext.getBeansOfType(PriceStrategy.class).values();
        userTypeStrategyMap = new HashMap<>(userTypeStrategyList.size());
        for (PriceStrategy strategy : userTypeStrategyList) {
            Class<? extends PriceStrategy> aClass = strategy.getClass();
            UserTypeAnnotation annotation = aClass.getAnnotation(UserTypeAnnotation.class);
            if (annotation != null) {
                userTypeStrategyMap.put(annotation.userType(), strategy);
            }
        }
    }


    //通过这个方法获取对应的价格计算策略实现类
    public static PriceStrategy getPriceStrategyByUserType(Integer userType) {
        PriceStrategy strategy = userTypeStrategyMap.get(userType);
        if (strategy == null) {
            throw new RuntimeException("不支持的用户类型");
        }
        return strategy;
    }
}
