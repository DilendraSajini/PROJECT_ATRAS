package org.atras.messages.configuration;

import org.atras.messages.ports.in.ConsumeSimulationDataUseCase;
import org.atras.messages.ports.in.PublishSimulationDataUseCase;
import org.atras.messages.services.ConsumeSimulationDataUseCaseImpl;
import org.atras.messages.services.PublishSimulationDataUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class MessagingConfiguration {
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrency("5-10");
		return factory;

	}
	
	@Bean(name = "findPublishSimulationDataUseCase")
	public PublishSimulationDataUseCase findPublishSimulationDataUseCase() {
		return new PublishSimulationDataUseCaseImpl();
	}
	
	@Bean(name = "findConsumeSimulationDataUseCase")
	public ConsumeSimulationDataUseCase findConsumeSimulationDataUseCase() {
		return new ConsumeSimulationDataUseCaseImpl();
	}
}
