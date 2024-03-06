package org.lld.factory;

import org.lld.strategy.AbsoluteSplitStrategy;
import org.lld.strategy.EqualSplitStrategy;
import org.lld.strategy.ISplitStrategy;
import org.lld.strategy.PercentageSplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class SplitStrategyFactory {

    List<ISplitStrategy> splitStrategies;
    public SplitStrategyFactory() {
        splitStrategies = new ArrayList<>();
        splitStrategies.add(new AbsoluteSplitStrategy());
        splitStrategies.add(new EqualSplitStrategy());
        splitStrategies.add(new PercentageSplitStrategy());
    }

    public ISplitStrategy getStrategyByName(String strategyName) {
        for (ISplitStrategy strategy: splitStrategies) {
            if (strategy.getSplitType().name().equals(strategyName)) {
                return strategy;
            }
        }
        return null;
    }
}
