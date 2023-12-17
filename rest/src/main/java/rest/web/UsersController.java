package rest.web;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import data.User;
import ports.in.CreateUsersUseCase;
import ports.in.DeleteUsersUseCase;
import ports.in.FindUsersUseCase;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class UsersController {

	
	private FindUsersUseCase findUsersUseCase;

	private CreateUsersUseCase createUsersUseCase;
	
	private DeleteUsersUseCase deleteUsersUseCase;

	private MessageSource messageSource;
	
	@Autowired
	public void setFindUsersUseCase(FindUsersUseCase findUsersUseCase) {
		this.findUsersUseCase = findUsersUseCase;
	}

	@Autowired
	public void setCreateUsersUseCase(CreateUsersUseCase createUsersUseCase) {
		this.createUsersUseCase = createUsersUseCase;
	}
	
	@Autowired
	public void setDeleteUsersUseCase(DeleteUsersUseCase deleteUsersUseCase) {
		this.deleteUsersUseCase = deleteUsersUseCase;
	}
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping("/hello-users")
	public String getHelloUsers() {
		return messageSource.getMessage("hello.user.message", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return findUsersUseCase.findUsers();
	}
	
	@GetMapping("/users/{userId}")
	//@RequestMapping(method=RequestMethod.GET, path="/users/{userId}")
	public User getUserById(@PathVariable("userId") String userId) {
		return findUsersUseCase.findUsersById(Integer.parseInt(userId));
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUserById(@PathVariable("userId") String userId) {
		deleteUsersUseCase.deleteUserById(Integer.parseInt(userId));
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Validated @RequestBody User user) {
		User savedUser = createUsersUseCase.saveUser(user);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).body(savedUser);
	}
}
