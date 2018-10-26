package fr.cpe.ejb;

import fr.cpe.models.UserModel;

public interface MessageSenderQueueLocal {
    void sendMessage(String message);
    void sendMessage(UserModel user);
}
