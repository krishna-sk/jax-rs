package com.group.messenger.resources;

import java.util.List;

import com.group.messenger.model.Comment;
import com.group.messenger.service.CommentService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

/**
 * 
 * This is a sub-resource of MessageResource. Please Do Check the
 * MessageResource last Method.
 */
@Path("/")
public class CommentResource {

	private CommentService commentService = new CommentService();

	/*
	 * @GET
	 * 
	 * @Path("/{commentId}") public String
	 * getCommentResource(@PathParam("messageId") String messageId,
	 * 
	 * @PathParam("commentId") String commentId) { return "Message Id : " +
	 * messageId + "\nComment Id : " + messageId; }
	 */

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}

	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,
			Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}

}
