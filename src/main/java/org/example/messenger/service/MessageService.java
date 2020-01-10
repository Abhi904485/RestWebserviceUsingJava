package org.example.messenger.service;

import org.example.messenger.database.DatabaseClass;
import org.example.messenger.model.Message;

import java.util.*;

public class MessageService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Message> getAllMessages() {
        return new ArrayList<>(this.messages.values());
    }

    public Message getMessage(long messageId) {
        return messages.get(messageId);
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        message.setCreated(new Date());
        messages.put(message.getId(), message);
        return message;
    }

    public List<Message> getAllMessageOfYear(int year) {
        List<Message> messageForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message message : messages.values()) {
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR) == year) {
                messageForYear.add(message);
            }
        }
        return messageForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        List<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size()) {
            return new ArrayList<>(messages.values());
        }
        return list.subList(start, start + size);
    }

    public String removeMessage(long messageId) {
        messages.remove(messageId);
        return "deleted " + messageId;
    }

    public String removeAll() {
        messages.clear();
        return "Al  Messages Deleted Successfully";
    }
}
