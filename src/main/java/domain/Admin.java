package domain;

public class Admin {
	
	private Integer id;
	private String loginId;
	private String loginPass;
	
	public Admin() {
		
	}
	
	public Admin(Integer id, String loginId, String loginPass) {
		this.id = id;
		this.loginId = loginId;
		this.loginPass = loginPass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	
	

}
