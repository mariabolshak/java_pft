package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class DeleteContactTests extends TestBase {
  @Test
  public void testDeleteContact() {
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()) {
      app.group().create(new GroupData("test1", "test2", "test3"));
    }
    app.goTo().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Maria", "Anna", "Bolshakova", "masha", "DT", "TT", "Nevskiy", "56786", "909876", "4564564", "456456", "dd@t.ru", "test1"));
    }
    List<ContactData> before=app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteContact();
    app.goTo().goToHomePage();
    List<ContactData> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }
}
