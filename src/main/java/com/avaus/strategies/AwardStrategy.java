package com.avaus.strategies;

import java.util.List;

import com.avaus.domain.Prize;

/**
 * This interface represents the contract to follow for all possible strategies or behaviors. 
 * Implement this interface whenever it is necessary to add a new strategy to obtain awards.
 *
 * @author Cipriano Sanchez
 */
public interface AwardStrategy
{
    /**
     * Obtain a list of prizes, for a all existing strategies to retrieve awards. 
     *
     * @return The list of prizes, required for a given strategy.
     */
    List<Prize> getPrizeList();
}
