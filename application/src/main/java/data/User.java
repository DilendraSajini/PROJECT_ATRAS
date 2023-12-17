package data;

//@ApiModel("")
public class User {

	// @Size(min = 2, message = "User name should have atleast 2 characters")// need
	// to add spring boot validation dependency to active.
	//@ApiModelProperty("User name should have atleast 2 characters")
	private String username;

	private String role;

	private Integer userId;

	private User() {
		
	}
	
	private User(UserBuilder userBuilder) {
		this.username = userBuilder.username;
		this.role = userBuilder.role;
	}

	public String getUsername() { // the default getters required to automatic conversion for json when returning
								  // the response
		return username;
	}

	public String getRole() {
		return role;
	}

	public Integer getUserId() {
		return userId;
	}

	public static  class UserBuilder {
		private String username;

		private String role;

		private Integer userId;

		public UserBuilder setUsername(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder setRole(String role) {
			this.role = role;
			return this;
		}

		public UserBuilder setUserId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}

