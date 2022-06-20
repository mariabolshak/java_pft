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
    if (app.group().list().size()==0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().createContact(new ContactData()
              .withFirstname("Frosia").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomephone("56786").withMobilephone("909876").withWorkphone("4564564").withFax("456456").withEmail("dd@t.ru").withGroup("test1"));
    }
    List<ContactData> before=app.contact().list();
    int index=before.size()-1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after=app.contact().list();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(index);
    Assert.assertEquals(before,after);
  }


}
