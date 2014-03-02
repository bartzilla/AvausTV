package com.avaus.strategies.impl;

import java.util.ArrayList;
import java.util.List;

import com.avaus.domain.Prize;
import com.avaus.strategies.AwardStrategy;

/**
 * This class represents an empty behavior. All Channel packages that don't award prizes could register to
 * it and will return empty prize lists
 *
 * @author Cipriano Sanchez
 */
public class EmptyAwardStrategy implements AwardStrategy
{
    @Override
    public List<Prize> getPrizeList()
    {
        return new ArrayList<>();
    }
}
