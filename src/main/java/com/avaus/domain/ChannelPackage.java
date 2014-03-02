package com.avaus.domain;

import com.avaus.strategies.AwardStrategy;
import com.avaus.strategies.impl.EmptyAwardStrategy;

import java.util.List;

/**
 *  Abstract class to represent Channel Packages.
 *
 *  @author Cipriano Sanchez
 */
public abstract class ChannelPackage
{
    private final AwardStrategy awardStrategy;

    public ChannelPackage()
    {
        this.awardStrategy = new EmptyAwardStrategy();
    }

    public ChannelPackage(AwardStrategy awardStrategy)
    {
        this.awardStrategy = awardStrategy;
    }

    public List<Prize> getPrizes()
    {
        return awardStrategy.getPrizeList();
    }
}
