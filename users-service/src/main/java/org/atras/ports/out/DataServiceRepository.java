package org.atras.ports.out;

public interface DataServiceRepository {
	
	int[] retriveAllData();

	int[] retriveAllData(String name);
}
