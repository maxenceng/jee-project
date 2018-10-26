package fr.cpe.ejb;

import fr.cpe.models.UserModel;

public interface MessageReceiverSyncLocal {
    UserModel receiveMessage();
}
