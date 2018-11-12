package fr.cpe.services.Impl;

import fr.cpe.ejb.MessageReceiverSyncLocal;
import fr.cpe.ejb.MessageSenderLocal;
import fr.cpe.models.UserModel;
import fr.cpe.services.WatcherAuthService;
import fr.cpe.utils.AuthResponse;

import javax.ejb.EJB;
import java.util.logging.Logger;

public class WatcherAuthServiceImpl implements WatcherAuthService {
    private Logger logger = Logger.getLogger(WatcherAuthService.class.getName());

    @EJB
    MessageSenderLocal sender;
    @EJB
    MessageReceiverSyncLocal receiver;

    @Override
    public AuthResponse get() {
        UserModel user = this.receiver.receiveMessage();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAll(user.getLogin(), user.getRole());
        return authResponse;
    }

    @Override
    public AuthResponse post(UserModel user) {
        this.sender.sendMessage(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAll(user.getLogin(), user.getRole());
        return authResponse;
    }
}
