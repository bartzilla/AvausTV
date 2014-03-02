package com.avaus.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.avaus.domain.ChannelPackage;
import com.avaus.domain.Customer;
import com.avaus.domain.Prize;
import com.avaus.domain.chanelpackages.GossipsPackage;
import com.avaus.domain.chanelpackages.MoviesPackage;
import com.avaus.domain.chanelpackages.SportsPackage;
import com.avaus.services.exceptions.InvalidAccountNumberException;
import com.avaus.services.impl.PrizeServiceImpl;
import com.avaus.strategies.AwardStrategy;

/**
 * Unit Test for PrizeService 
 *
 *  @author Cipriano Sanchez
 */
@RunWith(MockitoJUnitRunner.class)
public class PrizeServiceTest
{
    private static final String ACCOUNT_NUMBER = "12345";
    private List<Prize> sportPrizes = new ArrayList<>();
    private List<Prize> moviePrizes = new ArrayList<>();
    private Prize sportPrize1;
    private Prize sportPrize2;
    private Prize moviePrize1;
    private Prize moviePrize2;

    @Mock
    private EligibilityService eligibilityService;

    @Mock
    private AwardStrategy sportsAwardStrategy;

    @Mock
    private AwardStrategy movieAwardStrategy;

    @InjectMocks
    private PrizeServiceImpl prizeService;

    @Before
    public void setUp() throws InvalidAccountNumberException
    {
        sportPrize1 = new Prize("FC Bayern vs Barcelona   - Soccer");
        sportPrize2 = new Prize("Chelsea vs VfB Stuttgart - Soccer");

        sportPrizes.add(sportPrize1);
        sportPrizes.add(sportPrize2);

        moviePrize1 = new Prize("Django Unchained");
        moviePrize2 = new Prize("Inglorious Basterds");

        moviePrizes.add(moviePrize1);
        moviePrizes.add(moviePrize2);

        Mockito.when(sportsAwardStrategy.getPrizeList()).thenReturn(sportPrizes);
        Mockito.when(movieAwardStrategy.getPrizeList()).thenReturn(moviePrizes);

    }

    @Test
    public void testSportPrizes() throws InvalidAccountNumberException
    {
        final Customer customer = new Customer(ACCOUNT_NUMBER,
                channelPackageListBuilder(new SportsPackage(sportsAwardStrategy)));

        Mockito.when(eligibilityService.getEligibilityStatus(customer.getAccountNumber())).thenReturn(true);

        final List<Prize> prizesForCustomer = prizeService.getPrizesForCustomer(customer.getAccountNumber(), customer.getChannelPackages());

        assertNotNull(prizesForCustomer);
        assertTrue(prizesForCustomer.size() == sportPrizes.size());
        assertTrue(prizesForCustomer.contains(sportPrize1));
        assertTrue(prizesForCustomer.contains(sportPrize2));

    }

    @Test
    public void testMoviePrizesOnMoviePackage() throws InvalidAccountNumberException
    {
        final Customer customer = new Customer(ACCOUNT_NUMBER,
                channelPackageListBuilder(new MoviesPackage(movieAwardStrategy)));

        Mockito.when(eligibilityService.getEligibilityStatus(customer.getAccountNumber())).thenReturn(true);

        final List<Prize> prizesForCustomer = prizeService.getPrizesForCustomer(customer.getAccountNumber(), customer.getChannelPackages());

        assertNotNull(prizesForCustomer);
        assertTrue(prizesForCustomer.size() == moviePrizes.size());
        assertTrue(prizesForCustomer.contains(moviePrize1));
        assertTrue(prizesForCustomer.contains(moviePrize2));
    }

    @Test
    public void testMoviePrizesOnGossipPackage() throws InvalidAccountNumberException
    {
        final Customer customer = new Customer(ACCOUNT_NUMBER,
                channelPackageListBuilder(new GossipsPackage(movieAwardStrategy)));

        Mockito.when(eligibilityService.getEligibilityStatus(customer.getAccountNumber())).thenReturn(true);

        final List<Prize> prizesForCustomer = prizeService.getPrizesForCustomer(customer.getAccountNumber(), customer.getChannelPackages());

        assertNotNull(prizesForCustomer);
        assertTrue(prizesForCustomer.size() == moviePrizes.size());
        assertTrue(prizesForCustomer.contains(moviePrize1));
        assertTrue(prizesForCustomer.contains(moviePrize2));
    }

    private List<ChannelPackage> channelPackageListBuilder(final ChannelPackage... packages)
    {
        final List<ChannelPackage> channelPackages = new ArrayList<>();

        for (final ChannelPackage channelPackage : packages)
        {
            channelPackages.add(channelPackage);
        }

        return channelPackages;
    }

}
