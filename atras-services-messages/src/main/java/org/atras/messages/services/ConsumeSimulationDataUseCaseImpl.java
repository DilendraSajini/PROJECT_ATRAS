package org.atras.messages.services;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.atras.messages.ports.in.ConsumeSimulationDataUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class ConsumeSimulationDataUseCaseImpl implements ConsumeSimulationDataUseCase {

	private static final Logger logger = LoggerFactory.getLogger(ConsumeSimulationDataUseCaseImpl.class);

	private final ConcurrentLinkedQueue<String> jmsMessages = new ConcurrentLinkedQueue<>();
	
	@Override
	public ConcurrentLinkedQueue<String> getECAMEvents() {
		return jmsMessages;
	}

//	@JmsListener(destination = "atras")
//	public void messageListener(Message message) {
//		logger.info("Message received! {}", message.getPayload().toString());
//		if (message instanceof TextMessage) {
//            try {
//                String text = ((TextMessage) message).getText();
//                jmsMessages.offer(text);
//            } catch (Exception e) {
//                e.printStackTrace(); // Handle the exception appropriately
//            }
//        }
//	}
	
	@JmsListener(destination = "atras")
	public void messageListener(String message) {
		logger.info("Message received! {}", message);
                jmsMessages.offer(message);
        }

}
