package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testModificationContact() {
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()) {
      app.group().create(new GroupData("test1", "test2", "test3"));
    }
    app.goTo().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Maria", "Anna", "Bolshakova", "masha", "DT", "TT", "Nevskiy", "56786", "909876", "4564564", "456456", "dd@t.ru", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(0).getId(), "Maria", "Anna", "Bolshakova", "masha", "DT", "TT", "Nevskiy", "56786", "909875", "4564564", "456456", "dd@t.ru", "test1");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(0);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
