package com.avaus.domain.chanelpackages;

import com.avaus.domain.ChannelPackage;
import com.avaus.strategies.AwardStrategy;

/**
 * Concrete class to represent the Movies Package.
 *
 *  @author Cipriano Sanchez
 */
public class MoviesPackage  extends ChannelPackage
{
    public MoviesPackage(){}

    public MoviesPackage(AwardStrategy awardable)
    {
        super(awardable);
    }

    @Override
    public String toString()
    {
        return "Movies Package";
    }
}
