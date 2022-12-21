package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactUnassignGroupTests extends ContactModificationTests {


    @BeforeTest
    public void ensurePreconditionsForDeletion() {

        ensurePreconditionsContactData();
        ensurePreconditionsGroupData();

        if (app.db().groups().iterator().next().getContacts().size() == 0) {
            Groups groupList = app.db().groups();
            GroupData toGroup = groupList.iterator().next();
            Contacts contactsBefore = app.db().contacts();
            ContactData selectedContact = contactsBefore.iterator().next();
            app.contact().initGroupAssign(selectedContact.getId(), toGroup);
        }

    }

    @Test
    public void testContactGroupDeletion() {
        app.contact().returnToHomePage();
        Contacts contactsBefore = app.db().contacts();
        Groups groupList = app.db().groups();
        ContactData selectedContact = contactsBefore.iterator().next();
        //GroupData fromGroup = groupList.iterator().next();
        GroupData fromGroup = selectedContact.getGroups().iterator().next();

        app.contact().initGroupDeletion(selectedContact, fromGroup);
        Contacts contactsAfter = app.db().contacts();
        assertThat(contactsAfter.iterator().next().getGroups(), equalTo(contactsBefore.iterator().next().getGroups().without(fromGroup)));
        app.contact().returnToHomePage();
        verifyContactListInUI();
    }
}
