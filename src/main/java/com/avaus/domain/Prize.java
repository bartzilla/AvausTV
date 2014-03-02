package com.avaus.domain;

/**
 * This is concrete class to represent Prize objects. 
 *
 *  @author Cipriano Sanchez
 */
public class Prize
{
    private String description;

    public Prize(final String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Prize)) return false;

        Prize prize = (Prize) o;

        if (!description.equals(prize.description)) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return description.hashCode();
    }
}
