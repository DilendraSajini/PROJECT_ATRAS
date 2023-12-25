package org.atras.messages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.atras.core.data.ECAM;
import org.atras.messages.data.Message;
import org.atras.messages.ports.in.PublishSimulationDataUseCase;

public class PublishSimulationDataUseCaseImpl implements PublishSimulationDataUseCase {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void publishECAM(ECAM data) {
		Message message = new Message("spring boot app", data);
		//jmsTemplate.convertAndSend("atras", message);
		addDataToQueue();
	}

	public void addDataToQueue() {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(this::workerTask, 0, 1, TimeUnit.SECONDS);
	}

	private void workerTask() {
		String newData = "New Data: " + System.currentTimeMillis();
		jmsTemplate.convertAndSend("atras", newData);
		System.out.println("Worker task executed at: " + System.currentTimeMillis());
	}
}
