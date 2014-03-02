package com.avaus.services;

import com.avaus.services.exceptions.InvalidAccountNumberException;

/**
 * This interface represents the contract to follow for all classes that
 * want to implement eligibility functionality.
 *
 * @author Cipriano Sanchez
 */
public interface EligibilityService
{
    /**
     * Checks if a <code>Customer</code> is eligible for winning a prize.
     *
     * @param accountNumber The account number of the <code>Customer</code> for whom the eligibility wants to be checked.
     * @return <code>true</code> if the <code>accountNumber</code> belongs to a <code>Customer</code> who is eligible to choose
     * a prize. Otherwise <code>false</code>.
     * @throws InvalidAccountNumberException if there are no <code>Customer</code>s with the given <code>accountNumber</code>.
     * @throws com.avaus.services.exceptions.TechnicalFailureException Unchecked exception for conditions unlikely to recover.
     */
    boolean getEligibilityStatus(String accountNumber) throws InvalidAccountNumberException;
}
