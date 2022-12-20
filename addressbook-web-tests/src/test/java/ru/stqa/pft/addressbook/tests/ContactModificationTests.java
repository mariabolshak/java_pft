package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsContactData() {
        ensurePreconditionsGroupData();
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Frosia").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomePhone("56786").withMobilePhone("909876").withWorkPhone("4564564").withFax("456456").withEmail("d-d@t.ru").withGroup("test1"));
        }
        app.goTo().homePage();
    }

    @Test
    public void testModificationContact() {

        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        File photo = new File("src/test/resources/stru.png");
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Maria").withMiddlename("Anna").withLastname("Bolshakova").withNickname("masha").withTitle("DT").withCompany("TT").withAddress("Nevskiy").withHomePhone("56786").withMobilePhone("909876").withWorkPhone("4564564").withFax("456456").withEmail("dd@t.ru").withGroup("test1").withPhoto(photo);
        app.contact().modify(modifiedContact.withPhoto(photo));
        app.contact().modify(contact.withPhoto(photo));
        Contacts after = app.db().contacts();

        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }
}
