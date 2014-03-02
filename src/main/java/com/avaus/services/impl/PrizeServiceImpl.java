package com.avaus.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avaus.domain.ChannelPackage;
import com.avaus.domain.Prize;
import com.avaus.services.EligibilityService;
import com.avaus.services.PrizeService;
import com.avaus.services.exceptions.InvalidAccountNumberException;
import com.avaus.services.exceptions.TechnicalFailureException;

/**
 * This class represents a concrete implementation of the {@link PrizeService} interface.
 *
 *  @author Cipriano Sanchez
 */
public class PrizeServiceImpl implements PrizeService
{
    @Autowired
    private EligibilityService eligibilityService;

    @Override
    public List<Prize> getPrizesForCustomer(final String accountNumber, final List<ChannelPackage> channelPackages)
            throws InvalidAccountNumberException
    {
        List<Prize> prizeList = new ArrayList<>();

        try
        {
            for (ChannelPackage channelPackage : channelPackages)
            {
                if (eligibilityService.getEligibilityStatus(accountNumber))
                {
                    prizeList.addAll(channelPackage.getPrizes());
                }
            }
        }
        catch (TechnicalFailureException e)
        {
            return new ArrayList<>();
        }

        return prizeList;
    }

}
