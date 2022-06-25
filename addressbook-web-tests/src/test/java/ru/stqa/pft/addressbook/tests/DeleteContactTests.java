package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class DeleteContactTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Frosia").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomephone("56786").withMobilephone("909876").withWorkphone("4564564").withFax("456456").withEmail("dd@t.ru").withGroup("test1"))
      ;
    }
  }
  @Test
  public void testDeleteContact() {

    Contacts before=app.contact().all();
    ContactData deletedContact=before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
   Contacts after=app.contact().all();
    assertEquals(after.size(),before.size()-1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}
