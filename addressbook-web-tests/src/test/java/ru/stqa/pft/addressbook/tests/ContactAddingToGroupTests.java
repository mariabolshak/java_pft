package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddingToGroupTests extends ContactModificationTests {


    @BeforeTest
    public void ensurePreconditionsForAdding() {

        ensurePreconditionsContactData();
        ensurePreconditionsGroupData();

        if (app.db().contacts().iterator().next().getGroups().size() == app.db().groups().size()) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testContactGroupAssign() {
        Contacts contactsBefore = app.db().contacts();
        Groups groupList = app.db().groups();
        ContactData selectedContact = contactsBefore.iterator().next();
        GroupData toGroup = groupList.iterator().next();
        app.contact().initGroupAssign(selectedContact.getId(), toGroup);
        Contacts contactsAfter = app.db().contacts();
        assertThat(contactsAfter.iterator().next().getGroups(), equalTo(contactsBefore.iterator().next().getGroups().withAdded(toGroup)));
        verifyContactListInUI();
        app.contact().returnToHomePage();

    }
}

