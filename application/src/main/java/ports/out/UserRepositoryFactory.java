package ports.out;

public interface UserRepositoryFactory {

	UserRepository getUserRepository(String name);
}
