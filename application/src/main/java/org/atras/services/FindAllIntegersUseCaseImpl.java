package org.atras.services;

import org.atras.data.IntArray;
import org.atras.ports.in.FindAllIntegersUseCase;
import org.atras.ports.out.DataServiceRepository;

public class FindAllIntegersUseCaseImpl implements FindAllIntegersUseCase {

	private DataServiceRepository dataService;
	
	public FindAllIntegersUseCaseImpl(DataServiceRepository dataService) {
		this.dataService = dataService;
	}
	
	@Override
	public IntArray findAllArray() {
		int[] integerArray = dataService.retriveAllData();
		return new IntArray(integerArray); 
	} 
	
	@Override
	public IntArray findAllArray(String name) {
		int[] integerArray = dataService.retriveAllData(name);
		return new IntArray(integerArray); 
	} 
	
	
}
