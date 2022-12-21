package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;

public class ContactWithGroupTests extends TestBase {

    @BeforeMethod(enabled = false)
    public void ensurePreconditions() {

        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        ArrayList<ContactData> contactWithGroup = new ArrayList<>();

        for (ContactData contact : contacts) {
            if (!contact.getGroups().toString().equals("[]")) {
                contactWithGroup.add(contact);
            }
        }
        if (contactWithGroup.size() == 0) {
            app.contact().returnToHomePage();
            app.contact().initGroupAssign(contacts.iterator().next().getId(), groups.iterator().next());
        }

        ArrayList<GroupData> groupWithContact = new ArrayList<>();

        for (GroupData group : groups) {
            if (!group.getContacts().toString().equals("[]")) {
                groupWithContact.add(group);
            }
        }
        if (groupWithContact.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test9"));
        }

    }

    @BeforeTest(enabled = false)
    public void ensurePreconditionsForDeletion() {

        if (app.db().groups().iterator().next().getContacts().size() == 0) {
            Groups groupList = app.db().groups();
            GroupData toGroup = groupList.iterator().next();
            Contacts contactsBefore = app.db().contacts();
            ContactData selectedContact = contactsBefore.iterator().next();
            app.contact().initGroupAssign(selectedContact.getId(), toGroup);
        }
    }


    @Test(enabled = false)
    public void testContactWithGroups() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        System.out.println(groups.iterator().next().getContacts().size());
        System.out.println(contacts.iterator().next().getGroups().size());

    }

}
