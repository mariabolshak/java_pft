package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Frosia").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomephone("56786").withMobilephone("909876").withWorkphone("4564564").withFax("456456").withEmail("dd@t.ru").withGroup("test1"))
            ;
        }
    }

    @Test
    public void testModificationContact() {

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Maria").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomephone("56786").withMobilephone("909876").withWorkphone("4564564").withFax("456456").withEmail("dd@t.ru").withGroup("test1");
        app.contact().modify(modifiedContact);
        app.contact().modify(contact);
        Contacts after = app.contact().all();

        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }
}
