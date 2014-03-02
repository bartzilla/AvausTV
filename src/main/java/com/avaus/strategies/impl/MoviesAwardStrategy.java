package com.avaus.strategies.impl;

import java.util.ArrayList;
import java.util.List;

import com.avaus.domain.Prize;
import com.avaus.strategies.AwardStrategy;

/**
 * This class represents a strategy to obtain all possible awards related to Movies Events.
 * In a production environment this class could delegate to other services (RESTful, Web Services etc) or
 * so real events can be retrieved.
 *
 * @author Cipriano Sanchez
 */
public class MoviesAwardStrategy implements AwardStrategy
{
    private List<Prize> prizes = new ArrayList<>();

    public MoviesAwardStrategy()
    {
        prizes.add(new Prize("The Secret Life of Walter Mitty"));
        prizes.add(new Prize("American Hustle"));
        prizes.add(new Prize("Wolf of wall street"));
    }
    @Override
    public List<Prize> getPrizeList()
    {
        return prizes;
    }
}
