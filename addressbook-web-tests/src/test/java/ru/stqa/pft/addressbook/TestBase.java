package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.wd = new FirefoxDriver();
    app.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    app.wd.get("http://localhost:8080/addressbook/");
    app.login("admin", "secret");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.wd.findElement(By.linkText("Logout")).click();
    app.wd.quit();

  }

}
