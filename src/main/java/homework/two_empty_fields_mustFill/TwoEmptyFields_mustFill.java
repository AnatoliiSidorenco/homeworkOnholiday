package homework.two_empty_fields_mustFill;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class TwoEmptyFields_mustFill {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    //-todo------First name заполнил, остальные пустые, должно появиться validationMessage в поле Last name. Поэтому проверка assertEquals по второму полю-------------------------
    @Test
    public void firstNameInputIsFilled() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firstNameInputField.sendKeys("John");
        sleep(500);
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        WebElement lastNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        assertEquals("Заполните это поле.", lastNameInputField.getAttribute("validationMessage")); // todo атрибут в Properties

    }

    //-todo------Last name  заполнил, остальные пустые, должно появиться validationMessage в поле First name. Поэтому проверка assertEquals по первому полю-------------------------
    @Test
    public void lastNameInputIsFilled() throws InterruptedException {
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        sleep(500);
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        assertEquals("Заполните это поле.", firsNameInputField.getAttribute("validationMessage"));

    }

    //-todo------Email заполнил, остальные пустые, должно появиться validationMessage в поле First  name. Поэтому проверка assertEquals по первому полю-------------------------
    @Test
    public void emailInputIsFilled() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        sleep(500);
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        assertEquals("Заполните это поле.", firsNameInputField.getAttribute("validationMessage"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
