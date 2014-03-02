package com.avaus.services.exceptions;

/**
 * This class represents a generic checked exception which is thrown if the given customer account number wasn't valid.
 *
 * @author Cipriano Sanchez
 */
public class InvalidAccountNumberException extends Exception
{

    private static final String MESSAGE = "The account number provided is invalid.";

    /**
     * Constructs a <code>InvalidAccountNumberException</code> with a default MESSAGE.
     */
    public InvalidAccountNumberException()
    {
        this(MESSAGE);
    }
    /**
     * Constructs a <code>InvalidAccountNumberException</code> with the given detail MESSAGE.
     *
     * @param message The detail MESSAGE of the <code>InvalidAccountNumberException</code>.
     */
    public InvalidAccountNumberException(final String message)
    {
        super(message);
    }

}
