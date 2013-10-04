package training.impetus.tp.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserRoleEntity {
	@Id
	@GeneratedValue
	@Column(name="USER_ROLE_ID")
	private Integer id;
	@Column(name="USER_ID")
	private String userId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Column(name="AUTHORIUTY")
	private String roles;
	

}
