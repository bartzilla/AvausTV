package com.avaus.domain.chanelpackages;

import com.avaus.domain.ChannelPackage;
import com.avaus.strategies.AwardStrategy;

/**
 * Concrete class to represent the Sports Package.
 *
 *  @author Cipriano Sanchez
 */
public class SportsPackage extends ChannelPackage
{
    public SportsPackage(){}

    public SportsPackage(AwardStrategy awardable)
    {
        super(awardable);
    }

    @Override
    public String toString()
    {
        return "Sports Package";
    }
}
