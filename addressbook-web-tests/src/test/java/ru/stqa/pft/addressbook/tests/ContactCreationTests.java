package ru.stqa.pft.addressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().createContact(new ContactData("Maria", "Anna", "Bolshakova", "masha", "DT", "TT", "Nevskiy", "56786", "909876", "4564564", "456456", "dd@t.ru", "test1"));
     }


}
