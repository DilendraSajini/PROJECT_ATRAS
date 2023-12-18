package org.atras.proxy;

import org.atras.ports.out.DataServiceRepository;

public class DataRepositoryImpl implements DataServiceRepository {
	@Override
	public int[] retriveAllData() {
		int[] data = { 1, 2, 3, 4, 5 };
		return data;
	}

	@Override
	public int[] retriveAllData(String name) {
		int[] data = { 1, 2, 3, 4, 5 };
		return data;
	}
}
