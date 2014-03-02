package com.avaus.strategies.impl;

import java.util.ArrayList;
import java.util.List;

import com.avaus.domain.Prize;
import com.avaus.strategies.AwardStrategy;

/**
 * This class represents a strategy to obtain all possible awards related to Sport Events.
 * In a production environment this class could delegate to other services (RESTful, Web Services etc) or
 * so real events can be retrieved.
 *
 * @author Cipriano Sanchez
 */
public class SportsAwardStrategy implements AwardStrategy
{
    private List<Prize> prizes = new ArrayList<>();

    public SportsAwardStrategy()
    {
        prizes.add(new Prize("Sweden vs Finland  - Hockey"));
        prizes.add(new Prize("Finland vs Spain   - Soccer"));
        prizes.add(new Prize("Germany vs Finland - Soccer"));
    }

    @Override
    public List<Prize> getPrizeList()
    {
        return prizes;
    }
}
