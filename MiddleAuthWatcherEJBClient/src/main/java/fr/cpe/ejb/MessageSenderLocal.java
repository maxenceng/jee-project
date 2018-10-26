package fr.cpe.ejb;

import fr.cpe.models.UserModel;

public interface MessageSenderLocal {
    void sendMessage(String message);
    void sendMessage(UserModel user);
}
