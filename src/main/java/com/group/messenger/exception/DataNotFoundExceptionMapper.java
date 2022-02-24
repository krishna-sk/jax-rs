package com.group.messenger.exception;

import com.group.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), Status.NOT_FOUND.getStatusCode(),
				"https://www.google.co.in/");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}