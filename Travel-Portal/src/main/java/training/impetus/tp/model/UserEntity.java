package training.impetus.tp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;



@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class UserEntity implements Serializable {
	@Id
	private Long USER_ID;
	private static final long serialVersionUID = 1L;
	@Column(name = "USERNAME")
	private String email;

	private String password;
	private String occupation = "";
	private Date dob;
	private String name = "";
	private String mobile = "";
	private String gender = "";
	private String phone = "";
	@Embedded
	private UserAddress address;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		PasswordEncoder crpPass = new Md5PasswordEncoder();
		this.password = crpPass.encodePassword(password, null);

	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserEntity [USER_ID=" + USER_ID + ", email=" + email
				+ ", password=" + password + ", occupation=" + occupation
				+ ", dob=" + dob + ", name=" + name + ", mobile=" + mobile
				+ ", gender=" + gender + ", phone=" + phone + ", address="
				+ address + "]";
	}

}
