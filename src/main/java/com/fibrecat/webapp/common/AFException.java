package com.fibrecat.webapp.common;

public class AFException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Default Constructor.
     */
    public AFException() {
        super();
    }

    /**
     * <p>
     * Constructor with one Argument.
     * </p>
     * 
     * @param msg - a String Value - Exception message
     */
    public AFException(final String msg) {
        super(msg);
    }

    /**
     * Constructor with two Argument.
     * 
     * @param msg - a String Value - Exception message
     * @param cause -Throwable object
     */
    public AFException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructor with one Argument.
     * 
     * @param cause - Throwable object
     */
    public AFException(final Throwable cause) {
        super(cause);
    }

}
