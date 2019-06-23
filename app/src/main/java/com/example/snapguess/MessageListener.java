package com.example.snapguess;

import com.solacesystems.jcsmp.*;
import java.util.concurrent.CountDownLatch;

public class MessageListener {
    JCSMPProperties properties = new JCSMPProperties();
    Topic topic = null;
    JCSMPSession session = null;
    XMLMessageConsumer cons = null;

    public MessageListener(String newTopic) throws JCSMPException {
        properties.setProperty(JCSMPProperties.HOST, "tcp://mrqpjftlxxu05.messaging.solace.cloud:20832");
        properties.setProperty(JCSMPProperties.USERNAME, "solace-cloud-client");
        properties.setProperty(JCSMPProperties.PASSWORD, "qcel12d03vlu7hh57c52mhs0dv");
        properties.setProperty(JCSMPProperties.VPN_NAME, "msgvpn-rwtxvkmpdd1");
        topic = JCSMPFactory.onlyInstance().createTopic(newTopic);
        try {
            session = JCSMPFactory.onlyInstance().createSession(properties);
            session.connect();
        } catch (Exception e) {
            System.out.println("You couldn't connect to the message borker");
        }
        final CountDownLatch latch = new CountDownLatch(1);
        cons = session.getMessageConsumer(new XMLMessageListener() {
            @Override
            public void onReceive(BytesXMLMessage msg) {
                if (msg instanceof TextMessage) {
                    System.out.printf("TextMessage received: '%s'%n",
                            ((TextMessage)msg).getText());
                            messageRecieved(((TextMessage) msg).getText());
                } else {
                    System.out.println("Message received.");
                }
                System.out.printf("Message Dump:%n%s%n",msg.dump());
                latch.countDown();  // unblock main thread
            }

            @Override
            public void onException(JCSMPException e) {
                System.out.printf("Consumer received exception: %s%n",e);
                latch.countDown();  // unblock main thread
            }
        });
        session.addSubscription(topic);
        System.out.println("Connected. Awaiting message...");
        cons.start();
    }
    public void messageRecieved(String message ){
        //some activity function call
    }
}
