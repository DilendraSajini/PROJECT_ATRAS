package org.atras.rest;

import java.util.Locale;

import org.atras.permissions.ports.out.PermissionRepository;
import org.atras.persistence.repository.UserDBRepository;
import org.atras.persistence.proxy.repository.DataRepositoryImpl;
import org.atras.persistence.proxy.repository.PermissionRepositoryImpl;
import org.atras.persistence.proxy.repository.RoleRepositoryImpl;
import org.atras.persistence.proxy.repository.UserRepositoryImpl;
import org.atras.roles.ports.in.CreateRolesUseCase;
import org.atras.roles.ports.in.FindRolesUseCase;
import org.atras.roles.ports.out.RoleRepository;
import org.atras.roles.services.CreateRolesUseCaseImpl;
import org.atras.roles.services.FindRolesUseCaseImpl;
import org.atras.users.ports.in.CreateUsersUseCase;
import org.atras.users.ports.in.DeleteUsersUseCase;
import org.atras.users.ports.in.FindUsersUseCase;
import org.atras.users.ports.out.DataServiceRepository;
import org.atras.users.ports.out.UserRepository;
import org.atras.users.services.CreateUsersUseCaseImpl;
import org.atras.users.services.DeleteUsersUseCaseImpl;
import org.atras.users.services.FindUsersUseCaseImpl;
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


@SpringBootApplication
@ComponentScan({"org.atras.persistence.repository","org.atras.persistence.proxy.repository","org.atras.rest","org.atras.messages.configuration"}) // here Combining @Configuration and @ComponentScan
@EnableJpaRepositories(basePackages={"org.atras.persistence"})
@EntityScan("org.atras.persistence.model")   
@EnableAspectJAutoProxy
public class RestServiceApplication {

	@Autowired // this not give any error
	private FindUsersUseCase findUsersUseCase;

//	@Value("${app.greeting}")
//	private String greetingTemplate;

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
		return new RoleRepositoryImpl();
	}
	
	@Bean(name = "userRepository")
	public UserRepositoryImpl userRepository() {
		return new UserRepositoryImpl();
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
