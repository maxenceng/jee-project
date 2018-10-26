package fr.cpe.ejb;

import fr.cpe.models.DataContainer;
import fr.cpe.models.UserModel;
import fr.cpe.utils.Role;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/tpTopic")
})
public class AuthWatcherMsgDrivenEJB implements MessageListener {
    private DataContainer dataContainer;

    @EJB
    UserDaoLocal userDao;

    @EJB
    MessageSenderQueueLocal sender;

    public AuthWatcherMsgDrivenEJB() {
        this.dataContainer = new DataContainer();
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String msg = ((TextMessage) message).getText();
                this.sender.sendMessage(msg);
            } else if (message instanceof ObjectMessage) {
                UserModel user = (UserModel) ((ObjectMessage) message).getObject();
                Role currentRole = this.dataContainer.checkUser(user, userDao.getUserList());
                userDao.getUserList();
                if (Role.NONE == currentRole) {
                    this.sender.sendMessage(user);
                } else {
                    user.setRole(currentRole.toString());
                    this.sender.sendMessage(user);
                }
            } else {
                System.out.println("No valid message");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
