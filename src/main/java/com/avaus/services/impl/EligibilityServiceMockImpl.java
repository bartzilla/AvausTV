package com.avaus.services.impl;

import java.util.Random;

import com.avaus.services.EligibilityService;
import com.avaus.services.exceptions.InvalidAccountNumberException;
import org.apache.commons.lang3.StringUtils;

/**
 * This class represents a concrete Mock implementation of the {@link EligibilityService} interface.
 *
 *  @author Cipriano Sanchez
 */
public class EligibilityServiceMockImpl implements EligibilityService
{
    @Override
    public boolean getEligibilityStatus(final String accountNumber) throws InvalidAccountNumberException
    {
        if(StringUtils.isNotBlank(accountNumber))
        {
            return new Random().nextBoolean();
        }

        throw new InvalidAccountNumberException();
    }
}
