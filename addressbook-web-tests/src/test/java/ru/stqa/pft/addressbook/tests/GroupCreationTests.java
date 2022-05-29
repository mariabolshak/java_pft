package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    GroupData group=new GroupData("test1", null,null);
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(group);
int max=0;
for (GroupData g:after)
  if (g.getId()>max){
    max=g.getId();
  }
group.setId(max);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
