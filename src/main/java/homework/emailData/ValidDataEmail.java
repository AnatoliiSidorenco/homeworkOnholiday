package homework.emailData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ValidDataEmail {
    ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("Bob");
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        //  оставляю незаполненное поле Address и Phone
    }
    @Test
    public void validEmail1() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys(" john@ex.com");
        sleep(500);
    }
    @Test
    public void validEmail2() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("tes.123@e.com");
        sleep(500);
    }
    @Test
    public void validEmail3() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("john-doe@ple.co.uk");
        sleep(500);
    }
    @Test
    public void validEmail4() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("wEsT123@le.com");
        sleep(500);
    }
    @Test
    public void validEmail5() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("john_doe@mp.org");
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
