package com.avaus.services;

import com.avaus.domain.ChannelPackage;
import com.avaus.domain.Prize;
import com.avaus.services.exceptions.InvalidAccountNumberException;

import java.util.List;

/**
 * This interface represents the contract to follow for all classes that
 * want to implement functionality related to Prize Service.
 *
 * @author Cipriano Sanchez
 */
public interface PrizeService
{
    /**
     * For a given <code>Customer</code>'s account number and its respective list of subscribed channel packages,
     * this method will provide the list of prizes the <code>Customer</code> can choose from.
     *
     * @param accountNumber The account number of the <code>Customer</code> for whom the eligibility wants to be checked.
     * @param channelPackages A list of the channel packages the user is subscribed to.
     * @return <code>true</code> if the <code>accountNumber</code> belongs to a <code>Customer</code> who is eligible to choose
     * a prize. Otherwise <code>false</code>.
     * @throws InvalidAccountNumberException if there are no <code>Customer</code>s with the given <code>accountNumber</code>.
     */
    List<Prize> getPrizesForCustomer(String accountNumber, List<ChannelPackage> channelPackages) throws InvalidAccountNumberException;
}
