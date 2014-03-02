package com.avaus.domain.chanelpackages;

import com.avaus.domain.ChannelPackage;
import com.avaus.strategies.AwardStrategy;

/**
 * Concrete class to represent the Gossips Package.
 *
 *  @author Cipriano Sanchez
 */
public class GossipsPackage extends ChannelPackage
{
    public GossipsPackage(AwardStrategy awardable)
    {
        super(awardable);
    }

    @Override
    public String toString()
    {
        return "Gossip Package";
    }
}
