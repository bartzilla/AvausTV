package com.avaus.client;

import java.util.ArrayList;
import java.util.List;

import com.avaus.domain.Customer;
import com.avaus.strategies.AwardStrategy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avaus.domain.ChannelPackage;
import com.avaus.domain.Prize;
import com.avaus.domain.chanelpackages.MoviesPackage;
import com.avaus.domain.chanelpackages.SportsPackage;
import com.avaus.services.PrizeService;
import com.avaus.services.exceptions.InvalidAccountNumberException;

/**
 *  Demo Harness class to visualize prizes for a customer.
 *
 *  @author Cipriano Sanchez
 */
class HarnessClient
{
    public static void main(String args[])
    {
        // Get the spring application context
        final AbstractApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");

        // Get the award strategies & prizeService
        final AwardStrategy sportsAwardStrategy = (AwardStrategy)factory.getBean("sportsAwardStrategy");
        final AwardStrategy emptyStrategy = (AwardStrategy)factory.getBean("emptyStrategy");
        final AwardStrategy moviesAwardStrategy = (AwardStrategy)factory.getBean("moviesAwardStrategy");
        final PrizeService prizeService = (PrizeService) factory.getBean("prizeService");

        // Create some channel packages and provide them a strategy for retrieving prizes
        final MoviesPackage moviePackage = new MoviesPackage(moviesAwardStrategy);
        final SportsPackage sportsPackage = new SportsPackage(sportsAwardStrategy);

        // Add the channel into a list of ChannelPackages
        final List<ChannelPackage> channelPackages = new ArrayList<>();
        channelPackages.add(sportsPackage);
        channelPackages.add(moviePackage);

        // Create a customer & assign him some ChannelPackages
        final Customer customer = new Customer("12345", channelPackages);

        // This list will hold the available prizes a given customer can choose from
        List<Prize> prizesForCustomer = new ArrayList<>();

        try
        {
            prizesForCustomer = prizeService.getPrizesForCustomer(customer.getAccountNumber(), customer.getChannelPackages());
        }
        catch (InvalidAccountNumberException e)
        {
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------------------------------------------------");

        if(!prizesForCustomer.isEmpty())
        {
            System.out.println("These are the prizes Customer with account number " + customer.getAccountNumber()
                    + " has won and is entitled to choose from\n");

            for (Prize prize : prizesForCustomer)
            {
                System.out.println(prize.getDescription());
            }
        }
        else
        {
            System.out.println("Unfortunately Customer with account number " + customer.getAccountNumber()
                    + " has not won any prize\n");
        }

        System.out.println("------------------------------------------------------------------------------------------------");

    }
}
