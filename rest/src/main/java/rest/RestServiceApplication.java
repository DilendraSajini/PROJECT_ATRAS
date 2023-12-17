package rest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import persistence.UserDBRepository;
import ports.in.CreateRolesUseCase;
import ports.in.CreateUsersUseCase;
import ports.in.DeleteUsersUseCase;
import ports.in.FindAllIntegersUseCase;
import ports.in.FindRolesUseCase;
import ports.in.FindUsersUseCase;
import ports.out.DataServiceRepository;
import ports.out.PermissionRepository;
import ports.out.RoleRepository;
import ports.out.UserRepository;
import proxy.DataRepositoryImpl;
import proxy.PermissionRepositoryImpl;
import proxy.RoleRepositoryImpl;
import proxy.UserRepositoryImpl;
import services.CreateRolesUseCaseImpl;
import services.CreateUsersUseCaseImpl;
import services.DeleteUsersUseCaseImpl;
import services.FindAllIntegersUseCaseImpl;
import services.FindRolesUseCaseImpl;
import services.FindUsersUseCaseImpl;


@SpringBootApplication
@ComponentScan({"persistence","rest"}) // here Combining @Configuration and @ComponentScan
@EnableJpaRepositories(basePackages={"persistence"})
@EntityScan("persistence.model")   
@EnableAspectJAutoProxy
public class RestServiceApplication {

	@Autowired // this not give any error
	private FindUsersUseCase findUsersUseCase;

	@Value("${app.greeting}")
	private String greetingTemplate;

	@Value("#{new Boolean(environment['spring.profiles.active'])!='dev'}")
	private boolean isDev;
	
//	@Value("${spring.messages.basename}")
//	private String messagesProperties;

	@Bean(name = "permissionRepository")
	public PermissionRepositoryImpl permissionRepository() {
		return new PermissionRepositoryImpl();
	}

	@Bean(name = "roleRepository")
	public RoleRepositoryImpl roleRepository() {
		return new RoleRepositoryImpl(permissionRepository());
	}
	
	@Bean(name = "userRepository")
	public UserRepository userRepository() {
		return new UserRepositoryImpl(roleRepository());
	}
	

	@Bean(name = "dataService")
	public DataServiceRepository dataService() {
		return new DataRepositoryImpl();
	}

	@Autowired
	private DataServiceRepository dataService;

	@Bean(name = "createUsersUseCase")
	public CreateUsersUseCase createUsersUseCase() {
		return new CreateUsersUseCaseImpl(userRepository());
	}

	@Bean(name = "deleteUsersUseCase")
	public DeleteUsersUseCase deleteUsersUseCase() {
		return new DeleteUsersUseCaseImpl(userRepository());
	}

	@Bean(name = "findUsersUseCase")
	public FindUsersUseCase findUsersUseCase() {
		return new FindUsersUseCaseImpl(userRepository());
	}

	@Bean(name = "createRolesUseCase")
	public CreateRolesUseCase createRolesUseCase() {
		return new CreateRolesUseCaseImpl(roleRepository());
	}
	
	@Bean(name = "findRolesUseCase")
	public FindRolesUseCase findRolesUseCase() {
		return new FindRolesUseCaseImpl(roleRepository());
	}
	
	@Bean(name = "findAllIntegersUseCase")
	public FindAllIntegersUseCase findAllIntegersUseCase() {
		return new FindAllIntegersUseCaseImpl(dataService);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	    AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
	    acceptHeaderLocaleResolver.setDefaultLocale(Locale.UK);
		return acceptHeaderLocaleResolver;
	}
//
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename(messagesProperties); // Base name without locale suffix
//		return messageSource;
//	} // use in application.properties file

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
