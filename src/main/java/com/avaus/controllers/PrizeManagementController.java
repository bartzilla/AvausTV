package com.avaus.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avaus.domain.ChannelPackage;
import com.avaus.domain.Prize;
import com.avaus.domain.chanelpackages.MoviesPackage;
import com.avaus.domain.chanelpackages.SportsPackage;
import com.avaus.services.PrizeService;
import com.avaus.services.exceptions.InvalidAccountNumberException;
import com.avaus.strategies.AwardStrategy;

/**
 * Controller in charge of rendering a sample demo UI to test what the PrizeService returns.
 *
 *  @author Cipriano Sanchez
 */
@Controller
public class PrizeManagementController
{
    @Autowired
    private PrizeService prizeService;

    @Autowired
    private AwardStrategy moviesAwardStrategy;

    @Autowired
    private AwardStrategy sportsAwardStrategy;

    @RequestMapping(value = "/findPrizesForCustomer", method = RequestMethod.POST)
    public ModelAndView findPrizesForCustomer(@RequestParam("ACCOUNT_NUMBER") final String accountNumber) throws InvalidAccountNumberException
    {
        // In here a service that only retrieves a Customer object with its associated List<ChannelPackage> as a field
        // would be very handy. In doing so getPrizesForCustomer could resolve all Customer's Channels.

        List<Prize> allPrizes = prizeService.getPrizesForCustomer(accountNumber, getChannelPackages());

        if (allPrizes.isEmpty())
        {
            return new ModelAndView("/index.jsp", "message", "The given customer doesn't have any awarded prizes");
        }

        return new ModelAndView("/displayAllPrizes.jsp", "allPrizes", allPrizes);
    }

    @ExceptionHandler(InvalidAccountNumberException.class)
    public ModelAndView handleException(final InvalidAccountNumberException ex)
    {
        return new ModelAndView("/index.jsp", "message", ex.getMessage());
    }

    private List<ChannelPackage> getChannelPackages()
    {
        // Create some channel packages and provide them a strategy for retrieving prizes
        final ChannelPackage moviePackage = new MoviesPackage(moviesAwardStrategy);
        final ChannelPackage sportsPackage = new SportsPackage(sportsAwardStrategy);

        // Add the channel into a list of ChannelPackages
        final List<ChannelPackage> channelPackages = new ArrayList<>();
        channelPackages.add(sportsPackage);
        channelPackages.add(moviePackage);

        return channelPackages;
    }
}
