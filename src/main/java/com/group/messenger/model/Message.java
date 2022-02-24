package com.group.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Message {

	private long id;
	private String content;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();

	public Message(long id, String content, String author) {
		this.id = id;
		this.content = content;
		this.author = author;
		this.created = new Date();
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void addLink(String url, String rel) {
		if (links.size() < 3)
			links.add(new Link(url, rel));
	}

}