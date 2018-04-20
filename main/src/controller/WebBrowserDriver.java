package src.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebBrowserDriver {

  private static WebDriver driver;
  private String username;
  private String password;

  public WebBrowserDriver() {
  }

  public void starteBrowser() {
    System.setProperty("webdriver.gecko.driver", "/home/vagrant/Downloads/geckodriver");
    driver = new FirefoxDriver();

    driver.get("https://www.instagram.com/accounts/login/?hl=de");
  }

  public void datenUebergabe(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void login() {
    //Username
    WebElement usernameField = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
    usernameField.sendKeys(username);

    //Password
    WebElement passwordField = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
    passwordField.sendKeys(password);

    passwordField.submit();
  }

  public void like(String hashtag, int anzahl, int warteSekunden) {

    clickByClassName("_96n9j");

    fillFieldByxPathWithString("/html/body/span/section/nav/div[2]/div/div/div[2]/input", hashtag);

    bestaetigeTextFeldByxPath("/html/body/span/section/nav/div[2]/div/div/div[2]/div[2]/div[2]/div/a[2]/div/div/div[1]");

    clickNewPhotoFromFeedWithxPath("/html/body/span/section/main/article/div[2]/div/div[1]/div[1]");

    for (int a = 0; a < anzahl; a++) {
      performLikes();
      try {
        Thread.sleep(warteSekunden*1000);
        nextPic();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    closePhotoView();
  }

  private void closePhotoView() {
    WebElement closeButton = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.className("_dcj9f")));
    closeButton.click();

  }

  private void clickByClassName(String className) {
    WebElement clickSearch = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    clickSearch.click();
  }

  private void fillFieldByxPathWithString(String xPath, String text) {
    WebElement searchHashtag = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    searchHashtag.sendKeys(text);
  }

  private void bestaetigeTextFeldByxPath(String xPath) {
    WebElement submitHashtag = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    submitHashtag.click();
  }

  private void clickNewPhotoFromFeedWithxPath(String xPath) {
    WebElement clickPicHashtag = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    clickPicHashtag.click();
    clickPicHashtag.click();
  }

  private void performLikes() {
    WebElement performLike = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
            "/html/body/div[3]/div/div[2]/div/article/div[2]/section[1]/a[1]")));
    performLike.click();
  }

  private void nextPic() {
    WebElement nextPic = (new WebDriverWait(driver, 5))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/div/div/a[2]")));
    nextPic.click();
  }
}
