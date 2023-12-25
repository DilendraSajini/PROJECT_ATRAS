package org.atras.messages.ports.in;

import org.atras.core.data.ECAM;

public interface PublishSimulationDataUseCase {

	void publishECAM(ECAM data);
}
