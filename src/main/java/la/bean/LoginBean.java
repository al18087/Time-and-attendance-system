package la.bean;

public class LoginBean {
	private int loginId;
	private String password;
	private String name;
	
	public LoginBean(int loginId, String password, String name) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
	}
	
	public int getLoginId() {
		return loginId;
	}
	
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
