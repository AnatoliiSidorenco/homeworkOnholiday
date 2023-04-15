package homework.registration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Registration {

    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }


    @Test
    public void sucssesfulRegAllFields() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("John");
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("+4915175589654");
        WebElement addressInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control second']"));
        addressInputField.sendKeys("wersernstrasse - 11");
        // sleep(5000); // если перед click поставить sleep, то есть возможность глянуть или все заполнил (только для себя, потом удалить)
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        WebElement successText = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", successText.getText());
        WebElement containsText = driver.findElement(By.tagName("h1"));
        assertTrue(containsText.getText().contains("Congratulations!"));

        assertTrue(driver.getCurrentUrl().contains("/registration_result.html?"));


        sleep(1000);
    }


    @Test
    public void withoutFirstName() throws InterruptedException {

        /** WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
         firsNameInputField.sendKeys("John");
         **/
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();

        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        assertEquals("Заполните это поле.", firsNameInputField.getAttribute("validationMessage"));
        assertTrue(firsNameInputField.getAttribute("validationMessage").contains("Заполните"));
        //validationMessage:"Заполните это поле."
        sleep(1000);
    }

//todo -------------------------Empty Field LastName---------------------------------------------

    @Test
    public void emptyFieldLastName() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("John");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        sleep(500);
        WebElement lastNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        assertEquals("Заполните это поле.", lastNameInputField.getAttribute("validationMessage"));
    }


    //todo -------------------------Empty Field Email---------------------------------------------

    @Test
    public void emptyFieldEmail() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("John");
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickOnButtonSubmit.click();
        sleep(500);
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        assertEquals("Заполните это поле.", emailInputField.getAttribute("validationMessage"));
    }

    //todo -------------------------Empty Field Address and Phone---------------------------------------------

    @Test
    public void emptyFieldAddressPhone() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("John");
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        sleep(1500);
        clickOnButtonSubmit.click();
        WebElement successText = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", successText.getText());
    }

    //todo -------------------------Empty All Fields---------------------------------------------
// оставляю все поля пустые, клик на кнопку, не проходить, заполните First name field. Поэтому и проверка по этому полю
    @Test
    public void emptyAllFields() throws InterruptedException {
        WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        sleep(1500);
        clickOnButtonSubmit.click();
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        assertEquals("Заполните это поле.", firsNameInputField.getAttribute("validationMessage"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
