package org.atras.rest.web;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.atras.core.data.ECAM;
import org.atras.messages.ports.in.ConsumeSimulationDataUseCase;
import org.atras.messages.ports.in.PublishSimulationDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class SimulatorDataController {

	private PublishSimulationDataUseCase findPublishSimulationDataUseCase;
	
	private ConsumeSimulationDataUseCase findConsumeSimulationDataUseCase;

	@Autowired
	public void setFindConsumeSimulationDataUseCase(ConsumeSimulationDataUseCase findConsumeSimulationDataUseCase) {
		this.findConsumeSimulationDataUseCase = findConsumeSimulationDataUseCase;
	}

	@Autowired
	public void setFindPublishSimulationDataUseCase(PublishSimulationDataUseCase findPublishSimulationDataUseCase) {
		this.findPublishSimulationDataUseCase = findPublishSimulationDataUseCase;
	}
	
	@PostMapping("/message")
	public ResponseEntity<String> publishMessage(@Validated @RequestBody ECAM data) {
		findPublishSimulationDataUseCase.publishECAM(data);
		 return new ResponseEntity<>("Sent.", HttpStatus.OK);
	}
	
	@GetMapping(value ="/events/ecam", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent<String>> getECAMEvents() throws IOException {
		ConcurrentLinkedQueue<String> data = findConsumeSimulationDataUseCase.getECAMEvents();
		return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String>builder().data(data.poll()).build());
		 
	}
	
//	@GetMapping(value ="/events/ecam", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<ServerSentEvent<String>> getECAMEvents() throws IOException {
//		findConsumeSimulationDataUseCase.getECAMEvents();
//		
//		 Stream<String> lines = Files.lines(Path.of("G:\\University\\OneDrive - Leeds Beckett University\\Documents\\jobs\\jobs\\interview_prep\\Spring\\Project\\PROJECT_ATRAS\\atras-rest-api\\pom.xml"));
//		 return Flux.fromStream(lines)
//	                .filter(line -> !line.isBlank())
//	                .map(line -> ServerSentEvent.<String>builder().id("1").data(line).retry(Duration.ofMillis(1000)).build())
//	                .delayElements(Duration.ofMillis(300));
//		
//		 
//	}
	
//	@GetMapping(value ="/events/ecam", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<String> getECAMEvents() throws IOException {
//		findConsumeSimulationDataUseCase.getECAMEvents();
//		
//		 Stream<String> lines = Files.lines(Path.of("G:\\University\\OneDrive - Leeds Beckett University\\Documents\\jobs\\jobs\\interview_prep\\Spring\\Project\\PROJECT_ATRAS\\atras-rest-api\\pom.xml"));
//		 return Flux.fromStream(lines)
//	                .filter(line -> !line.isBlank())
//	                .delayElements(Duration.ofMillis(300));
//		
//		 
//	}
}
