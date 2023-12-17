package org.atras.rest.web;

import org.atras.data.IntArray;
import org.atras.ports.in.FindAllIntegersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntArrayController {

	private FindAllIntegersUseCase findAllIntegersUseCase;
	
	@Autowired
	public void setFindAllIntegersUseCase(FindAllIntegersUseCase findAllIntegersUseCase) {
		this.findAllIntegersUseCase = findAllIntegersUseCase;
	}

	@GetMapping("/getdata/{pathId}")
	public IntArray getIntArray(@PathVariable("pathId") String pathId, @RequestParam(value="name", defaultValue= "world") String name) {
		System.out.println(pathId);
		return findAllIntegersUseCase.findAllArray();
	}
	
}
