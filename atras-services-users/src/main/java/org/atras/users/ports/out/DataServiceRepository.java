package org.atras.users.ports.out;

public interface DataServiceRepository {
	
	int[] retriveAllData();

	int[] retriveAllData(String name);
}
