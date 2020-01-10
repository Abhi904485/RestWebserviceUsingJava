package org.example.messenger.service;

import org.example.messenger.database.DatabaseClass;
import org.example.messenger.model.Comment;
import org.example.messenger.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();


    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comments.size() == 0) {
            return null;
        }
        return comments.get(commentId);
    }

    public String deleteComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.remove(commentId);
        return "Comment removed " + commentId;
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comment.setCreatedAt(new Date());
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() < 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }
}
