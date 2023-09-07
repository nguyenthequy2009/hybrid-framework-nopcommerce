package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataFaker {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataFaker getDataFaker() {
		return new DataFaker();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password(8, 16, true, true);
	}

	public String getCityName() {
		return faker.address().city();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getCountry() {
		return faker.address().country();
	}

}
