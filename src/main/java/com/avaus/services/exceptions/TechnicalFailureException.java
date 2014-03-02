package com.avaus.services.exceptions;

/**
 * This class represents a generic unchecked exception. It is thrown for any execution failures which are
 * unlikely to recover.
 *
 * @author Cipriano Sanchez
 */
public class TechnicalFailureException extends RuntimeException
{

    private static final String MESSAGE = "An unknown error during execution has occurred.";

    /**
     * Constructs a <code>TechnicalFailureException</code> with a default MESSAGE.
     */
    public TechnicalFailureException()
    {
        this(MESSAGE);
    }

    /**
     * Constructs a <code>TechnicalFailureException</code> with the given detail message.
     *
     * @param message The detail message of the <code>TechnicalFailureException</code>.
     */
    public TechnicalFailureException(String message)
    {
        super(message);
    }

    /**
     * Constructs a <code>TechnicalFailureException</code> with the given detail message and root cause.
     *
     * @param message The detail message of the <code>TechnicalFailureException</code>.
     * @param cause   The root cause of the <code>TechnicalFailureException</code>.
     */
    public TechnicalFailureException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
