package com.group.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.group.messenger.database.DatabaseClass;
import com.group.messenger.model.Comment;
import com.group.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(long messageId) {
		if (messageId <= 0) {
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		if (messageId <= 0 || commentId <= 0) {
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
		
		/*
		 * ErrorMessage errorMessage = new ErrorMessage("Not found",
		 * Status.NOT_FOUND.getStatusCode(), "https://www.google.co.in/"); Response
		 * response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		 * 
		 * Message message = messages.get(messageId); if (message == null) { throw new
		 * WebApplicationException(response); } Map<Long, Comment> comments =
		 * messages.get(messageId).getComments(); Comment comment =
		 * comments.get(commentId); if (comment == null) { throw new
		 * NotFoundException(response); } return comment;
		 */
	}

	public Comment addComment(long messageId, Comment comment) {
		if (messageId <= 0) {
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		if (messageId <= 0 || comment.getId() <= 0) {
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		if (messageId <= 0 || commentId <= 0) {
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
