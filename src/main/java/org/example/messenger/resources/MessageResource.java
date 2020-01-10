package org.example.messenger.resources;

import org.example.messenger.database.DatabaseClass;
import org.example.messenger.model.Comment;
import org.example.messenger.model.Message;
import org.example.messenger.resources.bean.MessageFilterBean;
import org.example.messenger.service.CommentService;
import org.example.messenger.service.MessageService;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessage(@BeanParam MessageFilterBean messageFilterBean) {
        if (messageFilterBean.getYear() > 0) {
            return messageService.getAllMessageOfYear(messageFilterBean.getYear());
        }
        if (messageFilterBean.getStart() >= 0 && messageFilterBean.getSize() > 0) {
            return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
        }
        return messageService.getAllMessages();

    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId) {
        return messageService.getMessage(messageId);

    }

    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @POST
    @Path("/_bulk")
    public List<Message> addMessageBulk(List<Message> messages) {
        for (Message message : messages) {
            messageService.addMessage(message);
        }
        return messageService.getAllMessages();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public String deleteMessage(@PathParam("messageId") long messageId) {
        return messageService.removeMessage(messageId);
    }

    @DELETE
    @Path("/_bulk")
    public String deleteAll(){
        return messageService.removeAll();
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}