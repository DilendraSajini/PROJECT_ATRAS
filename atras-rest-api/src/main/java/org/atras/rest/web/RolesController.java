package org.atras.rest.web;

import java.net.URI;
import java.util.List;

import org.atras.core.data.Role;
import org.atras.roles.ports.in.CreateRolesUseCase;
import org.atras.roles.ports.in.FindRolesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class RolesController {

	
	private FindRolesUseCase findRolesUseCase;
	
	private CreateRolesUseCase createRolesUseCase;

	@Autowired
	public void setFindRolesUseCase(FindRolesUseCase findRolesUseCase) {
		this.findRolesUseCase = findRolesUseCase;
	}
	
	@Autowired
	public void setCreateRolesUseCase(CreateRolesUseCase createRolesUseCase) {
		this.createRolesUseCase = createRolesUseCase;
	}
	
	@GetMapping("/roles")
	public List<String> getUsers() {
		return findRolesUseCase.findRoles();
	}
	
	@GetMapping("/roles/{roleId}")
	//@RequestMapping(method=RequestMethod.GET, path="/users/{userId}")
	public String getUserById(@PathVariable("roleId") String roleId) {
		return findRolesUseCase.findRolesById(Integer.parseInt(roleId));
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Object> createRole(@Validated @RequestBody Role role) {
		Role savedRole = createRolesUseCase.saveRole(role);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedRole.getRoleId()).toUri();
		return ResponseEntity.created(location).body(savedRole);
	}
}
