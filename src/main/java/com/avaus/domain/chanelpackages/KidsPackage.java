package com.avaus.domain.chanelpackages;

import com.avaus.domain.ChannelPackage;
import com.avaus.strategies.AwardStrategy;

/**
 * Concrete class to represent the Kids Package.
 *
 *  @author Cipriano Sanchez
 */
public class KidsPackage  extends ChannelPackage
{
    public KidsPackage(AwardStrategy awardable)
    {
        super(awardable);
    }

    @Override
    public String toString()
    {
        return "Kids Package";
    }
}
