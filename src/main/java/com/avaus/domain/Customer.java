package com.avaus.domain;

import java.util.List;

/**
 * Concrete class to represent Customer objects.
 *
 *  @author Cipriano Sanchez
 */
public class Customer
{
    private String accountNumber;
    private List<ChannelPackage> channelPackages;

    public Customer(final String accountNumber, final List<ChannelPackage> channelPackages)
    {
        this.accountNumber = accountNumber;
        this.channelPackages = channelPackages;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public List<ChannelPackage> getChannelPackages()
    {
        return channelPackages;
    }
}
