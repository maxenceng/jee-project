package fr.cpe.ejb;

import fr.cpe.models.UserModel;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

@Stateless
public class MessageSenderQueue implements MessageSenderQueueLocal {
    @Inject
    JMSContext context;

    @Resource(mappedName = "java:/tpQueue")
    Queue queue;

    @Override
    public void sendMessage(String message) {
        context.createProducer().send(queue, message);
    }

    @Override
    public void sendMessage(UserModel user) {
        ObjectMessage objectMessage = context.createObjectMessage(user);
        context.createProducer().send(queue, objectMessage);
    }
}
