package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
  public void submitContactModification() {
    click(By.xpath("/html/body/div/div[4]/form[1]/input[22]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail1());
    type(By.name("email3"), contactData.getEmail2());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void editById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache=null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    editById(contact.getId());
    fillContactForm(contact,false);
    submitContactModification();
    contactCache=null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    editById(contact.getId());
    deleteContact();
    contactCache=null;
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
  public void selectContact(int i) {
    wd.findElements(By.name("selected[]")).get(i).click();;
  }


  private Contacts contactCache=null;
  public Contacts all() {
    if (contactCache !=null){
      return new Contacts(contactCache);

    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allphones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address).withAllPhones(allphones).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }
  public ContactData infoFromEditForm(ContactData contact) {
    editById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email1 = wd.findElement(By.name("email2")).getAttribute("value");
    String email2 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withMiddlename(middlename).withLastname(lastname).withNickname(nickname).withTitle(title).withCompany(company)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail1(email1)
            .withEmail2(email2).withAddress(address);
  }

}


