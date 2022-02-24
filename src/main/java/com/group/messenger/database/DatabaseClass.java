package com.group.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.group.messenger.model.Message;
import com.group.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();

	private static Map<String, Profile> profiles = new HashMap<>();

	static {
		messages.put(1L, new Message(1L, "Hello World !", "Sai"));
		messages.put(2L, new Message(2L, "Hello Jersey !", "Krishna"));
		profiles.put("krishna", new Profile(1L, "krishna", "Sai", "Krishna"));
		profiles.put("charan", new Profile(2L, "charan", "Sai", "Charan"));
	}

	private DatabaseClass() {
	}

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
