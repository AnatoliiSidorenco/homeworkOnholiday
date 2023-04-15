package homework.firstNameData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ValidDataFirstName {
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
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("+4915175589654");
        // Поочереди оставляю незаполненное поле Address

    }

    //todo ---------------------------Варианты положительных данных для поля First name

    /**
     * John
     * Johnathaniel
     * Jo
     * Jo Hanry
     * Daniel-Andrew
     **/


    @Test
    public void validDataFirstname1() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("John");
        sleep(500);
    }

    @Test
    public void validDataFirstname2() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("Johnathaniel");
        sleep(500);
    }

    @Test
    public void validDataFirstname3() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("Jo");
        sleep(500);
    }


    @Test
    public void validDataFirstname4() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("Jo Hanry");
        sleep(500);
    }

    @Test
    public void validDataFirstname5() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("Jo Hanry");
        sleep(500);
    }


    @After
    public void tearDown() throws InterruptedException {
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        WebElement successText = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", successText.getText());
        sleep(500);
        driver.quit();
    }

}
