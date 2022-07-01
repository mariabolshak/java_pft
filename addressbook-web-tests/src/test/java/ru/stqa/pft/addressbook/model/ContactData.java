package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id=Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String homephone;
  private String mobilephone;
  private String workphone;
  private String fax;
  private String email;
  private String email1;
  private String email2;
  private String group;
  private String allPhones;
  private String allEmails;


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobilePhone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactData withWorkPhone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }


  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public String getGroup() {
    return group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homephone;
  }

  public String getMobilePhone() {
    return mobilephone;
  }

  public String getWorkPhone() {
    return workphone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail1() { return email1; }

  public String getEmail2() { return email2; }

  public String getAllEmails() {
    return allEmails;
  }
  public String getAllPhones() {
    return allPhones;
  }



}