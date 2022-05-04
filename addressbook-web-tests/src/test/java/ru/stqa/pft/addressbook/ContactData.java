package ru.stqa.pft.addressbook;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String homephone, String mobilephone, String workphone,
                          String fax, String email) {
}