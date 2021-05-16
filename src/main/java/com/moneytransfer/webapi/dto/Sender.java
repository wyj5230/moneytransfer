package com.moneytransfer.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sender {

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("nationality_country_iso_code")
    private String nationalityCountryIsoCode;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("country_of_birth_iso_code")
    private String countryOfBirthIsoCode;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("address")
    private String address;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country_iso_code")
    private String countryIsoCode;

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("email")
    private String email;

    @JsonProperty("id_type")
    private String idType;

    @JsonProperty("id_number")
    private String idNumber;

    @JsonProperty("id_delivery_date")
    private String idDeliveryDate;

    @JsonProperty("occupation")
    private String occupation;

    public Sender() {
    }

    public Sender(String lastname, String firstname, String nationalityCountryIsoCode, String dateOfBirth, String countryOfBirthIsoCode, String gender, String address, String postalCode, String city, String countryIsoCode, String msisdn, String email, String idType, String idNumber, String idDeliveryDate, String occupation) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.nationalityCountryIsoCode = nationalityCountryIsoCode;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirthIsoCode = countryOfBirthIsoCode;
        this.gender = gender;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.countryIsoCode = countryIsoCode;
        this.msisdn = msisdn;
        this.email = email;
        this.idType = idType;
        this.idNumber = idNumber;
        this.idDeliveryDate = idDeliveryDate;
        this.occupation = occupation;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getNationalityCountryIsoCode() {
        return nationalityCountryIsoCode;
    }

    public void setNationalityCountryIsoCode(String nationalityCountryIsoCode) {
        this.nationalityCountryIsoCode = nationalityCountryIsoCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirthIsoCode() {
        return countryOfBirthIsoCode;
    }

    public void setCountryOfBirthIsoCode(String countryOfBirthIsoCode) {
        this.countryOfBirthIsoCode = countryOfBirthIsoCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdDeliveryDate() {
        return idDeliveryDate;
    }

    public void setIdDeliveryDate(String idDeliveryDate) {
        this.idDeliveryDate = idDeliveryDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
