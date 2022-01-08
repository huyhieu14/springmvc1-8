package tokyo.huyhieu.jparelationship.model;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String number;
	private String city;

	public Address() {
	}

	public Address(String street, String number, String city) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return street.equals(address.street) && number.equals(address.number) && city.equals(address.city);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(street, number, city);
	}
}
