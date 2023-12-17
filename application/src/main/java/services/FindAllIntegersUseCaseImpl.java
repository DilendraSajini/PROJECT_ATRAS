package services;

import data.IntArray;
import ports.in.FindAllIntegersUseCase;
import ports.out.DataServiceRepository;

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
