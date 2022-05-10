package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class DeleteContactTests extends TestBase {
  @Test
  public void testDeleteContact() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Maria", "Anna", "Bolshakova", "masha", "DT", "TT", "Nevskiy", "56786", "909876", "4564564", "456456", "dd@t.ru", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
  }
}
