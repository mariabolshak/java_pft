package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().groupPage();
    if (app.group().all().size()==0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Frosia").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomephone("56786").withMobilephone("909876").withWorkphone("4564564").withFax("456456").withEmail("dd@t.ru").withGroup("test1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
   assertThat(after.size(), equalTo(before.size() + 1));
   assertThat(after, equalTo(
           before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }


}
