package com.wagner.forms.model;

import com.wagner.forms.validation.MustStartsWith;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {

	private String firstName;

	@NotNull(message="field is required")
	@Size(min=3, max=10, message="field is required and must be a value between 3 and 10 characters")
	private String lastName;

	@Min(value=5, message="minimum value is 5")
	@Max(value=10, message="maximum value is 10")
	@NotNull(message="field is required")
	private Integer freePasses;

	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Please enter a valid postal code (only 5 characters/digits are allowed)")
	private String postalCode;

	@MustStartsWith(value="LUV", message="field value must start with 'LUV'")
	private String courseCode;

	private String country;
	private Map<String, String> countryOptions;
	private List<String> programmingLanguages;
	private String favoriteLanguage;
	private String[] osExperience;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		
		programmingLanguages = Arrays.asList("Java", "Python", "C#", "PHP");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public List<String> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public String[] getOsExperience() {
		return osExperience;
	}

	public void setOsExperience(String[] osExperience) {
		this.osExperience = osExperience;
	}

}