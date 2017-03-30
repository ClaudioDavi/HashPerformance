package mapTest.map;

public class UserVO {

	private Integer code;
	private String leader;
	private String userName;

	public UserVO(Integer code, String userName) {
		this.code = code;
		this.userName = userName;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLeader() {
		return leader;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
