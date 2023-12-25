package org.atras.messages.ports.in;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.atras.core.data.ECAM;

public interface ConsumeSimulationDataUseCase {
	ConcurrentLinkedQueue<String> getECAMEvents();
}
