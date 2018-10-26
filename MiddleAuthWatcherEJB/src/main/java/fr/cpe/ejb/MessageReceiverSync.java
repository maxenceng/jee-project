package fr.cpe.ejb;

import fr.cpe.models.UserModel;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import java.util.logging.Logger;

@Stateless
@Local
public class MessageReceiverSync implements MessageReceiverSyncLocal {
    private final static Logger logger = Logger.getLogger(MessageReceiverSync.class.getName());

    @Inject
    JMSContext context;

    @Resource(mappedName = "java:/tpQueue")
    Queue queue;

    @Override
    public UserModel receiveMessage() {
        Message message = context.createConsumer(queue).receive(1000);
        try {
            if (message instanceof ObjectMessage) {
                return (UserModel) ((ObjectMessage) message).getObject();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
