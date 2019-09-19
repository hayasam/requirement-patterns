package edu.upc.gessi.rptool.exceptions;

/*
 * This class represents the exception that we launch 
 * when an ERROR IN THE DATA INTEGRITY OF ONE POSSIBLE 
 * VALUE may be produced 
 */

public class PossibleValueException extends RPToolException {

    /*
     * ATTRIBUTES
     */

    private static final long serialVersionUID = 1L;
    private final String message;

    /*
     * CREATORS
     */

    public PossibleValueException(String msg) {
	    this.message = "";
    }

    /*
     * GET'S AND SET'S METHODS
     */

    public String getMsg() {
	return message;
    }

}
