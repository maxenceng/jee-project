package fr.cpe.ejb;

import fr.cpe.models.UserModel;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;

@Stateless
@Local
public class MessageSender implements MessageSenderLocal {
    @Inject
    JMSContext context;

    @Resource(mappedName = "java:/tpTopic")
    Topic topic;


    @Override
    public void sendMessage(String message) {
        context.createProducer().send(topic, message);
    }

    @Override
    public void sendMessage(UserModel user) {
        ObjectMessage userMessage = context.createObjectMessage(user);
        context.createProducer().send(topic, userMessage);
    }
}
