package utilities;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class JSonHelper {

	public static JSonHelper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData.json"), JSonHelper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("date")
	private String date;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	@JsonProperty("login")
	private Login login;

	public static class Login {
		@JsonProperty("username")
		private String username;

		@JsonProperty("password")
		private String password;

	}

	public String getLoginUsername() {
		return login.username;
	}

	public String getLoginPassword() {
		return login.password;
	}

	@JsonProperty("subjects")
	private List<Subject> subjects;

	public List<Subject> getSubjects() {
		return subjects;
	}

	public static class Subject {
		@JsonProperty("name")
		private String name;

		@JsonProperty("point")
		private String point;

		public String getSubjectName() {
			return name;
		}

		public String getSubjectPoint() {
			return point;
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

}
