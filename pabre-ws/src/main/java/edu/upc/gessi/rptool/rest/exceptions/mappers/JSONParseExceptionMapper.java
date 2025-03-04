package edu.upc.gessi.rptool.rest.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

@Provider
public class JSONParseExceptionMapper extends GenericUnsuccessfullExceptionMapper<JsonProcessingException> {
    private static final Logger logger = Logger.getLogger(JSONParseExceptionMapper.class.getName());

    @Override
    protected Response manageException(JsonProcessingException exception) {
	logger.error("JsonProcessingException", exception);
	String message = "[JsonProcessingException]: ";
	if (exception.getCause() != null && exception.getCause().getMessage() != null) {
	    message += exception.getCause().getMessage();
	} else {
	    message += exception.getMessage();
	}
	logger.error(message);
	return Response.status(Status.BAD_REQUEST).entity(message).type("text/plain").build();
    }

}
