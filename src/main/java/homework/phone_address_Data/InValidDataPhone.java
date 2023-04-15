package homework.phone_address_Data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class InValidDataPhone {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    @Before
    public void validData() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("Bob");
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement addressInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control second']"));
        addressInputField.sendKeys("wersernstrasse - 11");
    }

    @Test
    public void invalidEmail1() throws InterruptedException {
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("123A");
        sleep(500);
    }

    @Test
    public void invalidEmail2() throws InterruptedException {
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("lkl");
        sleep(500);
    }

    @Test
    public void invalidEmail3() throws InterruptedException {
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("! # $ % & '  *  , - . / : ; < = > ? @ [ \\ ] ^ _ ` { | } ~\t\t");
        sleep(500);
    }

    @Test
    public void invalidEmail4() throws InterruptedException {
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys(" ");
        sleep(500);
    }

    @Test
    public void invalidEmail5() throws InterruptedException {
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("1");
        sleep(500);
    }

    //todo ---------------------Тест падает так как я ожидаю что появиться предупреждение, а взамен идет успешная регистрация----------------------------------
    @After
    public void validationMessageErrorFirstname() {
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        assertEquals("Неверные данные", firsNameInputField.getAttribute("validationMessage"));
        driver.quit();
    }
/**
 //--todo --------------------Проверка теста, или работает логика в целом----------------------------------------------------------
 @After public void tearDown() throws InterruptedException {
 WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
 clickOnButtonSubmit.click();
 WebElement successText = driver.findElement(By.tagName("h1"));
 assertEquals("Congratulations! You have successfully registered!", successText.getText());
 sleep(500);
 driver.quit();
 }
 **/

}
