package com.example.snapguess;

import com.solacesystems.jcsmp.*;




public class MessageSender {
    JCSMPProperties properties = new JCSMPProperties();
    Topic topic = null;
    JCSMPSession session = null;
    XMLMessageProducer prod = null;

    public MessageSender(String newTopic) throws JCSMPException{
        properties.setProperty(JCSMPProperties.HOST, "tcp://mrqpjftlxxu05.messaging.solace.cloud:20832");
        properties.setProperty(JCSMPProperties.USERNAME, "solace-cloud-client");
        properties.setProperty(JCSMPProperties.PASSWORD, "qcel12d03vlu7hh57c52mhs0dv");
        properties.setProperty(JCSMPProperties.VPN_NAME, "msgvpn-rwtxvkmpdd1");
        topic = JCSMPFactory.onlyInstance().createTopic(newTopic);
        try {
            session = JCSMPFactory.onlyInstance().createSession(properties);
            session.connect();
        }
        catch (Exception e){
            System.out.println("You couldn't connect to the message borker");
        }
        prod = session.getMessageProducer(new JCSMPStreamingPublishEventHandler() {
            @Override
            public void responseReceived(String messageID) {
                System.out.println("Producer received response for msg: " + messageID);
            }
            @Override
            public void handleError(String messageID, JCSMPException e, long timestamp) {
                System.out.printf("Producer received error for msg: %s@%s - %s%n",
                        messageID,timestamp,e);
            }
        });

    }
    public String sendMessage (String msgText) throws JCSMPException {
        TextMessage msg = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);
        msg.setText(msgText);
        System.out.printf("Connected. About to send message '%s' to topic '%s'...%n",msgText,topic.getName());
        try {
            prod.send(msg, topic);
        } catch (Exception e) {
            return "You failed to send the message" + msgText;
        }
        return "message sent";
    }
    public void endSession () {
        session.closeSession();
    }
}
