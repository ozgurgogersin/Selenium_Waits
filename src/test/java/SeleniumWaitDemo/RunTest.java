package SeleniumWaitDemo;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTest extends BaseDriver {

    WebDriverWait explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Test(enabled = false)
    public void register() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();

        WebElement gender = driver.findElement(By.id("gender-male"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(gender));
        gender.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.sendKeys("SeleniumWaits");

        WebElement lastName = driver.findElement(By.id("LastName"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
        lastName.sendKeys("Testing");

        WebElement email = driver.findElement(By.id("Email"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
        email.sendKeys("seleniumWaits@gmail.com");

        WebElement passWord = driver.findElement(By.id("Password"));
        explicitlyWait.until(ExpectedConditions.visibilityOf(passWord));
        passWord.sendKeys("Qwerty!");

        WebElement confirmPassWord = driver.findElement(By.id("ConfirmPassword"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.id("ConfirmPassword")));
        confirmPassWord.sendKeys("Qwerty!");

        WebElement registerButton = driver.findElement(By.id("register-button"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.id("register-button")));
        registerButton.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Continue']")));
        continueButton.click();

        WebElement logOut = driver.findElement(By.xpath("//a[text()='Log out']"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Log out']")));
        logOut.click();


    }

    @Test(priority = 1)
    public void testCase1_validCredentials() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys("seleniumWaits@gmail.com");

        WebElement passWord = driver.findElement(By.id("Password"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(passWord));
        passWord.sendKeys("Qwerty!");

        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement approval = driver.findElement(By.linkText("seleniumWaits@gmail.com"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("seleniumWaits@gmail.com")));
        Assert.assertTrue(approval.getText().contains("@"));

        WebElement logOut = driver.findElement(By.xpath("//a[text()='Log out']"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Log out']")));
        logOut.click();

    }

    @Test(priority = 2)
    public void testCase2_wrongEmail() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        //valid email is seleniumWaits@gmail.com
        WebElement email = driver.findElement(By.id("Email"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys("seleniumWaitsWrong@gmail.com");

        WebElement passWord = driver.findElement(By.id("Password"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(passWord));
        passWord.sendKeys("Qwerty!");

        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement approval = driver.findElement(By.xpath("//li[text()='No customer account found']"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='No customer account found']")));
        Assert.assertTrue(approval.getText().equals("No customer account found"));
        String expectedEmail = "seleniumWaitsworngpw@gmail.com";
        Assert.assertNotEquals(email, expectedEmail);

    }

    @Test(priority = 3)
    public void testCase2_wrongPassword() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys("seleniumWaits@gmail.com");
        //valid password is Qwerty!
        WebElement passWord = driver.findElement(By.id("Password"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(passWord));
        passWord.sendKeys("Qwerty");

        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement approval = driver.findElement(By.xpath("//li[text()='The credentials provided are incorrect']"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='The credentials provided are incorrect']")));
        Assert.assertTrue(approval.getText().equals("The credentials provided are incorrect"));
        String expectedPassword = "Qwerty!";
        Assert.assertNotEquals(passWord, expectedPassword);

    }

    @Test(priority = 4)
    public void testCase2_invalidCredentials() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        //valid email is seleniumWaits@gmail.com
        WebElement email = driver.findElement(By.id("Email"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys("seleniumWaitsWrong@gmail.com");
        //valid password is Qwerty!
        WebElement passWord = driver.findElement(By.id("Password"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(passWord));
        passWord.sendKeys("Qwerty");

        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement approval = driver.findElement(By.xpath("//li[text()='No customer account found']"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='No customer account found']")));
        Assert.assertTrue(approval.getText().contains("No customer account found"));

    }

    @Test(dependsOnMethods = "testCase2_invalidCredentials")
    public void TestCase3_placeAndOrder() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys("seleniumWaits@gmail.com");

        WebElement passWord = driver.findElement(By.id("Password"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(passWord));
        passWord.sendKeys("Qwerty!");

        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement selectVirtualGiftCard = driver.findElement(By.linkText("$25 Virtual Gift Card"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(selectVirtualGiftCard));
        selectVirtualGiftCard.click();

        WebElement reciepentName = driver.findElement(By.id("giftcard_2_RecipientName"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(reciepentName));
        reciepentName.sendKeys("seleniumWaitsTest");

        WebElement reciepentEmail = driver.findElement(By.id("giftcard_2_RecipientEmail"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(reciepentEmail));
        reciepentEmail.sendKeys("seleniumWaits@gmail.com");

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-2"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        WebElement barNotificationSuccessAlert = driver.findElement(By.linkText("shopping cart"));
        explicitlyWait.until(ExpectedConditions.visibilityOf(barNotificationSuccessAlert));
        barNotificationSuccessAlert.click();

        WebElement acceptTerms = driver.findElement(By.id("termsofservice"));
        if (!acceptTerms.isSelected()) {
            explicitlyWait.until(ExpectedConditions.visibilityOf(acceptTerms));
            acceptTerms.click();
        }

        WebElement checkOut = driver.findElement(By.id("checkout"));
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(checkOut));
        checkOut.click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://demowebshop.tricentis.com/onepagecheckout"));

        WebElement logOut = driver.findElement(By.xpath("//a[text()='Log out']"));
        explicitlyWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Log out']")));
        logOut.click();
        driver.quit();
    }
}
