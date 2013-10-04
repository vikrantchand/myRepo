package training.impetus.tp.model;

import javax.persistence.Embeddable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;


@Embeddable 
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddress {
	

	private String streetAddress = "";
	private String locality = "";
	private String city = "";
	private String state = "";
	private String zip = "";

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "UserAddress [streetAddress=" + streetAddress + ", locality="
				+ locality + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}
}
