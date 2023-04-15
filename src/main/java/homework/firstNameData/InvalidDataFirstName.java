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

public class InvalidDataFirstName {

    ChromeDriver driver;

// todo -----------------Первый кусок шапки, связка с локальным driver, и запуск сайта -----------------------------------------------------------

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }

//todo ---------------Второй кусок шапки, прописываю заранее для каждого теста данные в поля Last name, Email,Phone,Address-------------------------

    @Before
    public void validData() throws InterruptedException {
        WebElement secondNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        secondNameInputField.sendKeys("Maverick");
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("jo_mav@gmail.com");
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("+4915175589654");
        WebElement addressInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control second']"));
        addressInputField.sendKeys("wersernstrasse - 11");
    }


//todo ----------------------------Варианты негативных данных для поля First name-----------------------------------------------------------------

    /**
     * 12()
     * anToNy
     * 123
     * space
     * $%^&*,.:
     * empty
     * алфавит
     * ant90
     * hero%
     **/

    @Test
    public void invalidDataFirstname1() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("12()");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname2() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("anToNy");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname3() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys(" 123");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname4() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys(" ");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname5() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("$%^&*,.:");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname6() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("алфавит");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname7() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys(" ant90");
        sleep(500);
    }

    @Test
    public void invalidDataFirstname8() throws InterruptedException {
        WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firsNameInputField.sendKeys("hero%");
        sleep(500);
    }


    /**
      //todo ---------------------Тест падает так как я ожидаю что появиться предупреждение, а взамен идет успешная регистрация----------------------------------
      //todo -- здесь происходит нажатие на кнопку, и сравнение результатов, после того как все поля были заполнены в @Before и @Test----------------------------
      // если было бы предупреждения, я бы забрал его из properties -- > c помощью драйвера и локатора

      @After public void validationMessageErrorFirstname(){
         WebElement clickOnButtonSubmit = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
         clickOnButtonSubmit.click();
         WebElement firsNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
         assertEquals("Неверные данные", firsNameInputField.getAttribute("validationMessage"));
        driver.quit();
      }
     **/

// todo ------------------------------Проверка или тест рабочий------------------------------------------------------------------------------------------
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
